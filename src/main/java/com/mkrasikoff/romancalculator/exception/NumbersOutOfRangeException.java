package com.mkrasikoff.romancalculator.exception;

public class NumbersOutOfRangeException extends IllegalArgumentException {
    public NumbersOutOfRangeException(String message) {
        super(message);
    }
}
