package com.techelevator.controller;

import com.techelevator.dao.DeckDAO;
import com.techelevator.model.Deck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class DeckController {
    private DeckDAO deckDAO;

    public DeckController(DeckDAO deckDAO) {
        this.deckDAO = deckDAO;
    }

    @RequestMapping(path = "/decks/{deckId}", method = RequestMethod.GET)
    public Deck getDeckById(@PathVariable int deckId) {
        return deckDAO.getDeckById(deckId);
    }

    @RequestMapping(path = "/decks", method = RequestMethod.GET)
    public List<Deck> getAllDecks() {
        return deckDAO.getAllDecks();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/decks/{deckId}", method = RequestMethod.DELETE)
    public void deleteDeck(@PathVariable int deckId) {
        deckDAO.deleteDeck(deckId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/decks", method = RequestMethod.POST)
    public void createDeck(@RequestBody Deck deck) {
        deckDAO.createDeck(deck.getDeckName(), deck.getDeckDescription());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/decks/{deckId}", method = RequestMethod.PUT)
    public void updateDeck(@PathVariable int deckId, @RequestBody Deck deck) {
        deckDAO.updateDeck(deck.getDeckName(), deck.getDeckDescription(), deckId);
    }

}
