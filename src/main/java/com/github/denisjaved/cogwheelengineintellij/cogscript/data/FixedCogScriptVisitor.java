package com.github.denisjaved.cogwheelengineintellij.cogscript.data;

import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptNamedVariable;
import com.github.denisjaved.cogwheelengineintellij.cogscript.psi.CogScriptVisitor;
import org.jetbrains.annotations.NotNull;

public abstract class FixedCogScriptVisitor extends CogScriptVisitor {
    @Override
    public void visitNamedVariable(@NotNull CogScriptNamedVariable o) {

    }
}
