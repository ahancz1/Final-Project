package com.example.finalcalculatorproj;


// base abstract class Calculator
public abstract class FinalCalculator {
    private String inputField;
    private String operationsType;
    private double currentResult;
    private String lastKeyPressed;

    // constructor
    public FinalCalculator() {
        inputField = "";
        operationsType = "";
        currentResult = 0.0;
        lastKeyPressed = "";
    }

    // Setters and Getters
    void setInput(String input) {
        inputField = input;
    }

    String getInput() {
        return inputField;
    }

    void setOperationsType(String type) {
        if (type.equals("ADD") || type.equals("SUBTRACT") || type.equals("MULTIPLY") || type.equals("DIVIDE")) {
            operationsType = type;
        } else {
            System.out.println("Invalid operation type");
        }
    }

    String getOperationsType() {
        return operationsType;
    }

    double getCurrentResult() {
        return currentResult;
    }

    void setCurrentResult(double result) {
        currentResult = result;
    }

    void setLastKeyPressed(String key) {
        lastKeyPressed = key;
    }

    String getLastKeyPressed() {
        return lastKeyPressed;
    }

    // reset() method to reset calculator state
    void reset() {
        inputField = "";
        operationsType = "";
        currentResult = 0.0;
        lastKeyPressed = "";
        System.out.println("Calculator has been reset.");
    }

    // abstract Method
    abstract double performOperation();

}