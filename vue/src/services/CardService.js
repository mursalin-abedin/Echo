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
    createCard(newCard) {
        console.log("newCard:" + newCard)
        return axios.post('/cards', {
            question: newCard.question,
            answer: newCard.answer,
            keywords: newCard.keywords,
            deckId: newCard.deckId
        })

    }    
}