package com.example.anaktuhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {

    private String textDisplay;

    @FXML
    private TextField textField;

    @FXML
    private Button submitBut;

    @FXML
    private Text text;

    @FXML
    void submit(ActionEvent event) {
        textDisplay = textField.getText().trim();
        text.setText(textDisplay);
    }

}
