package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransformationController {
    @FXML
    private Button btnCFa; //Celsius to Fahrenheit
    @FXML
    private Button btnFaC; //Fahrenheit to Celsius
    @FXML
    private Button btnFMe; //Feet to Meters
    @FXML
    private Button btnMFe; //Meters to Feet
    @FXML
    private Button btnICe; //Inches to Centimeters
    @FXML
    private Button btnCeI; //Centimeters to Inches
    @FXML
    private Button btnPKi; //Pounds to Kilograms
    @FXML
    private Button btnKiP; //Kilograms to Pounds
    @FXML
    private Button btnClear; //Clear all textAreas and Fields
    @FXML
    private Button btnBackCalc; //Go back on calculator page
    @FXML
    private TextArea onGetResult; //Here place where result  will be displayed
    @FXML
    private TextField onEnterValue; //Place for entering number
    @FXML
    private TextField onMath; //Number of decimal places


    private double number; // value which been entered for transformation
    private int round; //number of decimal places

    private Transformation transformation = new Transformation(number); //object of Transformation  class

    // This method is automatically called when the window opens, after the FXML file has been loaded.
    @FXML
    private void initialize() {
        // Attach event handler(s)
        btnCFa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcCelsiustoFahrenheit();
            }
        });
        btnFaC.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcFahrenheittoCelsius();
            }
        });
        btnFMe.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcFeettoMeters();
            }
        });
        btnMFe.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcMeterstoFeet();
            }
        });
        btnICe.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcInchestoCentimeters();
            }
        });
        btnCeI.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcCentimeterstoInches();
            }
        });
        btnPKi.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcPoundstoKilograms();
            }
        });
        btnKiP.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                calcKilogramstoPounds();
            }
        });
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onClearClicked();
            }
        });
        btnBackCalc.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onBackToCalc();
            }
        });
    }


    /**
     * This method gets value from first text field and transfer it to double value. Otherwise throws exception and shows alert dialog
     */

    private void numDoub() {
        String num = onEnterValue.getText();
        try {
            number = Double.parseDouble(num);
        } catch (NumberFormatException e) {
            number = 0; //clear the buffer, setting it to 0
            onEnterValue.setText(0 + ""); //setting value to 0 that the user doesn't accidentally receive an error again
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Value error");
            alert.setHeaderText("Error");
            alert.setContentText("Ooops, wrong number been entered into value filed, please try again!");
            alert.showAndWait();
        }
    }

    /**
     * This method gets value from second text field and transfer it to integer value. Otherwise throws exception and shows alert dialog
     */
    private void numPlac() {
        String decimalPlaces = onMath.getText();
        try {
            round = Integer.parseInt(decimalPlaces);
        } catch (NumberFormatException e) {
            round = 0; //clear the buffer, setting it to 0
            onMath.setText(0 + ""); //setting value to 0 that the user doesn't accidentally receive an error again
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Decimal places error");
            alert.setHeaderText("Error");
            alert.setContentText("Ooops, wrong number been entered into decimal places filed, please try again!");
            alert.showAndWait();
        }

    }


    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Celsius_to_Fahrenheit
     */
    private void calcCelsiustoFahrenheit() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Celsius_to_Fahrenheit(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Fahrenheit_to_Celsius
     */
    private void calcFahrenheittoCelsius() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Fahrenheit_to_Celsius(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Feet_to_Meters
     */
    private void calcFeettoMeters() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Feet_to_Meters(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Meters_to_Feet
     */
    private void calcMeterstoFeet() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Meters_to_Feet(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Inches_to_Centimeters
     */
    private void calcInchestoCentimeters() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Inches_to_Centimeters(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Centimeters_to_Inches
     */
    private void calcCentimeterstoInches() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Centimeters_to_Inches(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Pounds_to_Kilograms
     */
    private void calcPoundstoKilograms() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Pounds_to_Kilograms(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Kilograms_to_Pounds
     */
    private void calcKilogramstoPounds() {
        numDoub();
        numPlac();
        onGetResult.setText(transformation.Kilograms_to_Pounds(number, round) + "");
    }


    /**
     * Method which will clear all fields and text area
     */
    private void onClearClicked() {  //clearing all textFields and textArea inside the window
        onGetResult.setText("");
        onEnterValue.setText("");
        onMath.setText(0 + "");
    }


    /**
     * Close the window "Transformation" and back to calculator
     */
    private void onBackToCalc() {  //returns back to the calculator window
        try {
            Stage stage = (Stage) btnBackCalc.getScene().getWindow();
            // Close the window
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
