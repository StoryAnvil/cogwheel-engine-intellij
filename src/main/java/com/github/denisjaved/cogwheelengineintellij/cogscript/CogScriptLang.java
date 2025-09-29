package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.intellij.lang.Language;

public class CogScriptLang extends Language {
    public static final CogScriptLang INSTANCE = new CogScriptLang();
    protected CogScriptLang() {
        super("cogscript");
    }
}
