package com.tutorial.tutorial1.utils;

import org.springframework.stereotype.Component;

@Component
public class GenerateNumbersUtil {
    public String formatChassieNumber(String input) {
        // Add '-' after every 5 digits
        StringBuilder formattedChassieNumber = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            formattedChassieNumber.append(input.charAt(i));
            if ((i + 1) % 6 == 0 && i != input.length() - 1) {
                formattedChassieNumber.append('-');
            }
        }
        return formattedChassieNumber.toString();
    }

    public String maskLoyaltyNumber(String loyaltyNumber) {
        if (loyaltyNumber == null || loyaltyNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid loyalty number");
        }

        // Masking the first 8 digits
        String maskedNumber = loyaltyNumber.substring(0, 8).replaceAll(".", "*");

        // Displaying the last 2 digits
        maskedNumber += loyaltyNumber.substring(8);

        return maskedNumber;
    }
}
