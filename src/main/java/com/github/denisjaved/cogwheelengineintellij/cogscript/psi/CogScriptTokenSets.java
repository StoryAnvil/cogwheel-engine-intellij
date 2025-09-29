package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.intellij.psi.tree.TokenSet;

public interface CogScriptTokenSets {
    TokenSet COMMENTS = TokenSet.create(CogScriptTypes.COMMENT);
    /**
     * (C)o(G)(P)roperty(M)anager
     */
    TokenSet CGPM = TokenSet.create(CogScriptTypes.EXPR_ROOT, CogScriptTypes.EXPR_PROP);
    TokenSet LITERALS = TokenSet.create(CogScriptTypes.EXPR_NUMERIC, CogScriptTypes.EXPR_STR);
}
