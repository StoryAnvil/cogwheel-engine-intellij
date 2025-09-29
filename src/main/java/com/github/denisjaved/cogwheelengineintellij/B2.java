package com.github.denisjaved.cogwheelengineintellij;

import java.util.Objects;

public class B2<A, B> {
    public A a;
    public B b;

    public B2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof B2<?, ?> b2)) return false;
        return Objects.equals(a, b2.a) && Objects.equals(b, b2.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public B2() {
        this(null, null);
    }
}
