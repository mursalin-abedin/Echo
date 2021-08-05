package com.techelevator.dao;

import com.techelevator.model.Deck;
import java.util.List;

public interface DeckDAO {

    Deck getDeckById(int deckId);

    List<Deck> getAllDecks();

    void deleteDeck(int deckId);

    void createDeck(String deckName, String deckDescription);

    void updateDeck(String deckName, String deckDescription, int deckId);

    void addCardToDeck(int deckId, int cardId);

}
