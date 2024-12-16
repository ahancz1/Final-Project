/*
package com.example.finalcalculatorproj;

public class CalculatorTest {
    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandler();

        // test BasicOperations
        BasicOperations basicCalc = new BasicOperations();
        String input = "10";

        // addition
        basicCalc.setInput(input);
        basicCalc.setOperationsType("ADD");
        basicCalc.performBasicOperation();
        basicCalc.setInput("5");
        double result = basicCalc.performOperation();
        System.out.println("Basic addition result: " + result); // Expected output: 15.0

        // Multiplication
        basicCalc.setInput("4");
        basicCalc.setOperationsType("MULTIPLY");
        result = basicCalc.performOperation();
        System.out.println("Basic Calculation Result (MULTIPLY): " + result); // Expected: 60.0


        // subtraction
        basicCalc.setInput("4");
        basicCalc.setOperationsType("SUBTRACT");
        result = basicCalc.performOperation();
        System.out.println("Basic Calculation Result (SUBTRACT): " + result); // Expected: 56.0

        // division
        basicCalc.setInput("7");
        basicCalc.setOperationsType("DIVIDE");
        result = basicCalc.performOperation();
        System.out.println("Basic Calculation Result (DIVIDE): " + result); // Expected: 8.0

        // test memory functions
        basicCalc.storeMemory(result);
        System.out.println("Memory stored value: " + basicCalc.getMemory()); // Expected: 8.0
        basicCalc.clearMemory();
        System.out.println("Memory after clearing: " + basicCalc.getMemory()); // Expected: 0.0

        // test reset
        basicCalc.reset();
        System.out.println("After reset, current result: " + basicCalc.getCurrentResult()); // Expected: 0.0

        // test AdvancedOperations
        AdvancedOperations advCalc = new AdvancedOperations();
        input = "25";

        advCalc.setInput(input);
        advCalc.setAdvancedType("SQRT");
        double advResult = advCalc.performOperation();
        System.out.println("Square root of 25 Calculation Result: " + advResult); // Expected output: 5.0

        // test exponentiation (EXP)
        input = "4";
        advCalc.setInput(input);
        advCalc.setAdvancedType("EXP");
        advResult = advCalc.performOperation(); // Perform EXP with input 4 (4^2)
        System.out.println("Exponent Calculation Result (EXP): " + advResult); // Expected: 16.0

        // test memory functions in AdvancedOperations
        advCalc.storeMemory(advResult);
        System.out.println("Memory stored value in AdvancedOperations: " + advCalc.getMemory()); // Expected: 16.0
        advCalc.clearMemory();
        System.out.println("Memory after clearing in AdvancedOperations: " + advCalc.getMemory()); // Expected: 0.0

        // test reset
        advCalc.reset();

        // test ThemeManager
        ThemeManager themeManager = new ThemeManager();
        System.out.println("Dark mode should be on. Is Dark Mode Enabled? " + themeManager.darkModeEnabled()); // Expected: true

        themeManager.setDarkMode(false);
        System.out.println("Dark mode should now be off. Is Dark Mode Enabled? " + themeManager.darkModeEnabled()); // Expected: false

        // test DisplayManager
        DisplayManager displayManager = new DisplayManager();
        displayManager.updateDisplay("2 + 2");
        displayManager.showResult("4");

        // test ErrorHandler
        boolean valid = errorHandler.validateInput("abc");
        if (!valid) {
            System.out.println("Error test: " + errorHandler.getErrorMessage()); // Expected output: Error: Invalid input. Please enter a valid number.
        }

        // test ErrorHandler with valid input
        valid = errorHandler.validateInput("100");
        System.out.println("Error test. Input should be valid (true): " + valid); // Expected: true

    }
}

 */