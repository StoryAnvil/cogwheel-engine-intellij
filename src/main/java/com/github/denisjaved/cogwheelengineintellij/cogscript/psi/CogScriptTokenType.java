package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptLang;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CogScriptTokenType extends IElementType {
    public CogScriptTokenType(@NonNls @NotNull String debugName) {
        super(debugName, CogScriptLang.INSTANCE);
    }

    @Override
    public String toString() {
        return "CogScriptTokenType." + super.toString();
    }

    public static class CogScriptIntTokenType extends CogScriptTokenType {
        private final int i;

        public CogScriptIntTokenType(@NotNull String debugName, int i) {
            super(debugName);
            this.i = i;
        }

        @Override
        public String toString() {
            return super.toString() + '{' + i + '}';
        }
    }
}
