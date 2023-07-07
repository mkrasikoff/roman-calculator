package com.mkrasikoff.romancalculator;

import com.mkrasikoff.romancalculator.shell.ShellCommands;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RomanCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanCalculatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ShellCommands shellCommands) {
        return args -> shellCommands.welcome();
    }
}
