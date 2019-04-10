package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
    private Button btnSave; //Save output to the text file
    @FXML
    private Button btnBackCalc; //Go back on calculator page
    @FXML
    private TextArea onGetResult; //Here place where result  will be displayed
    @FXML
    private TextField onEnterValue; //Place for entering number
    @FXML
    private TextField onMath; //Number of decimal places
    @FXML
    private Button btnHistory; //Open history window

    //Object for calling methods from other java class
    private TransformationList transformationList = new TransformationList();

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
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onSave();
            }
        });
        btnBackCalc.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onBackToCalc();
            }
        });
        btnHistory.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onHistoryClick();
            }
        });
    }


    /**
     * This method gets value from first text field and transfer it to double value. Otherwise throws exception and shows alert dialog
     */

    private double numDoub(String string) {
        double number = 0.0;
        try {
            number = Double.parseDouble(string);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Value error");
            alert.setHeaderText("Error");
            alert.setContentText("Ooops, wrong number been entered into value filed, please try again!");
            alert.showAndWait();
        }
        return number;
    }

    /**
     * This method gets value from second text field and transfer it to integer value. Otherwise throws exception and shows alert dialog
     */
    private int numPlac(String numb) {
        int round = 0;
        try {
            round = Integer.parseInt(numb);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Decimal places error");
            alert.setHeaderText("Error");
            alert.setContentText("Ooops, wrong number been entered into decimal places filed, please try again!");
            alert.showAndWait();
        }
        return round;
    }


    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Celsius_to_Fahrenheit
     */
    private void calcCelsiustoFahrenheit() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Celsius_to_Fahrenheit(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Fahrenheit_to_Celsius
     */
    private void calcFahrenheittoCelsius() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Fahrenheit_to_Celsius(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Feet_to_Meters
     */
    private void calcFeettoMeters() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Feet_to_Meters(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Meters_to_Feet
     */
    private void calcMeterstoFeet() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Meters_to_Feet(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Inches_to_Centimeters
     */
    private void calcInchestoCentimeters() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Inches_to_Centimeters(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Centimeters_to_Inches
     */
    private void calcCentimeterstoInches() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Centimeters_to_Inches(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Pounds_to_Kilograms
     */
    private void calcPoundstoKilograms() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Pounds_to_Kilograms(number, round) + "");
    }

    /**
     * Method which will read the string values, put them to numDoub() and numPlac() methods and will calculate formula from
     * transformationList class Kilograms_to_Pounds
     */
    private void calcKilogramstoPounds() {
        String value = onEnterValue.getText();
        String decimalPlaces = onMath.getText();
        Double number = numDoub(value);
        Integer round = numPlac(decimalPlaces);
        TransformationList transformationList = new TransformationList(number);
        onGetResult.setText(transformationList.Kilograms_to_Pounds(number, round) + "");
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
     * Method checking that string value is number
     */
    private static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Save in the history text file in the same folder with project. Before checking that fields are not empty or not a number values
     */
    private void onSave() {  //clearing all textFields and textArea inside the window


        String string = onEnterValue.getText(); //getting the text from value field
        String string2 = onGetResult.getText(); //getting the text from result field
        String string3 = onMath.getText(); //getting the text from number of decimal places field

        //checking that all fields are numeric values, if not then show the error message
        if (!isNumeric(string) || !isNumeric(string2) || !isNumeric(string3)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Can't save the file");
            alert.setContentText("One of the fields not a number!");
            alert.showAndWait();
        } else {
            transformationList.load(string, string2); //if all three fields are numeric then saving to the list
            //}
            if (transformationList._list.size() == 0) {
                return;    // Don't overwrite the file with an empty list
            }

            PrintWriter writer = null;
            try {
                File fileDescriptor = new File("Transformation.txt");
                writer = new PrintWriter(fileDescriptor);
                for (int i = 0; i < transformationList._list.size(); i++) {
                    Transformation p = transformationList._list.get(i);  //getting object of array list and saving it to the text file
                    writer.println("Value: " + p.getFrom() + " -----> Result: " +
                            p.getTo());
                }
            } catch (FileNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Ooops, File not been saved!");
                alert.showAndWait();
            } finally {
                if (writer != null) {
                    //display the result if it has the success
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Success");
                    alert.setContentText("File been saved!");

                    alert.showAndWait();
                    writer.close();

                }
            }
        }
    }

    /**
     * Close the window "Transformation" and back to calculator
     */
    private void onBackToCalc() {  //clearing all textFields and textArea inside the window
        try {
            Stage stage = (Stage) btnBackCalc.getScene().getWindow();
            // Close the window
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Check the history which is saved in the text file
     */
    private void onHistoryClick() {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("History.fxml"));
            Scene scene = new Scene(root, 500, 600);
            //  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            secondStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

