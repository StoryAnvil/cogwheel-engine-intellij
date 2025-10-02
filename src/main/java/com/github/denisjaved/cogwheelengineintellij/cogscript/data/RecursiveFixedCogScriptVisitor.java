package com.github.denisjaved.cogwheelengineintellij.cogscript.data;

import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecursiveFixedCogScriptVisitor extends FixedCogScriptVisitor implements PsiRecursiveVisitor {
    public void visitElement(final @NotNull PsiElement element) {
        ProgressIndicatorProvider.checkCanceled();
        element.acceptChildren(this);
    }

    @Override
    public void visitFile(final @NotNull PsiFile file) {
//        if (myVisitAllFileRoots) {
            final FileViewProvider viewProvider = file.getViewProvider();
            final List<PsiFile> allFiles = viewProvider.getAllFiles();
            if (allFiles.size() > 1) {
                if (file == viewProvider.getPsi(viewProvider.getBaseLanguage())) {
                    for (PsiFile lFile : allFiles) {
                        ProgressIndicatorProvider.checkCanceled();
                        lFile.acceptChildren(this);
                    }
                    return;
                }
            }
//        }

        super.visitFile(file);
    }
}
