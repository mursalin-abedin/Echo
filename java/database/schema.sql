BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, cards, decks_cards, decks;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id serial PRIMARY KEY,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL
);

CREATE TABLE cards(
        card_id serial PRIMARY KEY,
        question varchar(1000) NOT NULL,
        answer varchar(1000) NOT NULL,
        keywords varchar(1000),
        user_id int NOT NULL,
        
        CONSTRAINT fk_cards_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE decks(
        deck_id serial PRIMARY KEY,
        deck_name varchar(100) NOT NULL,
        deck_description varchar(1000),
        user_id int NOT NULL,
        
        CONSTRAINT fk_decks_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE decks_cards(
        deck_id int NOT NULL,
        card_id int NOT NULL,
        
        CONSTRAINT fk_decks_cards_deck_id FOREIGN KEY (deck_id) REFERENCES decks(deck_id),
        CONSTRAINT fk_decks_cards_card_id FOREIGN KEY (card_id) REFERENCES cards(card_id)
);


INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO cards (question, answer, keywords, user_id) VALUES ('When was Shrek released?', '2001', 'Shrek', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('Who plays the voice of Shrek?', 'Mike Meyers', 'Shrek', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the first word said in Shrek?', 'Once', 'Shrek', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the first song in the movie Shrek?', 'All Star by Smash Mouth', 'Shrek', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What does Donkey want to make Shrek for breakfast?', 'Waffles', 'Shrek', 1);

INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between procedural and object-oriented programs?', 'In procedural program, programming logic follows certain procedures and the instructions are executed one after another. In OOP program, unit of program is object, which is nothing but combination of data and code ', 'Coding', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is OOPs?', 'Object oriented programming organizes a program around its data, i. e. , objects and a set of well defined interfaces to that data. An object-oriented program can be characterized as data controlling access to code. ', 'Coding', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between constructor and method? ', ' Constructor will be automatically invoked when an object is created whereas method has to be called explicitly.', 'Coding', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is the difference between superclass and subclass?', ' A super class is a class that is inherited whereas sub class is a class that does the inheriting.', 'Coding', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES (' What is a package?', ' A package is a collection of classes and interfaces that provides a high-level layer of access protection and name space management.', 'Coding', 1);
INSERT INTO cards (question, answer, keywords, user_id) VALUES ('What is an abstract class? ', ' An abstract class is a class designed with implementation gaps for subclasses to fill in and is deliberately incomplete.', 'Coding', 1);

INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('Shrek Facts', 'Test your knowledge on the greatest animated film of all time!', 1);
INSERT INTO decks (deck_name, deck_description, user_id) VALUES ('Coding Questions', 'Test your knowledge on coding!', 1);

INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 1);
INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 2);
INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 3);
INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 4);
INSERT INTO decks_cards (deck_id, card_id) VALUES (1, 5);

INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 6);
INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 7);
INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 8);
INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 9);
INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 10);
INSERT INTO decks_cards (deck_id, card_id) VALUES (2, 11);


COMMIT TRANSACTION;
