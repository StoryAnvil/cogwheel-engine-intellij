package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptLang;
import com.github.denisjaved.cogwheelengineintellij.cogscript.data.Expression;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CogScriptTokenType extends IElementType {
    public CogScriptTokenType(@NonNls @NotNull String debugName) {
        super(debugName, CogScriptLang.INSTANCE);
    }

    @Override
    public String toString() {
        return "CogScriptTokenFaction." + super.toString();
    }

    @SuppressWarnings("UnstableApiUsage") @ApiStatus.Experimental // This method is unstable too and used only for debugging
    public static IElementType For(Expression expr, IElementType thiz) {
//        if (expr.peekSafe() != null)
//            return new CogScriptIntTokenType(thiz.getDebugName(), expr.peek().id);
        return thiz;
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
