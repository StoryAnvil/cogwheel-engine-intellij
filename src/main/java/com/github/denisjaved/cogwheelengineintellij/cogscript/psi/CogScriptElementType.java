package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptLang;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CogScriptElementType extends IElementType {
    public CogScriptElementType(@NonNls @NotNull String debugName) {
        super(debugName, CogScriptLang.INSTANCE);
    }
}
