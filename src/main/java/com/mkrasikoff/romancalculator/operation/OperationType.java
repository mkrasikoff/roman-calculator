package com.mkrasikoff.romancalculator.operation;

public enum OperationType {

    ADD("+") {
        @Override
        public int execute(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        @Override
        public int execute(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int execute(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int execute(int x, int y) {
            return x / y;
        }
    };

    private String symbol;

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int execute(int x, int y);

    public static OperationType fromString(String symbol) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.getSymbol().equals(symbol)) {
                return operationType;
            }
        }
        throw new IllegalArgumentException("Invalid operation: " + symbol);
    }
}
