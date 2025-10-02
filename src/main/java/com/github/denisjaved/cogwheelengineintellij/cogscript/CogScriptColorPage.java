package com.github.denisjaved.cogwheelengineintellij.cogscript;

import com.github.denisjaved.cogwheelengineintellij.MyIcons;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class CogScriptColorPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keywords", CogScriptSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comments", CogScriptSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Errors", CogScriptSyntaxHighlighter.BAD),
            new AttributesDescriptor("Strings", CogScriptSyntaxHighlighter.STRING_LITERAL),
            new AttributesDescriptor("Numbers", CogScriptSyntaxHighlighter.INT_LITERAL),
    };

    @Override
    public @Nullable Icon getIcon() {
        return MyIcons.COGSCRIPT;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new CogScriptSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
               # Comment
               npc = Cogwheel.getTaggedNPC("actor")
               npc.setName("Test NPC")
               x = ^48
               npc.toEntity().teleport(x, ^5, ^146)
               
               if (npc.hasTag("done")) {
                   Cogwheel.log("NPC is done!")
               }
               """;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "CogScript";
    }
}
