package com.example.anaktuhan;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.anaktuhan.database.Database;
import com.example.anaktuhan.modal.Verses;

import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    private TableColumn<Verses, String> eventsCol;

    @FXML
    private TableColumn<Verses, String> periodsCol;


    @FXML
    private TextField fieldSearch;

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
        eventsCol.setCellValueFactory(new PropertyValueFactory<Verses, String>("title"));
        periodsCol.setCellValueFactory(new PropertyValueFactory<Verses, String>("formattedYear"));
        tableVerses.setItems(verses);

        FilteredList<Verses> filteredData= new FilteredList<>(verses,searching->true);

        fieldSearch.textProperty().addListener((Observable, oldValue, newValue) -> {
                filteredData.setPredicate(verse -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;            
                    }
                    String lowerCase=newValue.toLowerCase();
                    if(verse.getTitle().toLowerCase().indexOf(lowerCase)!=-1){
                        return true; 
                    }              
                    if(verse.getVerseText().toLowerCase().indexOf(lowerCase)!=-1){
                        return true; 
                    }                
                    if(verse.getVerse().toLowerCase().indexOf(lowerCase)!=-1){
                        return true; 
                    }
                    if(verse.getFormattedYear().toLowerCase().indexOf(lowerCase) != -1){
                        return true; 
                    }
                    else{
                        return false;
                    }

                    // Integer lowerCaseInteger = newValue.toInteger();
                    // if (verse.getYearNum().indexOf(lowerCaseInteger) != null ) {
                    //     return true; 
                    // }
                    // else{
                    //     return false;
                    // }
                });
            });  

        SortedList<Verses> sortingData = new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(tableVerses.comparatorProperty());
        tableVerses.setItems(sortingData);

        }
    }

//reference : https://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/