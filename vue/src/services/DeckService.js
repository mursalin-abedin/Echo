import axios from 'axios';

export default {
    getAllDecks(){
        return axios.get('/decks')
    },

    createNewDeck(ndeck) {
        return axios.post('/decks', {
            deckName: ndeck.deckName,
            deckDescription: ndeck.deckDescription,
        })
    },
    removeCardFromDeck(card, deckId) {
        console.log("removing", card)
        return axios.delete(`/decks/${deckId}/cards`,  { data: {cardId: card.cardId } }
        )

    },
    addCardToDeck(card, deckId) {
        return axios.post(`/decks/${deckId}/cards`, card)
    },

}