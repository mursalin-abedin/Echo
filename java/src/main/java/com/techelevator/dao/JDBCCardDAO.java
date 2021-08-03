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
    public Card getCardById(int cardId) {
        Card card = new Card();
        String sql = "SELECT card_id, question, answer, user_id, keywords  FROM cards WHERE card_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, cardId);

        while (rowSet.next()) {
            card = mapRowToCard(rowSet);
        }
        return card;
    }

    @Override
    public List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();
        try {
            String sql = "SELECT card_id, question, answer, user_id, keywords FROM cards";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()) {
                Card newCard = mapRowToCard(rowSet);
                allCards.add(newCard);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return allCards;
    }

    @Override
    public List<Card> getAllCardsByUserId(int userId) {
        List<Card> allCardsByUser = new ArrayList<>();
        try {
            String sql = "SELECT card_id, question, answer, user_id, keywords  FROM cards WHERE user_id = ?";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

            while (rowSet.next()) {
                Card newCard = mapRowToCard(rowSet);
                allCardsByUser.add(newCard);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return allCardsByUser;
    }

    @Override
    public void deleteCard(int cardId) {
        String sqlForDeckJoin = "DELETE FROM decks_cards WHERE card_id = ?";
        jdbcTemplate.update(sqlForDeckJoin, cardId);

        String sqlForCardsTable = "DELETE FROM cards WHERE card_id = ?";
        jdbcTemplate.update(sqlForCardsTable, cardId);
    }

//    @Override
//    public Card createCard(String question, String answer, String keywords, int userId) {
//        Card newCard = new Card();
//        String sql = "INSERT INTO cards (card_id, question, answer, keywords, user_id) VALUES (DEFAULT, ?, ?, ?, ?) RETURNING card_id";
//        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, question, answer, keywords, userId);
//
//        while (rowSet.next()) {
//            newCard = mapRowToCard(rowSet);
//        }
//
//        return newCard;
//    }

    private Card mapRowToCard(SqlRowSet rowSet) {
        Card card = new Card();
        card.setCardId(rowSet.getInt("card_id"));
        card.setQuestion(rowSet.getString("question"));
        card.setAnswer(rowSet.getString("answer"));
        card.setKeywords(rowSet.getString("keywords"));
        card.setUserId(rowSet.getInt("user_id"));
        return card;
    }

}
