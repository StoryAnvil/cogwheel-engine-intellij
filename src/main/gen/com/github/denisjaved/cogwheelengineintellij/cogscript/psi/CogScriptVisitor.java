// This is a generated file. Not intended for manual editing.
package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CogScriptVisitor extends PsiElementVisitor {

  public void visitKeywords(@NotNull CogScriptKeywords o) {
    visitPsiElement(o);
  }

  public void visitNamedVariable(@NotNull CogScriptNamedVariable o) {
    visitNamedVariable(o);
  }

  public void visitVariableName(@NotNull CogScriptVariableName o) {
    visitNamedVariable(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
