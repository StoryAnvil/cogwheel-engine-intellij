package com.github.denisjaved.cogwheelengineintellij;

import com.intellij.DynamicBundle;

public class Bundle extends DynamicBundle {
    public static final Bundle INSTANCE = new Bundle();
    private Bundle() {
        super("messages.MyBundle");
    }
}
