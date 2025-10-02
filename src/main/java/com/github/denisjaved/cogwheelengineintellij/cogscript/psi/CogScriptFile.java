package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptFileType;
import com.github.denisjaved.cogwheelengineintellij.cogscript.CogScriptLang;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class CogScriptFile extends PsiFileBase {
    public CogScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CogScriptLang.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return CogScriptFileType.INSTANCE;
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "CogScript File";
    }
}
