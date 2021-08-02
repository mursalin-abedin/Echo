package com.techelevator.controller;

import java.sql.*;


public class Test {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/final_capstone";
    static final String USER = "postgres";
    static final String PASS = "postgres1";
    private static String QUERY = "SELECT card_id, question, answer FROM cards";

    public static void main(String[] args) {
        QUERY ="BEGIN TRANSACTION;\n" +
                "\n" +
                "DROP TABLE IF EXISTS users, cards, decks, decks_cards, keywords, keywords_cards;\n" +
                "DROP SEQUENCE IF EXISTS seq_user_id;\n" +
                "\n" +
                "CREATE SEQUENCE seq_user_id\n" +
                "  INCREMENT BY 1\n" +
                "  NO MAXVALUE\n" +
                "  NO MINVALUE\n" +
                "  CACHE 1;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE users (\n" +
                "\tuser_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,\n" +
                "\tusername varchar(50) NOT NULL,\n" +
                "\tpassword_hash varchar(200) NOT NULL,\n" +
                "\trole varchar(50) NOT NULL,\n" +
                "\tCONSTRAINT PK_user PRIMARY KEY (user_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE cards (\n" +
                "        card_id serial primary key,\n" +
                "        question varchar(1000) NOT NULL,\n" +
                "        answer varchar(1000) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE keywords (\n" +
                "        keyword_id serial primary key,\n" +
                "        keyword varchar(25) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE decks (\n" +
                "        deck_id serial primary key,\n" +
                "        deck_name varchar(25)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE decks_cards (\n" +
                "        deck_id int NOT NULL,\n" +
                "        card_id int NOT NULL,\n" +
                "        \n" +
                "        constraint fk_decks_cards_deck_id foreign key (deck_id) references decks(deck_id),\n" +
                "        constraint fk_decks_cards_card_id foreign key (card_id) references cards(card_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE keywords_cards (\n" +
                "        keyword_id int NOT NULL,\n" +
                "        card_id int NOT NULL,\n" +
                "        \n" +
                "        constraint fk_keywords_cards_keyword_id foreign key (keyword_id) references keywords(keyword_id),\n" +
                "        constraint fk_keywords_cards_card_id foreign key (card_id) references cards(card_id)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');\n" +
                "INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');\n" +
                "\n" +
                "INSERT INTO cards (question, answer) VALUES ('What year were the Boston Celtics founded?', 'Founded in 1946 as one of the league''s original eight teams, the Celtics are one of only two charter franchises (the other being the New York Knicks) still playing in their original city today.');\n" +
                "INSERT INTO cards (question, answer) VALUES ('What is the name of the Boston Celtics'' mascot?', 'Lucky the Leprechaun');\n" +
                "INSERT INTO cards (question, answer) VALUES ('Which Celtic was the first African-American player in the NBA?', 'On April 25, 1950, Chuck Cooper became the first African-American player drafted into the NBA when the Boston Celtics chose him with the 14th overall pick. When other teams suggested he shouldn''t be drafted because he was black, Celtics'' owner Walter A. Brown famously responded, \"I don''t give a damn if he''s striped, plaid or polka dot. Boston takes Charles Cooper of Duquesne.\"');\n" +
                "INSERT INTO cards (question, answer) VALUES ('Who is the oldest Celtics player to score 40 points in a game?', 'On December 19, 2012, at the age of 35 years, 2 months, and 6 days, Paul Pierce scored 40 points in a 103-91 win over the Cleveland Cavaliers.');\n" +
                "INSERT INTO cards (question, answer) VALUES ('Who did the Boston Celtics select with the 3rd pick in the 2017 NBA Draft?', 'Jayson Tatum');\n" +
                "\n" +
                "INSERT INTO cards (question, answer) VALUES ('When was Shrek released?', '2001');\n" +
                "INSERT INTO cards (question, answer) VALUES ('Who plays the voice of Shrek?', 'Mike Meyers');\n" +
                "INSERT INTO cards (question, answer) VALUES ('What is the first word said in Shrek?', 'Once');\n" +
                "INSERT INTO cards (question, answer) VALUES ('What is the first song in the movie Shrek?', 'All Star by Smash Mouth');\n" +
                "INSERT INTO cards (question, answer) VALUES ('What does Donkey want to make Shrek for breakfast?', 'Waffles');\n" +
                "\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"I burned my hand, at night!\"', 'Spongebob');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"Don''t you have to be stupid somewhere else?\"', 'Sandy');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"The inner machinations of my mind are an enigma.\"', 'Patrick');\n" +
                "INSERT INTO cards (question, answer) VALUES ('?Who you calling pinhead??', 'Patrick');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"Did you smell it? That smell. A kind of smelly smell. The smelly smell that smells...smelly.\"', 'Mr. Krabs');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"I''m ugly and I''m proud!\"', 'Spongebob ');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"If I were to die right now in a fiery explosion due to the carelessness of a friend?. Then it would just be alright.\"', 'Spongebob');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"Don?t you DARE take the name of Texas in vain.\"', 'Sandy');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"Fortunately, I have enough talent for all of you.\"', 'Squidward');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"You''re good! You''re good! You''re good!\"', 'Spongebob ');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"A five letter word for happiness?money.\"', 'Mr. Krabs');\n" +
                "INSERT INTO cards (question, answer) VALUES ('\"Please come again. When I''m not working.\"', ' Squidward');\n" +
                "\n" +
                "\n" +
                "COMMIT TRANSACTION;";

        String query2 = "SELECT card_id, question, answer FROM cards";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Boolean temp = stmt.execute(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query2);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("card_id: " + rs.getString("card_id"));
                System.out.print(", question: " + rs.getString("question"));
                System.out.print(", answer: " + rs.getString("answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
