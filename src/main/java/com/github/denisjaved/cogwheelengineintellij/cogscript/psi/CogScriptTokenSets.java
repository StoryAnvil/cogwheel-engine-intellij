package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.intellij.psi.tree.TokenSet;

public interface CogScriptTokenSets {
    TokenSet ALL = TokenSet.create(
            CogScriptTypes.COMMENT,
            CogScriptTypes.KEYWORD,
            CogScriptTypes.BRACKETS,
            CogScriptTypes.EXPR,
            CogScriptTypes.WHITESPACE,
            CogScriptTypes.HEAD_WHITESPACE,
            CogScriptTypes.EXPR_ROOT,
            CogScriptTypes.EXPR_PROP,
            CogScriptTypes.EXPR_STR,
            CogScriptTypes.EXPR_NUMERIC,
            CogScriptTypes.EXPR_VARNAME,
            CogScriptTypes.EXPR_BRACKET,
            CogScriptTypes.LINE_TERMINATOR,
            CogScriptTypes.BAD_CHARACTER
    );

    TokenSet COMMENTS = TokenSet.create(CogScriptTypes.COMMENT);
    /**
     * (C)o(G)(P)roperty(M)anager
     */
    TokenSet CGPM = TokenSet.create(CogScriptTypes.EXPR_ROOT, CogScriptTypes.EXPR_PROP);
    TokenSet LITERALS = TokenSet.create(CogScriptTypes.EXPR_NUMERIC, CogScriptTypes.EXPR_STR);
    TokenSet STRING_LITERALS = TokenSet.create(CogScriptTypes.EXPR_STR);

    TokenSet NAMED_VARIABLES = TokenSet.create(CogScriptTypes.EXPR_VARNAME, CogScriptTypes.EXPR_ROOT);
}
