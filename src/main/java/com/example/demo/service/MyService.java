package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public boolean isValid (String cardNumber) {
        System.out.println("in service: "+cardNumber);
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if (alternate) {
                System.out.println("doubling : " + digit);
                digit *= 2;
                if (digit > 9) {
                    digit = digit - 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        System.out.println(sum);
        return sum % 10 == 0;
    }

}
