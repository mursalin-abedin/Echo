package com.techelevator.controller;

import java.sql.*;


public class Test {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/final_capstone";
    static final String USER = "postgres";
    static final String PASS = "postgres1";
    private static String QUERY = "SELECT card_id, question, answer FROM cards";

    public static void main(String[] args) {
        QUERY = "BEGIN TRANSACTION;\n" +
                "\n" +
                "DROP TABLE IF EXISTS users, cards, decks_cards, decks;\n" +
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
                "\tuser_id serial PRIMARY KEY,\n" +
                "\tusername varchar(50) NOT NULL,\n" +
                "\tpassword_hash varchar(200) NOT NULL,\n" +
                "\trole varchar(50) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE cards(\n" +
                "        card_id serial PRIMARY KEY,\n" +
                "        question varchar(1000) NOT NULL,\n" +
                "        answer varchar(1000) NOT NULL,\n" +
                "        keywords varchar(1000),\n" +
                "        user_id int NOT NULL,\n" +
                "        \n" +
                "        CONSTRAINT fk_cards_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE decks(\n" +
                "        deck_id serial PRIMARY KEY,\n" +
                "        deck_name varchar(100) NOT NULL,\n" +
                "        deck_description varchar(1000),\n" +
                "        user_id int NOT NULL,\n" +
                "        \n" +
                "        CONSTRAINT fk_decks_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE decks_cards(\n" +
                "        deck_id int NOT NULL,\n" +
                "        card_id int NOT NULL,\n" +
                "        \n" +
                "        CONSTRAINT fk_decks_cards_deck_id FOREIGN KEY (deck_id) REFERENCES decks(deck_id),\n" +
                "        CONSTRAINT fk_decks_cards_card_id FOREIGN KEY (card_id) REFERENCES cards(card_id)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');\n" +
                "INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');\n" +
                "\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What year were the Boston Celtics founded?', 'Founded in 1946 as one of the league''s original eight teams, the Celtics are one of only two charter franchises (the other being the New York Knicks) still playing in their original city today.', 'Celtics', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the name of the Boston Celtics'' mascot?', 'Lucky the Leprechaun', 'Celtics', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('Which Celtic was the first African-American player in the NBA?', 'On April 25, 1950, Chuck Cooper became the first African-American player drafted into the NBA when the Boston Celtics chose him with the 14th overall pick.', 'Celtics', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('Who is the oldest Celtics player to score 40 points in a game?', 'On December 19, 2012, at the age of 35 years, 2 months, and 6 days, Paul Pierce scored 40 points in a 103-91 win over the Cleveland Cavaliers.', 'Celtics', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('Who did the Boston Celtics select with the 3rd pick in the 2017 NBA Draft?', 'Jayson Tatum', 'Celtics', 1);\n" +
                "\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('When was Shrek released?', '2001', 'Shrek', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('Who plays the voice of Shrek?', 'Mike Meyers', 'Shrek', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the first word said in Shrek?', 'Once', 'Shrek', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the first song in the movie Shrek?', 'All Star by Smash Mouth', 'Shrek', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What does Donkey want to make Shrek for breakfast?', 'Waffles', 'Shrek', 1);\n" +
                "\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"I burned my hand, at night!\"', 'Spongebob', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"Don''t you have to be stupid somewhere else?\"', 'Sandy', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"The inner machinations of my mind are an enigma.\"', 'Patrick', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('�Who you calling pinhead?�', 'Patrick', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"Did you smell it? That smell. A kind of smelly smell. The smelly smell that smells...smelly.\"', 'Mr. Krabs', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"I''m ugly and I''m proud!\"', 'Spongebob ', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"If I were to die right now in a fiery explosion due to the carelessness of a friend�. Then it would just be alright.\"', 'Spongebob', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"Don�t you DARE take the name of Texas in vain.\"', 'Sandy', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"Fortunately, I have enough talent for all of you.\"', 'Squidward', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"You''re good! You''re good! You''re good!\"', 'Spongebob ', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"A five letter word for happiness�money.\"', 'Mr. Krabs', 'Spongebob', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('\"Please come again. When I''m not working.\"', ' Squidward', 'Spongebob', 1);\n" +
                "\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between procedural and object-oriented programs?', 'In procedural program, programming logic follows certain procedures and the instructions are executed one after another. In OOP program, unit of program is object, which is nothing but combination of data and code ', 'Coding', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is OOPs?', 'Object oriented programming organizes a program around its data, i. e. , objects and a set of well defined interfaces to that data. An object-oriented program can be characterized as data controlling access to code. ', 'Coding', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between constructor and method? ', ' Constructor will be automatically invoked when an object is created whereas method has to be called explicitly.', 'Coding', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between superclass and subclass?', ' A super class is a class that is inherited whereas sub class is a class that does the inheriting.', 'Coding', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES (' What is a package?', ' A package is a collection of classes and interfaces that provides a high-level layer of access protection and name space management.', 'Coding', 1);\n" +
                "INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is an abstract class? ', ' An abstract class is a class designed with implementation gaps for subclasses to fill in and is deliberately incomplete.', 'Coding', 1);\n" +
                "\n" +
                "INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('Celtics Facts', 'Test your knowledge on the greatest NBA Franchise of all time!', 1);\n" +
                "INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('Shrek Facts', 'Test your knowledge on the greatest animated film of all time!', 1);\n" +
                "INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('SpongeBob Quotes', 'Who said what from the animated series Spongebob Squarepants', 1);\n" +
                "INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('Coding Questions', 'Test your knowledge on coding!', 1);\n" +
                "\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 1);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 2);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 3);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 4);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 5);\n" +
                "\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 6);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 7);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 8);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 9);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 10);\n" +
                "\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 11);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 12);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 13);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 14);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 15);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 16);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 17);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 18);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 19);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 20);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 21);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (3, 22);\n" +
                "\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 23);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 24);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 25);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 26);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 27);\n" +
                "INSERT INTO decks_cards (deck_id, card_id) VALUES (4, 28);\n" +
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
