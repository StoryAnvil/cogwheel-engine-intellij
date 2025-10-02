// This is a generated file. Not intended for manual editing.
package com.github.denisjaved.cogwheelengineintellij.cogscript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.impl.*;

public interface CogScriptTypes {

  IElementType KEYWORDS = new CogScriptElementType("KEYWORDS");
  IElementType NAMED_VARIABLE = new CogScriptElementType("NAMED_VARIABLE");
  IElementType VARIABLE_NAME = new CogScriptElementType("VARIABLE_NAME");

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
  IElementType IF_KEYWORD = new CogScriptTokenType("IF_KEYWORD");
  IElementType IMPOSSIBLE = new CogScriptTokenType("IMPOSSIBLE");
  IElementType KEYWORD = new CogScriptTokenType("KEYWORD");
  IElementType LINE_TERMINATOR = new CogScriptTokenType("LINE_TERMINATOR");
  IElementType WHITESPACE = new CogScriptTokenType("WHITESPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == KEYWORDS) {
        return new CogScriptKeywordsImpl(node);
      }
      else if (type == NAMED_VARIABLE) {
        return new CogScriptNamedVariableImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new CogScriptVariableNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
