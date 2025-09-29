package com.github.denisjaved.cogwheelengineintellij.cogscript.data;

import java.util.Stack;

public class Expression {
    public Stack<DepthData> expressionDepth = new Stack<>();
    public int lastExpressionID = 0;

    public void clear() {
        expressionDepth.clear();
        lastExpressionID = 0;
    }

    public DepthData peek() {
        return expressionDepth.peek();
    }

    public DepthData peekSafe() {
        return expressionDepth.isEmpty() ? null : expressionDepth.peek();
    }

    public DepthData pop() {
        return expressionDepth.pop();
    }

    public void push(DepthData item) {
        expressionDepth.push(item);
        item.id = lastExpressionID;
        lastExpressionID++;
    }

    public static enum Type {
        NORMAL, COMMA_SEPARATED;
    }

    public static class DepthData {
        public DepthData(int depth, int nextState) {
            this.depth = depth;
            this.nextState = nextState;
        }
        public DepthData(int nextState) {
            this.depth = 0;
            this.nextState = nextState;
        }

        public int depth;
        public int nextState;
        public int id;
        public boolean hasRoot = false;
        public boolean hasVariable = false;
        public Type type = Type.NORMAL;
    }
}
