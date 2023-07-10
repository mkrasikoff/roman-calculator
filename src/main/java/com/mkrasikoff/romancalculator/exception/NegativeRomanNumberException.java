package com.mkrasikoff.romancalculator.exception;

public class NegativeRomanNumberException extends IllegalArgumentException {
    public NegativeRomanNumberException(String message) {
        super(message);
    }
}
