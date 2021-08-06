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
                ArrayList<Integer> deckIds = getAllDeckIds(newCard.getCardId());
                newCard.setDeckIds(deckIds);
                allCards.add(newCard);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return allCards;
    }

    @Override
    public List<Card> getAllCardsNotInADeck(int deckId) {
        List<Card> allCards = new ArrayList<>();
        try {
            String sql = "SELECT cards.card_id, cards.question, cards.answer, cards.keywords, cards.user_id," +
                    " decks_cards.deck_id FROM cards RIGHT JOIN decks_cards ON decks_cards.card_id = cards.card_id" +
                    " WHERE decks_cards.deck_id != ?";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckId);

            while (rowSet.next()) {
                Card newCard = mapRowToCard(rowSet);
                newCard.setDeckId(rowSet.getInt("deck_id"));
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
    public List<Card> getAllCardsByDeckId(int deckId) {
        List<Card> allCardsByDeckId = new ArrayList<>();
        String sql = "SELECT cards.card_id, cards.question, cards.answer, cards.keywords, cards.user_id " +
                "FROM cards JOIN decks_cards ON decks_cards.card_id = cards.card_id JOIN decks ON" +
                " decks.deck_id = decks_cards.deck_id WHERE decks.deck_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckId);

        while (rowSet.next()) {
            Card newCard = new Card();
            newCard.setCardId(rowSet.getInt("card_id"));
            newCard.setQuestion(rowSet.getString("question"));
            newCard.setAnswer(rowSet.getString("answer"));
            newCard.setKeywords(rowSet.getString("keywords"));
            newCard.setUserId(rowSet.getInt("user_id"));
            newCard.setDeckId(deckId);
            allCardsByDeckId.add(newCard);
        }

        return allCardsByDeckId;
    }

    @Override
    public void deleteCard(int cardId) {
        String sqlForDeckJoin = "DELETE FROM decks_cards WHERE card_id = ?";
        jdbcTemplate.update(sqlForDeckJoin, cardId);

        String sqlForCardsTable = "DELETE FROM cards WHERE card_id = ?";
        jdbcTemplate.update(sqlForCardsTable, cardId);
    }

    @Override
    public void createCard(String question, String answer, String keywords, int deckId) {
        String sql = "INSERT INTO cards (card_id, question, answer, keywords, user_id) VALUES (DEFAULT, ?, ?, ?, 1);";
        String sql2 = "INSERT INTO decks_cards (deck_id, card_id) VALUES (?,(SELECT MAX(card_id) FROM cards));";
        jdbcTemplate.update(sql, question, answer, keywords);
        jdbcTemplate.update(sql2, deckId);

    }

    @Override
    public void updateCard(String question, String answer, String keywords, int cardId) {
        String sql = "UPDATE cards SET question = ?, answer = ?, keywords = ?, user_id = 1 WHERE card_id = ?";
        jdbcTemplate.update(sql, question, answer, keywords, cardId);
    }

    @Override
    public void removeCardFromDeck(int deckId, int cardId) {
        String sql = "DELETE FROM decks_cards WHERE deck_id = ? AND card_id = ?";
        jdbcTemplate.update(sql, deckId, cardId);
    }

    @Override
    public void addCardToDeck(int deckId, int cardId) {
        String sql = "INSERT INTO decks_cards (deck_id, card_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, deckId, cardId);
    }

    private ArrayList<Integer> getAllDeckIds(int cardId){
        ArrayList<Integer> deckIds = new ArrayList<Integer>();
        String sql = "select deck_id from decks_cards where card_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, cardId);

        while (rowSet.next()) {
            deckIds.add(rowSet.getInt("deck_id"));
        }
        return deckIds;
    }

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
