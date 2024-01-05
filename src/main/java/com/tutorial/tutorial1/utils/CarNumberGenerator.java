package com.tutorial.tutorial1.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CarNumberGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();

    public static String generateRandomCarNumber() {
        StringBuilder carNumber = new StringBuilder();

        // Generate 3 random letters
        for (int i = 0; i < 3; i++) {
            char randomLetter = LETTERS.charAt(random.nextInt(LETTERS.length()));
            carNumber.append(randomLetter);
        }

        // Add a hyphen
        carNumber.append("-");

        // Generate 4 random digits starting with 4
        carNumber.append("4");
        for (int i = 0; i < 3; i++) {
            carNumber.append(random.nextInt(10));
        }

        return carNumber.toString();
    }


}
