package com.github.denisjaved.cogwheelengineintellij.cogscript.references;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptNamedVariable;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenSets;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;

public class CogScriptReferenceContributor extends PsiReferenceContributor {

    private static final Log log = LogFactory.getLog(CogScriptReferenceContributor.class);

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement().withElementType(CogScriptTokenSets.NAMED_VARIABLES),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        log.info("AAAAAAAAAAAAAAAA! " + element.getClass().getCanonicalName() + " : " + element + " | " + element.getText());
                        if (!(element instanceof CogScriptNamedVariable)) return new PsiReference[0];
                        CogScriptNamedVariable variable = (CogScriptNamedVariable) element;
                        return new PsiReference[]{new CogScriptVariableReference(element, variable.getText())};
                    }
                });
    }
}
