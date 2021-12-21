package com.example.anaktuhan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.anaktuhan.database.Database;
import com.example.anaktuhan.modal.Events;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class FXMLController2 implements Initializable {
    
    @FXML
    private BarChart<String, Integer> BarChart;

    @FXML
    private CategoryAxis y;

    @FXML
    private NumberAxis x;

    @FXML
    private Button backBtn;

    @FXML
    void backToHome(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));

        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();


        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)  {
        ObservableList<Events> events = Database.instance.getAllEvents();
        XYChart.Series<String, Integer> dataChart = new XYChart.Series();
        dataChart.setName("TIMELINE");
       
        //dataChart.getData().add(new XYChart.Data<String, String>(Periods.getEvents(), Periods.getFormattedYear()));

      /*   dataChart.getData().add(new XYChart.Data("Creation of All The Things", 4004));
        dataChart.getData().add(new XYChart.Data("Creation", 4003));

        BarChart.getData().add(dataChart); */
        
        //error handling
        for (Events ev : events) {
            if (ev.getStartDate() == 0){
                continue;
            } else{
                dataChart.getData().add(new XYChart.Data(ev.getTitle(), Math.abs(ev.getStartDate())));
                System.out.println(Math.abs(ev.getStartDate()));
                System.out.println(ev.getTitle());
            }
            
            
        }

        BarChart.getData().addAll(dataChart);
 
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


            
