package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class CogScriptElementFactory {
    public static CogScriptFile createFile(Project project, String text) {
        String name = "dummy.simple";
        return (CogScriptFile) PsiFileFactory.getInstance(project).createFileFromText(name, CogScriptFileType.INSTANCE, text);
    }

    public static PsiElement createVARNAME(Project project, String name) {
        final CogScriptFile file = createFile(project, name + " = q");
        return file.getFirstChild();
    }
}
