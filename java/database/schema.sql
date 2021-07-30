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


COMMIT TRANSACTION;
