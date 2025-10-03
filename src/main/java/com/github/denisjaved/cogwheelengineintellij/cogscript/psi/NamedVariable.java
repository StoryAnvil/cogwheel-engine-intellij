package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

public interface NamedVariable extends PsiNameIdentifierOwner, PsiNamedElement {
    @Override
    PsiReference @NotNull [] getReferences();
}
