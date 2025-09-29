package com.github.denisjaved.cogwheelengineintellij.cogscript.psi.impl;

import com.github.denisjaved.cogwheelengineintellij.Bundle;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptProperty;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.intellij.psi.tree.IElementType;

import java.util.function.Supplier;

public enum CogScriptTokenFaction {
    LITERAL,
    PROPERTY,
    VARIABLE,
    UNCLASSIFIED;

    public final Supplier<String> displayName;

    CogScriptTokenFaction() {
        this.displayName = Bundle.lazyMessage("Faction" + this.name());
    }

    public static CogScriptTokenFaction stGetType(CogScriptProperty prop) {
        IElementType type = prop.getNode().getElementType();
        if (type.equals(CogScriptTypes.EXPR_NUMERIC) || type.equals(CogScriptTypes.EXPR_STR)) {
            return LITERAL;
        } else if (type.equals(CogScriptTypes.EXPR_PROP)) {
            return PROPERTY;
        } else if (type.equals(CogScriptTypes.EXPR_VARNAME) || type.equals(CogScriptTypes.EXPR_ROOT)) {
            return VARIABLE;
        }
        return UNCLASSIFIED;
    }
}
