package com.example.anaktuhan;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.anaktuhan.database.Database;
import com.example.anaktuhan.modal.Periods;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class FXMLController2 implements Initializable {
    
    @FXML
    private BarChart<String, String> BarChart;

    @FXML
    private CategoryAxis y;

    @FXML
    private NumberAxis x;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)  {
        ObservableList<Periods> periods = Database.instance.getAllPeriods();
        XYChart.Series<String, String> series = new XYChart.Series<>();
        series.setName("TIMELINE");
        series.getData().add(new XYChart.Data<>());

        BarChart.getData().add(series);
 
    }

}
