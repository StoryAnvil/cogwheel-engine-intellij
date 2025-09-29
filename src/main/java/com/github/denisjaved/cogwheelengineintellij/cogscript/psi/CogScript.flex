package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenType;import com.intellij.psi.tree.IElementType;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.github.denisjaved.cogwheelengineintellij.B2;
import java.util.Stack;
import com.intellij.lexer.FlexLexer;

%%

%class CogScriptLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    Stack<B2<Integer, Integer>> expressionDepth = new Stack<B2<Integer, Integer>>();
%}
LineTerminator = \r\n|\n\r|\n|\r
WhiteSpace = [ ]
//NotLetter = [^a-zA-Z0-9]
%state IF_STATEMENT_HEAD
%state IF_STATEMENT_TAIL
%state EXPRESSION
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
    if[{WhiteSpace}] {yybegin(IF_STATEMENT_HEAD); return CogScriptTypes.KEYWORD; }
    [^] {yybegin(EXPRESSION); expressionDepth.clear(); expressionDepth.push(new B2<>(0, YYINITIAL)); return CogScriptTypes.EXPR;}
}
<COMMENT> {
    {LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.WHITESPACE;}
    [^] {yybegin(COMMENT); return CogScriptTypes.COMMENT;}
}
<IF_STATEMENT_HEAD> {
    "(" {yybegin(EXPRESSION); expressionDepth.push(new B2<>(0, IF_STATEMENT_TAIL)); return CogScriptTypes.BRACKETS;}
}
<IF_STATEMENT_TAIL> {
    {WhiteSpace}*"{"{LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.BRACKETS;}
}
<EXPRESSION> {
    "(" {
        // Add one point to expression depth
        expressionDepth.peek().a += 1;
        return CogScriptTypes.EXPR;
      }
    ")" {
        expressionDepth.peek().a -= 1;
        if (expressionDepth.peek().a == -1) {
            // Leave expression as last bracket closed
            yybegin(expressionDepth.pop().b);
            return CogScriptTypes.BRACKETS;
        }
        return CogScriptTypes.EXPR;
      }
    {LineTerminator} {
//          if (expressionDepth.peek().a == 0) {
//              // Fail this line because expression did not close all openning brackets
//              //yybegin(FAIL_LINE_EXPR);
//          }
          // Leave expression because line ended
          yybegin(expressionDepth.pop().b);
          return CogScriptTypes.WHITESPACE;
      }
    [^] {return CogScriptTypes.EXPR;}
}

<FAIL_LINE_EXPR> {
    {LineTerminator} {yybegin(YYINITIAL); return CogScriptTypes.BAD_CHARACTER;}
    [^] {return CogScriptTypes.BAD_CHARACTER;}
}

"}" {return CogScriptTypes.BRACKETS; }
{WhiteSpace} {yybegin(YYINITIAL); return CogScriptTypes.WHITESPACE;}
[^] {return CogScriptTypes.BAD_CHARACTER; }
