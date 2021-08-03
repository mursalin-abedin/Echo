import axios from 'axios';

export default {
    getAllDecks(){
        return axios.get('/decks')
    }
}