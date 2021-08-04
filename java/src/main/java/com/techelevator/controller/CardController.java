package com.techelevator.controller;

import com.techelevator.dao.CardDAO;
import com.techelevator.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@PreAuthorize("permitAll")
@CrossOrigin
@RestController
public class CardController {
    private CardDAO cardDAO;

    public CardController(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @RequestMapping(path = "/cards/{cardId}", method = RequestMethod.GET)
    public Card getCardById(@PathVariable int cardId) {
        return cardDAO.getCardById(cardId);
    }

    @RequestMapping(path = "/cards", method = RequestMethod.GET)
    public List<Card> getAllCards() {
        return cardDAO.getAllCards();
    }

    @RequestMapping(path = "/cards/user_id={userId}", method = RequestMethod.GET)
    public List<Card> getAllCardsByUser(@PathVariable int userId) {
        return cardDAO.getAllCardsByUserId(userId);
    }

    @RequestMapping(path = "/decks/{deckId}/cards", method = RequestMethod.GET)
    public List<Card> getAllCardsByDeckId(@PathVariable int deckId) {
        return cardDAO.getAllCardsByDeckId(deckId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/cards/{cardId}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable int cardId) {
        cardDAO.deleteCard(cardId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/cards", method = RequestMethod.POST)
    public void createCard(@RequestBody Card card) {
        cardDAO.createCard(card.getQuestion(), card.getAnswer(), card.getKeywords(), card.getDeckId());
    }
}
