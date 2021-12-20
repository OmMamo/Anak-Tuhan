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

            // try {
                
            //     periods = db.instance.getAllPeriods();
            //     ArrayList<String> periodSelect = new ArrayList<String>();
            //     var dataResult = new XYChart.Series();
            //     dataResult.setName("Periods");
            //     BarChart.setLegendVisible(false);
            //     for(int i = periods.size()-1; i>-0; i--){
            //         System.out.println(periods.get(i).getFormattedYear());
            //         System.out.println(periods.get(i).getEvents().split(",").length);
            //         dataResult.getData().add(new XYChart.Data(periods.get(i).getFormattedYear(),periods.get(i).getEvents().split(",").length));
                    
            //     }
            //     // System.out.println(listPlace);
            //     BarChart.getData().add(dataResult);
            //     // System.out.println(events.size()); 
            // } catch (Exception e) {
            //     System.out.println(e.getMessage());
            // }
            
        
        
       /*  ObservableList<Periods> periods = Database.instance.getAllPeriods();
        XYChart.Series<String, String> series = new XYChart.Series<>();
        series.setName("TIMELINE");
        series.getData().add(new XYChart.Data<>("Creation of All The Things", "4004 BC"));
        BarChart.getData().add(series);
  */



