package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class CogScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("COGSCRIPT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("COGSCRIPT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD =
            createTextAttributesKey("COGSCRIPT_ERROR", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey TEST =
            createTextAttributesKey("COGSCRIPT_TEST", DefaultLanguageHighlighterColors.NUMBER);


    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] BAD_KEYS = new TextAttributesKey[]{BAD};
    private static final TextAttributesKey[] TEST_KEYS = new TextAttributesKey[]{TEST};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CogScriptLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(CogScriptTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(CogScriptTypes.KEYWORD)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(CogScriptTypes.BAD_CHARACTER)) {
            return BAD_KEYS;
        }
        if (tokenType.equals(CogScriptTypes.EXPR)) {
            return TEST_KEYS;
        }
        return EMPTY_KEYS;
    }

}