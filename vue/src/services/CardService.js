import axios from 'axios';

export default {
    getCard() {
        return axios.get('/card/:id')
    }
}