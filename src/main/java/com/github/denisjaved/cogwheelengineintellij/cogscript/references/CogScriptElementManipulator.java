package com.github.denisjaved.cogwheelengineintellij.cogscript.references;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.NamedVariable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CogScriptElementManipulator extends AbstractElementManipulator<NamedVariable> {
    @Override
    public @Nullable NamedVariable handleContentChange(@NotNull NamedVariable element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        return element;
    }
}
