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

    modifyDeck(deckId, deck) {
        console.log(deckId, deck)
        return axios.put(`/decks/${deckId}`, {
            deckName: deck.deckName,
            deckDescription: deck.deckDescription
        })
    },
    getDeck(deckId){
        return axios.get(`/decks/${deckId}`)
    }

}