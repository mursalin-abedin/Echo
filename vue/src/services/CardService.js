import axios from 'axios';

export default {
    getAllCards() {
        return axios.get('/cards')
    },
    getCard() {
        return axios.get('/cards/:id')
    },
    getCardByDeck(deckId) {
        return axios.get(`/decks/${deckId}/cards`)
    },
    createCard() {
        return axios.post('/cards', {
            question: 'does vue work?',
            answer: 'maybe?',
            keywords: 'dumb'
        })
    }

}