BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, cards, decks, decks_cards, keywords, keywords_cards;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE cards (
        card_id serial primary key,
        question varchar(1000) NOT NULL,
        answer varchar(1000) NOT NULL
);

CREATE TABLE keywords (
        keyword_id serial primary key,
        keyword varchar(25) NOT NULL
);

CREATE TABLE decks (
        deck_id serial primary key,
        deck_name varchar(25)
);

CREATE TABLE decks_cards (
        deck_id int NOT NULL,
        card_id int NOT NULL,
        
        constraint fk_decks_cards_deck_id foreign key (deck_id) references decks(deck_id),
        constraint fk_decks_cards_card_id foreign key (card_id) references cards(card_id)
);

CREATE TABLE keywords_cards (
        keyword_id int NOT NULL,
        card_id int NOT NULL,
        
        constraint fk_keywords_cards_keyword_id foreign key (keyword_id) references keywords(keyword_id),
        constraint fk_keywords_cards_card_id foreign key (card_id) references cards(card_id)
);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cards (question, answer) VALUES ('What year were the Boston Celtics founded?', 'Founded in 1946 as one of the league''s original eight teams, the Celtics are one of only two charter franchises (the other being the New York Knicks) still playing in their original city today.');
INSERT INTO cards (question, answer) VALUES ('What is the name of the Boston Celtics'' mascot?', 'Lucky the Leprechaun');
INSERT INTO cards (question, answer) VALUES ('Which Celtic was the first African-American player in the NBA?', 'On April 25, 1950, Chuck Cooper became the first African-American player drafted into the NBA when the Boston Celtics chose him with the 14th overall pick. When other teams suggested he shouldn''t be drafted because he was black, Celtics'' owner Walter A. Brown famously responded, "I don''t give a damn if he''s striped, plaid or polka dot. Boston takes Charles Cooper of Duquesne."');
INSERT INTO cards (question, answer) VALUES ('Who is the oldest Celtics player to score 40 points in a game?', 'On December 19, 2012, at the age of 35 years, 2 months, and 6 days, Paul Pierce scored 40 points in a 103-91 win over the Cleveland Cavaliers.');
INSERT INTO cards (question, answer) VALUES ('Who did the Boston Celtics select with the 3rd pick in the 2017 NBA Draft?', 'Jayson Tatum');

INSERT INTO cards (question, answer) VALUES ('When was Shrek released?', '2001');
INSERT INTO cards (question, answer) VALUES ('Who plays the voice of Shrek?', 'Mike Meyers');
INSERT INTO cards (question, answer) VALUES ('What is the first word said in Shrek?', 'Once');
INSERT INTO cards (question, answer) VALUES ('What is the first song in the movie Shrek?', 'All Star by Smash Mouth');
INSERT INTO cards (question, answer) VALUES ('What does Donkey want to make Shrek for breakfast?', 'Waffles');

INSERT INTO cards (question, answer) VALUES ('"I burned my hand, at night!"', 'Spongebob');
INSERT INTO cards (question, answer) VALUES ('"Don''t you have to be stupid somewhere else?"', 'Sandy');
INSERT INTO cards (question, answer) VALUES ('"The inner machinations of my mind are an enigma."', 'Patrick');
INSERT INTO cards (question, answer) VALUES ('“Who you calling pinhead?”', 'Patrick');
INSERT INTO cards (question, answer) VALUES ('"Did you smell it? That smell. A kind of smelly smell. The smelly smell that smells...smelly."', 'Mr. Krabs');
INSERT INTO cards (question, answer) VALUES ('"I''m ugly and I''m proud!"', 'Spongebob ');
INSERT INTO cards (question, answer) VALUES ('"If I were to die right now in a fiery explosion due to the carelessness of a friend…. Then it would just be alright."', 'Spongebob');
INSERT INTO cards (question, answer) VALUES ('"Don’t you DARE take the name of Texas in vain."', 'Sandy');
INSERT INTO cards (question, answer) VALUES ('"Fortunately, I have enough talent for all of you."', 'Squidward');
INSERT INTO cards (question, answer) VALUES ('"You''re good! You''re good! You''re good!"', 'Spongebob ');
INSERT INTO cards (question, answer) VALUES ('"A five letter word for happiness…money."', 'Mr. Krabs');
INSERT INTO cards (question, answer) VALUES ('"Please come again. When I''m not working."', ' Squidward');

INSERT INTO cards (question, answer) VALUES ('What is the difference between procedural and object-oriented programs?', 'In procedural program, programming logic follows certain procedures and the instructions are executed one after another. In OOP program, unit of program is object, which is nothing but combination of data and code ');
INSERT INTO cards (question, answer) VALUES ('What is OOPs?', 'Object oriented programming organizes a program around its data, i. e. , objects and a set of well defined interfaces to that data. An object-oriented program can be characterized as data controlling access to code. ');
INSERT INTO cards (question, answer) VALUES ('What is the difference between constructor and method? ', ' Constructor will be automatically invoked when an object is created whereas method has to be called explicitly.');
INSERT INTO cards (question, answer) VALUES ('What is the difference between superclass and subclass?', ' A super class is a class that is inherited whereas sub class is a class that does the inheriting.');
INSERT INTO cards (question, answer) VALUES (' What is a package?', ' A package is a collection of classes and interfaces that provides a high-level layer of access protection and name space management.');
INSERT INTO cards (question, answer) VALUES ('What is an abstract class? ', ' An abstract class is a class designed with implementation gaps for subclasses to fill in and is deliberately incomplete.');


COMMIT TRANSACTION;
