package com.github.denisjaved.cogwheelengineintellij;

import com.intellij.DynamicBundle;

import java.util.function.Supplier;

public class Bundle extends DynamicBundle {
    public static final Bundle INSTANCE = new Bundle();
    private Bundle() {
        super("messages.MyBundle");
    }

    public static String message(String id, Object... o) {
        return INSTANCE.messageOrNull(id, o);
    }
    public static Supplier<String> lazyMessage(String id, Object... o) {
        return INSTANCE.getLazyMessage(id, o);
    }
}
