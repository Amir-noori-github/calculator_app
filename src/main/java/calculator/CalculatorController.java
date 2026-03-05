package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double sum = num1 + num2;
            double product = num1 * num2;
            double subtract = num1 - num2;

            String divisionResult;
            double divisionValue = 0;

            if (num2 == 0) {
                divisionResult = "Cannot divide by zero";
            } else {
                divisionValue = num1 / num2;
                divisionResult = String.valueOf(divisionValue);
            }

            resultLabel.setText(
                    "Sum: " + sum +
                            ", Product: " + product +
                            ", Subtraction: " + subtract +
                            ", Division: " + divisionResult
            );

            // Save to DB (divisionValue only saved if valid)
            ResultService.saveResult(num1, num2, sum, product, subtract,
                    num2 == 0 ? null : divisionValue);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}