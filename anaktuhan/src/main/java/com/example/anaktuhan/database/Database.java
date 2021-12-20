package com.example.anaktuhan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.anaktuhan.modal.Periods;
import com.example.anaktuhan.modal.Verses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    final private String url ="jdbc:sqlite:vizbible.sqlite";
    final private String querySelect = "SELECT verses.verseId, verses.osisRef, verses.verseText, events.title, periods.formattedYear FROM verses LEFT JOIN events ON verses.verseID = events.verseSort LEFT JOIN Periods ON verses.yearNum = Periods.yearNum";
    final private String periodSelect = "SELECT formattedYear, events FROM Periods";
    private Connection connection = null;
    public static Database instance = new Database();

    public Database(){
        try {
            connection = DriverManager.getConnection(url);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ObservableList<Verses> getAllVerses() {
        ObservableList<Verses> verses = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                Verses verse = new Verses();
                verse.setVerseId(result.getInt("verseID"));
                verse.setVerse(result.getString("osisRef"));
                verse.setVerseText(result.getString("verseText"));
                verse.setTitle(result.getString("title"));
                verse.setFormattedYear(result.getString("formattedYear"));
                verses.add(verse);
            }
        } catch (Exception e) {

        }
        return verses;
    }

    public ObservableList<Periods> getAllPeriods() {
        ObservableList<Periods> periods = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                Periods period = new Periods();
                period.setFormattedYear(result.getString("formattedYear"));
                period.setEvents(result.getString("events"));
                periods.add(period);
            }
        } catch (Exception e) {

        }
        return periods;
    }

    public Connection opeConnection(Database Database){
        return Database.connection;
    }

    // public static ArrayList searchUtama(String search){
    //     String query = "SELECT osisRef, verseText FROM verses WHERE eventsDescribed LIKE '%"+search+"%' OR timeline LIKE '%"+search+"%'";
    //     // System.out.println(query);
    //     ArrayList<Verses> hasil = new ArrayList<Verses>();
    //     try {
    //         Statement statement = connection.createStatement();
    //         ResultSet result = statement.executeQuery(query);

    //         while(result.next()){
    //             hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
    //         }
    //         return hasil;
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return hasil;
    //     } 
    // }

    // public ArrayList searchUtama(Integer search){
    //     String query = "SELECT osisRef, verseText FROM verses WHERE yearNum LIKE '%"+search+"%'";
    //     // System.out.println(query);
    //     ArrayList<Verses> hasil = new ArrayList<Verses>();
    //     try {
    //         Statement statement = connection.createStatement();
    //         boolean result = statement.execute(query);

    //         while(result.next()){
    //             hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
    //         }
    //         return hasil;
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return hasil;
    //     } 
    // }
}
