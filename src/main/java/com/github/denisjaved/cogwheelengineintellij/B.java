package com.github.denisjaved.cogwheelengineintellij;

import java.util.Objects;

public class B<A> {
    public A value;

    public B(A value) {
        this.value = value;
    }

    public B() {
        this(null);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof B<?> b)) return false;
        return Objects.equals(value, b.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
