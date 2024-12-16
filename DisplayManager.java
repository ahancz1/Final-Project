package com.example.finalcalculatorproj;

// DisplayManager class
class DisplayManager {
    String currentInput;
    String currentResult;

    // constructor
    public DisplayManager() {
        currentInput = "";
        currentResult = "";
    }

    // update display with input
    void updateDisplay(String input) {
        currentInput = input;
        System.out.println("Current Input: " + currentInput);
    }

    // show result on display
    void showResult(String result) {
        currentResult = result;
        System.out.println("Result: " + currentResult);
    }
}