package com.techelevator.model;

public class Deck {
    private int deckId;
    private String deckName;
    private String deckDescription;
    private int userId;

    public Deck() {
    }

    public Deck(int deckId, String deckName, String deckDescription, int userId) {
        this.deckId = deckId;
        this.deckName = deckName;
        this.deckDescription = deckDescription;
        this.userId = userId;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckDescription() {
        return deckDescription;
    }

    public void setDeckDescription(String deckDescription) {
        this.deckDescription = deckDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
