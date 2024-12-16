package com.example.finalcalculatorproj;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CalculatorGUI extends Application {
    private Label displayLabel = new Label("0");
    private double memoryValue = 0.0;
    private String currentInput = "";
    private String currentEquation = "";
    private String currentOperator = "";
    private double currentResult = 0.0;
    private boolean calculationComplete = false;
    private boolean isDarkMode = true;

    private List<Button> allButtons = new ArrayList<>();
    private Button toggleModeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Final Project Calculator");

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(25));
        mainLayout.setSpacing(10);
        mainLayout.setAlignment(Pos.CENTER);

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.TOP_LEFT);
        topBar.setPadding(new Insets(1, 1, 1, 0));

        toggleModeButton = new Button("☀");
        toggleModeButton.setMinSize(35, 35);
        toggleModeButton.setStyle("-fx-background-color: transparent; -fx-font-family: 'Noto Sans'; -fx-font-size: 18;");
        toggleModeButton.setOnAction(e -> {
            isDarkMode = !isDarkMode;
            if (isDarkMode) {
                setDarkModeStyles(mainLayout);
                toggleModeButton.setText("☀");
            } else {
                setLightModeStyles(mainLayout);
                toggleModeButton.setText("🌙");
            }
        });
        topBar.getChildren().add(toggleModeButton);
        mainLayout.getChildren().add(topBar);

        displayLabel.setMinSize(260, 93);
        displayLabel.setStyle("-fx-border-radius: 15; -fx-background-radius: 15;");
        mainLayout.getChildren().add(displayLabel);

        String[][] buttonLayout = {
                {"⌫", "M+", "MR", "MC"},
                {"7", "8", "9", "+"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "*"},
                {"±", "0", ".", "/"},
                {"C", "^", "√", "="}
        };

        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(8);
        buttonGrid.setVgap(8);
        buttonGrid.setPadding(new Insets(7, 5, 5, 5));
        buttonGrid.setAlignment(Pos.CENTER);

        for (int row = 0; row < buttonLayout.length; row++) {
            for (int col = 0; col < buttonLayout[row].length; col++) {
                String text = buttonLayout[row][col];
                Button button = new Button(text);
                button.setMinSize(60, 22);
                button.setStyle("-fx-font-size: 12; -fx-background-radius: 35; -fx-border-radius: 35;");
                allButtons.add(button);

                button.setOnAction(e -> handleButtonClick(text));
                buttonGrid.add(button, col, row);
            }
        }

        mainLayout.getChildren().add(buttonGrid);

        Scene scene = new Scene(mainLayout, 305, 500);
        primaryStage.setScene(scene);

        setDarkModeStyles(mainLayout);
        primaryStage.show();
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "C": // Clear
                currentInput = "";
                currentEquation = "";
                currentOperator = "";
                currentResult = 0.0;
                displayLabel.setText("0");
                calculationComplete = false;
                break;
            case "⌫": // Backspace
                if (!currentInput.isEmpty() && !calculationComplete) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    displayLabel.setText(currentEquation + currentInput);
                }
                break;
            case "±": // Toggle positive/negative
                if (calculationComplete) {
                    // If calculation is complete, toggle currentResult
                    currentResult = -currentResult;
                    currentInput = String.valueOf(currentResult);
                    displayLabel.setText(formatResult(currentResult));
                } else if (!currentInput.isEmpty()) {
                    // Toggle sign of current input
                    if (currentInput.startsWith("-")) {
                        currentInput = currentInput.substring(1);
                    } else {
                        currentInput = "-" + currentInput;
                    }
                    displayLabel.setText(currentEquation + currentInput);
                }
                break;
            case ".": // Decimal point
                if (!currentInput.contains(".")) {
                    currentInput += ".";
                    displayLabel.setText(currentEquation + currentInput);
                }
                break;
            case "M+": // Memory Add
                if (!currentInput.isEmpty()) {
                    memoryValue += Double.parseDouble(currentInput);
                    displayLabel.setText("Memory: " + memoryValue);
                }
                break;
            case "MR": // Memory Recall
                currentInput = String.valueOf(memoryValue);
                displayLabel.setText(currentEquation + currentInput);
                break;
            case "MC": // Memory Clear
                memoryValue = 0.0;
                displayLabel.setText("Memory Cleared");
                break;
            case "=": // Equals
                if (!currentInput.isEmpty() && !currentOperator.isEmpty()) {
                    performCalculation(Double.parseDouble(currentInput));
                    displayLabel.setText(formatResult(currentResult));
                    currentInput = String.valueOf(currentResult);
                    currentOperator = "";
                    currentEquation = currentInput;
                    calculationComplete = true;
                }
                break;
            case "√": // Square root
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    if (value >= 0) {
                        currentResult = Math.sqrt(value);
                        displayLabel.setText(formatResult(currentResult));
                        currentInput = String.valueOf(currentResult);
                        calculationComplete = true;
                    } else {
                        displayLabel.setText("Error");
                        currentInput = "";
                        calculationComplete = true;
                    }
                }
                break;
            case "^": // Exponentiation
                if (!currentInput.isEmpty()) {
                    if (!calculationComplete) {
                        currentResult = Double.parseDouble(currentInput);
                    }
                    currentOperator = "^";
                    currentInput = "";
                    currentEquation += " ^ ";
                    displayLabel.setText(currentEquation);
                }
                break;
            default: // Numbers and operators
                if ("0123456789".contains(text)) { // Numbers
                    if (calculationComplete) {
                        currentInput = "";
                        currentEquation = "";
                        calculationComplete = false;
                    }
                    currentInput += text;
                    displayLabel.setText(currentEquation + currentInput);
                } else { // Operators (+, -, *, /)
                    if (!currentInput.isEmpty() || calculationComplete) {
                        if (!currentInput.isEmpty()) {
                            performCalculation(Double.parseDouble(currentInput));
                        }
                        currentOperator = text;
                        currentEquation = formatResult(currentResult) + " " + currentOperator + " ";
                        currentInput = "";
                        displayLabel.setText(currentEquation);
                        calculationComplete = false;
                    }
                }
        }
    }

    private void performCalculation(double operand) {
        switch (currentOperator) {
            case "+":
                currentResult += operand;
                break;
            case "-":
                currentResult -= operand;
                break;
            case "*":
                currentResult *= operand;
                break;
            case "/":
                if (operand != 0) {
                    currentResult /= operand;
                } else {
                    displayLabel.setText("Error: /0");
                    currentOperator = "";
                    currentInput = "";
                    calculationComplete = true;
                }
                break;
            case "^":
                currentResult = Math.pow(currentResult, operand);
                break;
            default:
                currentResult = operand;
                break;
        }
    }

    private String formatResult(double result) {
        return (result == Math.floor(result)) ? String.valueOf((int) result) : String.valueOf(result);
    }

    private void setDarkModeStyles(VBox mainLayout) {
        mainLayout.setStyle("-fx-background-color: #1a1a1a;");
        displayLabel.setStyle("-fx-background-color: #1e1e1e; -fx-text-fill: white; -fx-font-size: 19; -fx-border-color: #1f305f; -fx-border-width: 2; -fx-border-radius: 15; -fx-background-radius: 15; -fx-alignment: center;");

        for (Button button : allButtons) {
            button.setStyle("-fx-background-color: #232323; -fx-text-fill: white; -fx-font-size: 19; -fx-border-color: #1f305f; -fx-border-width: 1; -fx-border-radius: 15; -fx-background-radius: 15;");
        }

        toggleModeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 18;");
    }

    private void setLightModeStyles(VBox mainLayout) {
        mainLayout.setStyle("-fx-background-color: #eaf1ff;");
        displayLabel.setStyle("-fx-background-color: #f5f8fe; -fx-text-fill: black; -fx-font-size: 19; -fx-border-color: lightblue; -fx-border-width: 2; -fx-border-radius: 15; -fx-background-radius: 15; -fx-alignment: center;");

        for (Button button : allButtons) {
            button.setStyle("-fx-background-color: #f5f8fe; -fx-text-fill: black; -fx-font-size: 19; -fx-border-color: lightblue; -fx-border-width: 1; -fx-border-radius: 15; -fx-background-radius: 15;");
        }

        toggleModeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-family: 'Noto Sans'; -fx-font-size: 15;");
    }
}
