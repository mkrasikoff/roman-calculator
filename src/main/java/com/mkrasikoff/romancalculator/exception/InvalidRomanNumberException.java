package com.mkrasikoff.romancalculator.exception;

public class InvalidRomanNumberException extends IllegalArgumentException {
    public InvalidRomanNumberException(String message) {
        super(message);
    }
}
