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
    }

}