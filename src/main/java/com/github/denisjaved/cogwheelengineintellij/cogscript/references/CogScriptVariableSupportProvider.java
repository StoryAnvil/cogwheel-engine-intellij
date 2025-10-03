package com.github.denisjaved.cogwheelengineintellij.cogscript.references;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptNamedVariable;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CogScriptVariableSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof CogScriptNamedVariable;
    }
}
