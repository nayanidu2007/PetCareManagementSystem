/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.util;
import com.petcare.exception.InvalidInputException;

/**
 *
 * @author User
 */
public class ValidationUtil {
     public static void validateRequired(
            String value,
            String fieldName)
            throws InvalidInputException {

        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(
                fieldName + " cannot be empty."
            );
        }
    }

    public static void validatePositiveNumber(
            double value,
            String fieldName)
            throws InvalidInputException {

        if (value <= 0) {
            throw new InvalidInputException(
                fieldName + " must be greater than 0."
            );
        }
    }

    public static void validateNonNegativeNumber(
            double value,
            String fieldName)
            throws InvalidInputException {

        if (value < 0) {
            throw new InvalidInputException(
                fieldName + " cannot be negative."
            );
        }
    }

    public static void validatePhone(
            String phone)
            throws InvalidInputException {

        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidInputException(
                "Phone number cannot be empty."
            );
        }

        if (!phone.matches("\\d{10}")) {
            throw new InvalidInputException(
                "Phone number must contain exactly 10 digits."
            );
        }
    }

    public static void validateEmail(
            String email)
            throws InvalidInputException {

        if (email == null || email.trim().isEmpty()) {
            throw new InvalidInputException(
                "Email cannot be empty."
            );
        }

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            throw new InvalidInputException(
                "Please enter a valid email address."
            );
        }
    }
    
}
