// This is a generated file. Not intended for manual editing.
package com.github.denisjaved.cogwheelengineintellij.cogscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes.*;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.*;

public class CogScriptNamedVariableImpl extends NamedVariableImpl implements CogScriptNamedVariable {

  public CogScriptNamedVariableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CogScriptVisitor visitor) {
    visitor.visitNamedVariable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CogScriptVisitor) accept((CogScriptVisitor)visitor);
    else super.accept(visitor);
  }

}
