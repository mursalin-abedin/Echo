package com.techelevator.model;

public class Card {
    private int cardId;
    private String question;
    private String answer;
    private int userId;
    private String[] keywords;

    public Card() {
    }

    public Card(int cardId, String question, String answer) {
        this.cardId = cardId;
        this.question = question;
        this.answer = answer;
//        this.userId = userId;
//        this.keywords = keywords;
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

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
}
