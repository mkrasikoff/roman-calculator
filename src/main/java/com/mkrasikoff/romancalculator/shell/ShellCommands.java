package com.mkrasikoff.romancalculator.shell;

import jakarta.annotation.PostConstruct;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class ShellCommands {

    private static final String WELCOME_MESSAGE = "Welcome to Roman Calculator CLI! Please input what do you want to calculate below." +
            "\n" + "To calculate Roman numerals use the next command: calc: \"V + V\"" +
            "\n" + "Please don't forget, that Roman numerals can't be negative or zero values! \"V + V\"" +
            "\n" + "To calculate Decimal numerals use the next command: calc: \"5 + 5\"" +
            "\n" + "To calculate negative Decimal numerals use the next command: calc: -- \"-5 * 5\"";

    @PostConstruct
    public void welcome() {
        System.out.println(WELCOME_MESSAGE);
    }
}
