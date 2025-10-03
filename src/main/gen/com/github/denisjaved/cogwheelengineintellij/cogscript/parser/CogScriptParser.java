// This is a generated file. Not intended for manual editing.
package com.github.denisjaved.cogwheelengineintellij.cogscript.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CogScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(NAMED_VARIABLE, VARIABLE_NAME),
  };

  /* ********************************************************** */
  // variableName|keywords|namedVariable|COMMENT|KEYWORD|BRACKETS|EXPR|WHITESPACE|HEAD_WHITESPACE
  //     |EXPR_ROOT|EXPR_PROP|EXPR_STR|EXPR_NUMERIC|EXPR_VARNAME|EXPR_BRACKET|LINE_TERMINATOR|IMPOSSIBLE|BAD_CHARACTER
  //     |IF_KEYWORD
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = variableName(b, l + 1);
    if (!r) r = keywords(b, l + 1);
    if (!r) r = namedVariable(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, KEYWORD);
    if (!r) r = consumeToken(b, BRACKETS);
    if (!r) r = consumeToken(b, EXPR);
    if (!r) r = consumeToken(b, WHITESPACE);
    if (!r) r = consumeToken(b, HEAD_WHITESPACE);
    if (!r) r = consumeToken(b, EXPR_ROOT);
    if (!r) r = consumeToken(b, EXPR_PROP);
    if (!r) r = consumeToken(b, EXPR_STR);
    if (!r) r = consumeToken(b, EXPR_NUMERIC);
    if (!r) r = consumeToken(b, EXPR_VARNAME);
    if (!r) r = consumeToken(b, EXPR_BRACKET);
    if (!r) r = consumeToken(b, LINE_TERMINATOR);
    if (!r) r = consumeToken(b, IMPOSSIBLE);
    if (!r) r = consumeToken(b, BAD_CHARACTER);
    if (!r) r = consumeToken(b, IF_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // KEYWORD | IF_KEYWORD
  public static boolean keywords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywords")) return false;
    if (!nextTokenIs(b, "<keywords>", IF_KEYWORD, KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORDS, "<keywords>");
    r = consumeToken(b, KEYWORD);
    if (!r) r = consumeToken(b, IF_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXPR_VARNAME | EXPR_ROOT
  public static boolean namedVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedVariable")) return false;
    if (!nextTokenIs(b, "<named variable>", EXPR_ROOT, EXPR_VARNAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_VARIABLE, "<named variable>");
    r = consumeToken(b, EXPR_VARNAME);
    if (!r) r = consumeToken(b, EXPR_ROOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXPR_VARNAME
  public static boolean variableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableName")) return false;
    if (!nextTokenIs(b, EXPR_VARNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPR_VARNAME);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

}
