package com.github.denisjaved.cogwheelengineintellij.cogscript.inspections;

import com.github.denisjaved.cogwheelengineintellij.cogscript.data.FixedCogScriptVisitor;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptVariableName;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static com.github.denisjaved.cogwheelengineintellij.Bundle.message;

public class RedefinedDefaultVariable extends LocalInspectionTool {
                              // toLowerCase is called before matching. All entries should be lowercase
    public static final Set<String> DEFAULT_VARIABLES = Set.of("cogwheel", "true", "false", "manifest");

    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new FixedCogScriptVisitor() {
            @Override
            public void visitVariableName(@NotNull CogScriptVariableName o) {
                if (DEFAULT_VARIABLES.contains(o.getText().toLowerCase())) {
                    holder.registerProblem(o,
                            message("inspection.cogscript.RedefinedDefaultVariable.template"),
                            ProblemHighlightType.WARNING);
                }
            }
        };
    }
}
