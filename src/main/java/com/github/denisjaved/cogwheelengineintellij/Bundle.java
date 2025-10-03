package com.github.denisjaved.cogwheelengineintellij;

import com.intellij.DynamicBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Bundle extends DynamicBundle {
    public static final Bundle INSTANCE = new Bundle();
    public static final Logger log = LoggerFactory.getLogger("STORYANVIL/COGWHEEL-INTELLIJ");
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
