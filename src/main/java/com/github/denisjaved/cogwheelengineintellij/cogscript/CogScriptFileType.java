package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.MyIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CogScriptFileType extends LanguageFileType {
    public static final CogScriptFileType INSTANCE = new CogScriptFileType();
    private CogScriptFileType() {
        super(CogScriptLang.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "CogScript";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "StoryAnvil's CogScript language";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "sa";
    }

    @Override
    public Icon getIcon() {
        return MyIcons.COGSCRIPT;
    }
}
