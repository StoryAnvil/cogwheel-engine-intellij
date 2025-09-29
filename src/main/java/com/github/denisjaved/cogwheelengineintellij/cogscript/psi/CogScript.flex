package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.cogscript.data.Expression;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenType;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.github.denisjaved.cogwheelengineintellij.B2;
import java.util.Stack;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenType.For;

%%

%class CogScriptLexer
%implements FlexLexer
%unicode
%function advance
%public
%type IElementType
%eof{  return;
%eof}
%{
    Expression expression = new Expression();
%}
LineTerminator = \r\n|\n\r|\n|\r
WhiteSpace = [ ]
%state IF_STATEMENT_HEAD
%state IF_STATEMENT_TAIL
%state EXPRESSION
%state EXPRESSION_VAR
%state EXPRESSION_VAR2
%state EXPRESSION_QUOTE
%state FAIL_LINE_EXPR
%state INITIAL
%state COMMENT
%%

<YYINITIAL> {
    {WhiteSpace}+ {return CogScriptTypes.HEAD_WHITESPACE;}
    [^] {yybegin(INITIAL); yypushback(1); return CogScriptTypes.BAD_CHARACTER;}
}
<INITIAL> {
    {LineTerminator} {return CogScriptTypes.HEAD_WHITESPACE;}
    (\#).* {yybegin(COMMENT); return CogScriptTypes.COMMENT; }
    if[{WhiteSpace}] {yybegin(IF_STATEMENT_HEAD); expression.clear(); return CogScriptTypes.KEYWORD; }
    "}" {return CogScriptTypes.BRACKETS;}
    [^] {yybegin(EXPRESSION); yypushback(1); expression.clear(); expression.push(new Expression.DepthData(YYINITIAL)); return CogScriptTypes.EXPR;}
}
<COMMENT> {
    {LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.WHITESPACE;}
    [^] {yybegin(COMMENT); return CogScriptTypes.COMMENT;}
}
<IF_STATEMENT_HEAD> {
    "(" {yybegin(EXPRESSION); expression.push(new Expression.DepthData(IF_STATEMENT_TAIL)); return CogScriptTypes.BRACKETS;}
}
<IF_STATEMENT_TAIL> {
    ")"{WhiteSpace}*"{"{LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.BRACKETS;}
}
<EXPRESSION> {
    "(" {
        // Add one point to expression depth
        expression.peek().depth += 1;
        return For(expression, CogScriptTypes.EXPR_BRACKET);
    }
    ")" {
            expression.peek().depth -= 1;
            if (expression.peek().depth == -1) {
                // Leave expression as last bracket closed
                if (expression.peek().type == Expression.Type.NORMAL) {
                    yypushback(1);
                }
                yybegin(expression.pop().nextState);
                return For(expression, CogScriptTypes.EXPR_BRACKET);
            }
            return For(expression, CogScriptTypes.EXPR_BRACKET);
        }
    {LineTerminator} {
          // Leave expression because line ended
          yybegin(expression.pop().nextState);
          return CogScriptTypes.WHITESPACE;
    }
    "^"[0-9]+"L"? {
          return CogScriptTypes.EXPR_NUMERIC;
      }
    [a-zA-Z0-9_$]+\( {
            if (expression.peek().hasRoot) {
                expression.push(new Expression.DepthData(-1 /* Start with negetive depth to cancel out pushed back openning bracket */, EXPRESSION));
                expression.peek().type = Expression.Type.COMMA_SEPARATED;
                yypushback(1);
                yybegin(EXPRESSION);
                return For(expression, CogScriptTypes.EXPR_PROP);
            }
        }
    [a-zA-Z0-9_$]+[ ]*"="[ ]* {
        if (expression.peek().hasVariable) {
            return CogScriptTypes.BAD_CHARACTER; // WTF? Two variable defenitions??
        } else {
            expression.peek().hasVariable = true;
            yybegin(EXPRESSION_VAR);
            yypushback(yylength()); // Fully pushback entire variable defenition
            return CogScriptTypes.BAD_CHARACTER;
        }
    }
    [a-zA-Z0-9_$]+ {
        if (!expression.peek().hasRoot) {
            expression.peek().hasRoot = true;
            return For(expression, CogScriptTypes.EXPR_ROOT);
        } else {
            return For(expression, CogScriptTypes.BAD_CHARACTER); // WTF? Two expressions roots??
        }
    }
    "," {
        if (expression.peek().type == Expression.Type.COMMA_SEPARATED) {
            yybegin(expression.pop().nextState);
            expression.push(new Expression.DepthData(EXPRESSION));
            expression.peek().type = Expression.Type.COMMA_SEPARATED;
            return For(expression, CogScriptTypes.BRACKETS);
        }
    }
    "\"" {
          yybegin(EXPRESSION_QUOTE);
          return CogScriptTypes.EXPR_STR;
    }
    [^] {return For(expression, CogScriptTypes.EXPR);}
}
<EXPRESSION_QUOTE> {
    "\"" {
          yybegin(EXPRESSION);
          return CogScriptTypes.EXPR_STR;
    }
    {LineTerminator} {
          yybegin(YYINITIAL);
          return CogScriptTypes.WHITESPACE;
    }
    [^\"\n\r]+ {
          return CogScriptTypes.EXPR_STR;
    }
}
<EXPRESSION_VAR> {
    {LineTerminator} {
              yybegin(YYINITIAL);
              return CogScriptTypes.WHITESPACE;
    }
    [a-zA-Z0-9_$]+ {
        yybegin(EXPRESSION_VAR2);
        return CogScriptTypes.EXPR_VARNAME;
    }
}
<EXPRESSION_VAR2> {
    {LineTerminator} {
        yybegin(YYINITIAL);
        return CogScriptTypes.WHITESPACE;
    }
    {WhiteSpace}*"="{WhiteSpace}* {
        yybegin(EXPRESSION); // Variable defenition ended. Return to expression handler
        return CogScriptTypes.BRACKETS;
    }
}
<FAIL_LINE_EXPR> {
    {LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.BAD_CHARACTER;}
    [^] {return CogScriptTypes.BAD_CHARACTER;}
}

"}" {return CogScriptTypes.BRACKETS; }
{WhiteSpace} {yybegin(YYINITIAL); return CogScriptTypes.WHITESPACE;}
[^] {return CogScriptTypes.BAD_CHARACTER; }
