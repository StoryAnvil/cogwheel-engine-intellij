package com.github.denisjaved.cogwheelengineintellij.json;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.json.psi.JsonElementVisitor;
import com.intellij.json.psi.JsonProperty;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

import static com.github.denisjaved.cogwheelengineintellij.Bundle.message;

public class JsonDiffInspection extends LocalInspectionTool {
    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new JsonElementVisitor() {
            @Override
            public void visitProperty(@NotNull JsonProperty o) {
                String name = o.getName();
                if (o.getContainingFile().getName().endsWith(".diff.json") && (name.startsWith("+") || name.startsWith("-"))) {
                    holder.registerProblem(o,
                            message("inspection.json.Diff"),
                            ProblemHighlightType.WARNING);
                }
            }
        };
    }
}
