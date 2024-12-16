package com.example.finalcalculatorproj;

// AdvancedOperations class that extends Calculator
class AdvancedOperations extends FinalCalculator {
    private String advancedType;
    private double base; // base field for exponentiation
    private double memory;

    // constructor
    public AdvancedOperations() {
        advancedType = "";
        base = 0.0;
        memory = 0.0;
    }

    // implementing performOperation
    @Override
    double performOperation() {
        return performAdvancedOperation();  // calls the specific method to handle advanced operations
    }

    // method to perform advanced operations
    double performAdvancedOperation() {
        switch (advancedType) {
            case "SQRT":
                setCurrentResult(Math.sqrt(Double.parseDouble(getInput())));
                break;
            case "EXP":
                double exponent = Double.parseDouble(getInput());
                setCurrentResult(Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid advanced operation type.");
        }
        return getCurrentResult();
    }

    // set advanced operation type
    void setAdvancedType(String type) {
        advancedType = type;
    }

    void setBase(double baseValue) {
        base = baseValue;
    }

    // get advanced operation type
    String getAdvancedType() {
        return advancedType;
    }

    // memory functions similar to BasicOperations
    void clearMemory() {
        memory = 0.0;
    }

    void storeMemory(double value) {
        memory = value;
    }

    double getMemory() {
        return memory;
    }

}