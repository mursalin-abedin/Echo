package com.techelevator.dao;

import com.techelevator.model.Card;
import java.util.List;

public interface CardDAO {

    Card getCardById(int cardId);

    List<Card> getAllCards();

    List<Card> getAllCardsNotInADeck(int deckId);

    List<Card> getAllCardsByUserId(int userId);

    List<Card> getAllCardsByDeckId(int deckId);

    void deleteCard(int cardId);

    void createCard(String question, String answer, String keywords, int deckId);

    void updateCard(String question, String answer, String keywords, int cardId);

    void removeCardFromDeck(int deckId, int cardId);

    void addCardToDeck(int deckId, int cardId);



}
