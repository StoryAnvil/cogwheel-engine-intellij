package com.github.denisjaved.cogwheelengineintellij.cogscript.references;

import com.github.denisjaved.cogwheelengineintellij.Bundle;
import com.github.denisjaved.cogwheelengineintellij.cogscript.data.FixedCogScriptVisitor;
import com.github.denisjaved.cogwheelengineintellij.cogscript.data.RecursiveFixedCogScriptVisitor;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptNamedVariable;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CogScriptVariableReference extends PsiPolyVariantReferenceBase<PsiElement> {
    private final String variableName;
    public CogScriptVariableReference(@NotNull PsiElement element, TextRange range, String variableName) {
        super(element, range);
        this.variableName = variableName;
    }

    public CogScriptVariableReference(@NotNull PsiElement psiElement, String variableName) {
        super(psiElement, new TextRange(0, psiElement.getTextLength()));
        this.variableName = variableName;
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();
        myElement.getContainingFile().accept(new RecursiveFixedCogScriptVisitor() {
            @Override
            public void visitNamedVariable(@NotNull CogScriptNamedVariable o) {
                results.add(new PsiElementResolveResult(o, true));
            }
        });
        return results.toArray(new ResolveResult[0]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length >= 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        List<LookupElement> variants = new ArrayList<>();
        myElement.getContainingFile().accept(new RecursiveFixedCogScriptVisitor() {
            @Override
            public void visitNamedVariable(@NotNull CogScriptNamedVariable o) {
                variants.add(LookupElementBuilder.create(o));
            }
        });
        return variants.toArray();
    }
}
