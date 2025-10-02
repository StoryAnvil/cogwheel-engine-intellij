//package com.github.denisjaved.cogwheelengineintellij.cogscript;
//
//import com.github.denisjaved.cogwheelengineintellij.cogscript.data.InspectionType;
//import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenSets;
//import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
//import com.intellij.lang.ASTNode;
//import com.intellij.lang.annotation.AnnotationBuilder;
//import com.intellij.lang.annotation.AnnotationHolder;
//import com.intellij.lang.annotation.Annotator;
//import com.intellij.lang.annotation.HighlightSeverity;
//import com.intellij.openapi.util.TextRange;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.tree.IElementType;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Set;
//
//import static com.github.denisjaved.cogwheelengineintellij.Bundle.lazyMessage;
//
//public class CogScriptAnnotator implements Annotator {
//
//    public static final HighlightSeverity SUPPRESSED_SEVERITY = new HighlightSeverity("Suppressed", Integer.MIN_VALUE, lazyMessage("SeveritySuppressed"), lazyMessage("SeveritySUPPRESSED"), lazyMessage("SeveritySuppressedCounter"));
//    public static final InspectionType REDEFINED_SYSTEM_VARIABLE = new InspectionType("InspectionSysVariable");
//    public static final Set<String> SYSTEM_VARIABLES = Set.of("Cogwheel", "true", "false", "MANIFEST");
//
//    @Override
//    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
//        IElementType type = element.getNode().getElementType();
//        if (!(CogScriptTokenSets.ALL.contains(type))) return;
//        Set<String> suppression = walkForSuppression(element);
//
//        if (type.equals(CogScriptTypes.EXPR_VARNAME)) {
//            // Element is name of variable definition:
//            //
//            //   VARNAME = <EXPR>
//            //   ^^^^^^^
//            String definedVariableName = element.getNode().getText();
//            if (SYSTEM_VARIABLES.contains(definedVariableName)) {
//                inspection(HighlightSeverity.WARNING, REDEFINED_SYSTEM_VARIABLE, element,
//                        suppression, holder).create();
//            }
//        }
//    }
//
//    private @NotNull Set<String> walkForSuppression(@NotNull PsiElement element) {
//        boolean passedLineTerminator = false;
//        PsiElement parent = element;
//        while (parent != null) {
//            IElementType type = parent.getNode().getElementType();
//            if (type.equals(CogScriptTypes.COMMENT)) {
//                String text = parent.getNode().getText();
//                if (text.startsWith("# noinspection ")) {
//                    return Set.of(text.substring(15).split(","));
//                }
//            } else if (type.equals(CogScriptTypes.LINE_TERMINATOR)) {
//                if (passedLineTerminator) break;
//                passedLineTerminator = true;
//            }
//            parent = parent.getPrevSibling();
//        }
//        return Set.of();
//    }
//
//    private AnnotationBuilder inspection(HighlightSeverity severity, InspectionType type, Object range, Set<String> suppression, AnnotationHolder holder) {
//        if (suppression.contains(type.id())) {
//            severity = SUPPRESSED_SEVERITY;
//        }
//        AnnotationBuilder builder = holder.newAnnotation(severity, type.getMessage())
//                .problemGroup(type);
//
//        if (range instanceof PsiElement element) {
//            builder = builder.range(element);
//        } else if (range instanceof ASTNode node) {
//            builder = builder.range(node);
//        } else if (range instanceof TextRange node) {
//            builder = builder.range(node);
//        }
//        return builder;
//    }
//}
