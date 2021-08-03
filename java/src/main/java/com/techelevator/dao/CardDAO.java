package com.techelevator.dao;

import com.techelevator.model.Card;
import java.util.List;

public interface CardDAO {

    Card getCardById(int cardId);

    List<Card> getAllCards();

    List<Card> getAllCardsByUserId(int userId);

    List<Card> getAllCardsByDeckId(int deckId);

    void deleteCard(int cardId);

    void createCard(String question, String answer, String keywords);

}
