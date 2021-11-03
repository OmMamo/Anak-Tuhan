package com.example.anaktuhan;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.anaktuhan.database.Database;
import com.example.anaktuhan.modal.Verses;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {

    @FXML
    private TableView<Verses> tableVerses;

    @FXML
    private TableColumn<Verses, Integer> verseIdCol;

    @FXML
    private TableColumn<Verses, String> verseCol;

    @FXML
    private TableColumn<Verses, String> verseTextCol;

    @FXML
    private TextField fieldTime;

    @FXML
    private Button timeBut;

    @FXML
    private TextField fieldEvent;

    @FXML
    private Button eventBut;

    @FXML
    void submit(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Verses> verses = Database.instance.getAllVerses();
        verseIdCol.setCellValueFactory(new PropertyValueFactory<Verses, Integer>("verseId"));
        verseCol.setCellValueFactory(new PropertyValueFactory<Verses, String>("verse"));
        verseTextCol.setCellValueFactory(new PropertyValueFactory<Verses, String>("verseText"));
        tableVerses.setItems(verses);
    }
}