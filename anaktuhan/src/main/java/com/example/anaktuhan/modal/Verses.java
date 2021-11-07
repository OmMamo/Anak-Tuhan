package com.example.anaktuhan.modal;

public class Verses {
    private int verseId;
    private String verse;
    private String verseText;
    private String title;
    
    private int yearNum;
    
    public void setVerseId(int verseId) {
        this.verseId = verseId;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setYearNum(int yearNum) {
        this.yearNum = yearNum;
    }


    public int getVerseId() {
        return this.verseId;
    }
    
    public String getVerse() {
        if (this.verse == null) {
            return "";
        } else {
            return this.verse; 
        }   
    }

    public String getVerseText() {
        if (this.verseText == null) {
            return "";
        } else {
            return this.verseText;  
        }   
    }

    public String getTitle() {
        if (this.title == null) {
            return "";
        } else {
            return this.title;  
        }   
    }

    public int getYearNum() {
        return yearNum;
    }
}