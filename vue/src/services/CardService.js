import axios from 'axios';

export default {
    getAllCards(){
        return axios.get('/cards')
    },
    getCard() {
        return axios.get('/cards/:id')
    }
}