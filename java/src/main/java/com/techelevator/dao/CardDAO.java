package com.techelevator.dao;

import com.techelevator.model.Card;
import java.util.List;

public interface CardDAO {

    Card getCard(int cardId);

    List<Card> getAllCards();

}
