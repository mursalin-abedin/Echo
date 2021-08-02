package com.techelevator.dao;

import com.techelevator.model.Card;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCardDAO implements CardDAO {

    private JdbcTemplate jdbcTemplate;


    public JDBCCardDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Card getCard(int cardId) {
        Card newCard = new Card();
        String sql = "SELECT card_id, question, answer FROM cards WHERE card_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, cardId);

        while (rowSet.next()) {
            newCard = mapRowToCard(rowSet);
        }
        return newCard;
    }

    @Override
    public List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();
        String sql = "SELECT card_id, question, answer FROM cards";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            Card newCard = mapRowToCard(rowSet);
            allCards.add(newCard);
        }
        return allCards;
    }

    private Card mapRowToCard(SqlRowSet rowSet){
        Card newCard = new Card();
        newCard.setCardId(rowSet.getInt("card_id"));
        newCard.setQuestion(rowSet.getString("question"));
        newCard.setAnswer(rowSet.getString("answer"));
//        newCard.setUserId(rowSet.getInt("user_id"));
        return newCard;
    }

}
