package com.example.anaktuhan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.anaktuhan.modal.Verses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    final private String url ="jdbc:sqlite:vizbible.sqlite";
    final private String querySelect = "SELECT verses.verseId, verses.osisRef, verses.verseText, events.title, periods.formattedYear FROM verses LEFT JOIN events ON verses.verseID = events.verseSort LEFT JOIN Periods ON verses.yearNum = Periods.yearNum";
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

    public Connection opeConnection(Database Database){
        return Database.connection;
    }
}
