package com.github.denisjaved.cogwheelengineintellij.cogscript.psi.impl;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptElementFactory;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.NamedVariable;
import com.github.denisjaved.cogwheelengineintellij.cogscript.references.CogScriptVariableReference;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.SmartList;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class NamedVariableImpl extends ASTWrapperPsiElement implements NamedVariable, PsiNamedElement {
    public NamedVariableImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        return this.getText();
    }

    @Override
    public PsiElement setName(@NotNull String name) {
        PsiElement element = CogScriptElementFactory.createVARNAME(getProject(), name);
        getParent().getNode().replaceChild(this.getNode(), CogScriptTypes.Factory.createElement(
                element.getNode()
        ).getNode());
        return element;
    }

    @Override
    public PsiElement getNameIdentifier() {
        return this.getNode().getPsi();
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        SmartList<PsiReference> references = new SmartList<>();
        references.add(new CogScriptVariableReference(this, getName()));
        references.addAll(Arrays.asList(ReferenceProvidersRegistry.getReferencesFromProviders(this)));
        return references.toArray(new PsiReference[0]);
    }

    @Override
    public PsiReference getReference() {
        return new CogScriptVariableReference(this, getName());
    }
}
