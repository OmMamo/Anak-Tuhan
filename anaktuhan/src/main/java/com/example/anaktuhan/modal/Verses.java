package com.example.anaktuhan.modal;

public class Verses {
    private int verseId;
    private String verse;
    private String verseText;
    private String eventsDescribed;
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

    public void setEventsDescribed(String eventsDescribed) {
        this.eventsDescribed = eventsDescribed;
    }

    public void setYearNum(int yearNum) {
        this.yearNum = yearNum;
    }


    public int getVerseId() {
        return this.verseId;
    }
    
    public String getVerse() {
        return this.verse;
    }

    public String getVerseText() {
        return this.verseText;
    }

    public String getEventsDescribed() {
        return eventsDescribed;
    }

    public int getYearNum() {
        return yearNum;
    }
}