package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.intellij.lexer.FlexAdapter;

public class CogScriptLexerAdapter extends FlexAdapter {
    public CogScriptLexerAdapter() {
        super(new CogScriptLexer(null));
    }
}
