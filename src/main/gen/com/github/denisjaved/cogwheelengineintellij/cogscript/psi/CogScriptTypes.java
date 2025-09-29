// This is a generated file. Not intended for manual editing.
package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.impl.*;

public interface CogScriptTypes {

  IElementType PROPERTY = new CogScriptElementType("PROPERTY");

  IElementType BAD_CHARACTER = new CogScriptTokenType("BAD_CHARACTER");
  IElementType BRACKETS = new CogScriptTokenType("BRACKETS");
  IElementType COMMENT = new CogScriptTokenType("COMMENT");
  IElementType EXPR = new CogScriptTokenType("EXPR");
  IElementType EXPR_BRACKET = new CogScriptTokenType("EXPR_BRACKET");
  IElementType EXPR_NUMERIC = new CogScriptTokenType("EXPR_NUMERIC");
  IElementType EXPR_PROP = new CogScriptTokenType("EXPR_PROP");
  IElementType EXPR_ROOT = new CogScriptTokenType("EXPR_ROOT");
  IElementType EXPR_STR = new CogScriptTokenType("EXPR_STR");
  IElementType EXPR_VARNAME = new CogScriptTokenType("EXPR_VARNAME");
  IElementType HEAD_WHITESPACE = new CogScriptTokenType("HEAD_WHITESPACE");
  IElementType KEYWORD = new CogScriptTokenType("KEYWORD");
  IElementType WHITESPACE = new CogScriptTokenType("WHITESPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new CogScriptPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
