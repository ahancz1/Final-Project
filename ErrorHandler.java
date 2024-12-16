package com.example.finalcalculatorproj;

// ErrorHandler class
class ErrorHandler {
    private String errorMessage;
    private boolean isValid;

    // constructor
    public ErrorHandler() {
        errorMessage = "";
        isValid = true;
    }

    // validate input method
    boolean validateInput(String input) {
        try {
            Double.parseDouble(input);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
            errorMessage = "Invalid input. Please enter a valid number.";
        }
        return isValid;
    }

    // get error message
    String getErrorMessage() {
        return errorMessage;
    }

    // clear error state
    void clearError() {
        errorMessage = "";
        isValid = true;
    }

}