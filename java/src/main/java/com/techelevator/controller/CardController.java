package com.techelevator.controller;

import com.techelevator.dao.CardDAO;
import com.techelevator.model.Card;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//@PreAuthorize("permitAll")
@RestController
public class CardController {
    private CardDAO cardDAO;

    public CardController(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @RequestMapping(path = "/cards", method = RequestMethod.GET)
    public List<Card> getAllCards(){
        return cardDAO.getAllCards();
    }

}
