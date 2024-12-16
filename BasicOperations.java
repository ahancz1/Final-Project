package com.example.finalcalculatorproj;

// BasicOperations class that extends Calculator
class BasicOperations extends FinalCalculator {
    double memory;

    // constructor
    public BasicOperations() {
        memory = 0.0;
    }
    @Override
    double performOperation() {
        return performBasicOperation();
    }

    // method to perform basic operations
    double performBasicOperation() {
        double inputNumber = Double.parseDouble(getInput());
        switch (getOperationsType()) {
            case "ADD":
                setCurrentResult(getCurrentResult() + inputNumber);
                break;
            case "SUBTRACT":
                if (getCurrentResult() == 0) {
                    // If current result is 0, it means we are starting a new operation
                    setCurrentResult(inputNumber);
                } else {
                    setCurrentResult(getCurrentResult() - inputNumber);
                }
                break;
            case "MULTIPLY":
                if (getCurrentResult() == 0) {
                    // If current result is 0 and this is the first number, initialize it with inputNumber
                    setCurrentResult(inputNumber);
                } else {
                    setCurrentResult(getCurrentResult() * inputNumber);
                }
                break;
            case "DIVIDE":
                if (inputNumber == 0) {
                    System.out.println("Error: Cannot divide by 0.");
                } else {
                    if (getCurrentResult() == 0) {
                        // If current result is 0, it means we are starting a new operation
                        setCurrentResult(inputNumber);
                    } else {
                        setCurrentResult(getCurrentResult() / inputNumber);
                    }
                }
                break;
            default:
                System.out.println("Invalid operation type.");
        }
        return getCurrentResult();
    }

    // clear memory method
    void clearMemory() {
        memory = 0.0;
    }

    // store in memory method
    void storeMemory(double value) {
        memory = value;
    }

    // get memory value
    double getMemory() {
        return memory;
    }
}