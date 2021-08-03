package com.techelevator.dao;

import com.techelevator.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCDeckDAO implements DeckDAO{

    private JdbcTemplate jdbcTemplate;

    public JDBCDeckDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Deck getDeckById(int deckId) {
        Deck deck = new Deck();
        String sql = "SELECT deck_id, deck_name FROM decks WHERE deck_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckId);

        while (rowSet.next()) {
            deck = mapRowToDeck(rowSet);
        }
        return deck;
    }

    @Override
    public List<Deck> getAllDecks() {
        List<Deck> allDecks = new ArrayList<>();
        try {
            String sql = "SELECT deck_id, deck_name FROM decks";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()) {
                Deck newDeck = mapRowToDeck(rowSet);
                allDecks.add(newDeck);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return allDecks;
    }

    @Override
    public void deleteDeck(int deckId) {
        String sqlForCardJoin = "DELETE FROM decks_cards WHERE deck_id = ?";
        jdbcTemplate.update(sqlForCardJoin, deckId);

        String sqlForDecksTable = "DELETE FROM decks WHERE deck_id = ?";
        jdbcTemplate.update(sqlForDecksTable, deckId);
    }

//    @Override
//    public Deck createDeck(String deckName) {
//        Deck newDeck = new Deck();
//        String sql = "INSERT INTO decks (deck_id, deckName) VALUES (DEFAULT, ?) RETURNING deck_id";
//        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckName);
//
//        while (rowSet.next()) {
//            newDeck = mapRowToDeck(rowSet);
//        }
//
//        return newDeck;
//    }

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck deck = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setDeckName(rowSet.getString("deck_name"));
        return deck;
    }

}
