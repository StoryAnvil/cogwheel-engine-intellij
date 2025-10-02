package com.github.denisjaved.cogwheelengineintellij.cogscript.data;

import com.github.denisjaved.cogwheelengineintellij.Bundle;
import com.intellij.codeInspection.SuppressIntentionAction;
import com.intellij.codeInspection.SuppressableProblemGroup;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record InspectionType(String id) implements SuppressableProblemGroup {
    public static final SuppressIntentionAction[] ACTION = new SuppressIntentionAction[]{
            new SuppressIntentionAction() {
                @Override
                public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement element) throws IncorrectOperationException {

                }

                @Override
                public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
                    return false;
                }

                @Override
                public @NotNull @IntentionFamilyName String getFamilyName() {
                    return "";
                }
            }
    };

    @Override
    public SuppressIntentionAction @NotNull [] getSuppressActions(@Nullable PsiElement element) {
        return ACTION;
    }

    @Override
    public @NotNull String getProblemName() {
        return Bundle.message(id);
    }

    public String getMessage() {
        return Bundle.message(id + "Msg");
    }
}
