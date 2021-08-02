package com.techelevator.dao;

import com.techelevator.model.Card;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface CardDAO {

    Card getCard(int cardId);

    List<Card> getAllCards();

    List<Card> getAllCardsByUser(int userId);

}
