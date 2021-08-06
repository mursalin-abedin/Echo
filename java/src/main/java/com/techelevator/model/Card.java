package com.techelevator.model;

import java.util.ArrayList;

public class Card {
    private int cardId;
    private String question;
    private String answer;
    private String keywords;
    private int userId;
    private int deckId;
    private ArrayList<Integer> deckIds;


    public Card() {
    }

    public Card(int cardId, String question, String answer, String keywords, int userId, int deckId) {
        this.cardId = cardId;
        this.question = question;
        this.answer = answer;
        this.userId = userId;
        this.keywords = keywords;
        this.deckId = deckId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public ArrayList<Integer> getDeckIds() {
        return deckIds;
    }

    public void setDeckIds(ArrayList<Integer> deckIds) {
        this.deckIds = deckIds;
    }
}
