package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.cogscript.parser.CogScriptParser;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptFile;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTokenSets;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class CogScriptParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(CogScriptLang.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new CogScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return CogScriptTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return CogScriptTokenSets.STRING_LITERALS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new CogScriptParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new CogScriptFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return CogScriptTypes.Factory.createElement(node);
    }

}