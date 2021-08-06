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
    getCardsNotInCurrentDeck(deckId) {
        return axios.get(`/decks/${deckId}/cardsNotIncluded`)
    },
    createCard(newCard) {
        console.log("newCard:" + newCard)
        return axios.post('/cards', {
            question: newCard.question,
            answer: newCard.answer,
            keywords: newCard.keywords,
            deckId: newCard.deckId
        })

    },
    getCardById(cardId) {
        return axios.get(`/cards/${cardId}`)
    },
    editCard(newCard){
        return axios.put(`/cards/${newCard.cardId}`, {
            question: newCard.question,
            answer: newCard.answer,
            keywords: newCard.keywords,
            cardId: newCard.cardId
        }) 
    },
   
    
}