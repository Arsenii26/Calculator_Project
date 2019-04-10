package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class HistoryController {
    @FXML
    private Button btnClear;
    @FXML
    private Button btnReturn;
    @FXML
    private ListView<Calculator> listArea;

    private CalculatorList calc = CalculatorController.calc;
    private HistoryList history = new HistoryList();

    @FXML
    private void initialize() {
        btnReturn.setOnAction(e -> onReturnClicked());
        btnClear.setOnAction(e -> onClearClicked());
        // Set return button text for Calculator.
        btnReturn.setText(calc.getButtonTitle());

        // Display content of Calculator ArrayList
        for (int index = 0; index < calc.equationList.size(); index++) {
            listArea.getItems().add(calc.equationList.get(index));
        }
    }

    @FXML
    private void onReturnClicked() {
        // Save history to file when return button is clicked.
        history.CalculatorListSave();
        // Get a reference to the stage
        Stage stage = (Stage) btnReturn.getScene().getWindow();
        // Close the window
        stage.close();
    }

    private void onClearClicked() {
        // Clear ArrayList.
        calc.equationList.clear();
        // Clear ListView.
        listArea.getItems().clear();
    }


}
