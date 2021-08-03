<template>
    <div class="mainappbody">
        <Decklist :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <Cards :cards="cards" />
    </div>
</template>

<script>
import axios from 'axios'
    import Decklist from '../components/Decklist'
    import Cards from '../components/Cards'

    export default {
        name: 'Home',
        components: {
            Decklist,
            Cards
        },
        data(){
            return {
                decks: [{   //remove when cors is resolved 
                            "deckId": 1,
                            "deckName": "Celtics Facts"
                        },
                        {
                            "deckId": 2,
                            "deckName": "Shrek Facts"
                        },
                        {
                            "deckId": 3,
                            "deckName": "SpongeBob Quotes"
                        }
                        ],
                cards: [
                        {
                            "cardId": 1,
                            "question": "What year were the Boston Celtics founded?",
                            "answer": "Founded in 1946 as one of the league's original eight teams, the Celtics are one of only two charter franchises (the other being the New York Knicks) still playing in their original city today.",
                            "keywords": "Celtics",
                            "userId": 1
                        },
                        {
                            "cardId": 2,
                            "question": "What is the name of the Boston Celtics' mascot?",
                            "answer": "Lucky the Leprechaun",
                            "keywords": "Celtics",
                            "userId": 1
                        },
                        {
                            "cardId": 3,
                            "question": "Which Celtic was the first African-American player in the NBA?",
                            "answer": "On April 25, 1950, Chuck Cooper became the first African-American player drafted into the NBA when the Boston Celtics chose him with the 14th overall pick. When other teams suggested he shouldn't be drafted because he was black, Celtics' owner Walter A. Brown famously responded, \"I don't give a damn if he's striped, plaid or polka dot. Boston takes Charles Cooper of Duquesne.\"",
                            "keywords": "Celtics",
                            "userId": 1
                        }
                        ]
            }
        },
        methods: {
            async addNewDeck(){
                console.log("Add New Deck!")
            },
            async getDeck(deckId){
                console.log(`Get Deck! ${deckId}`)
            },
            async getAllDecks() {
                axios.get('http://localhost:8080/decks').then(resp => {
                    console.log(resp)
                    this.decks = resp
                    })
                
            }
        },
        created(){
           //this.getAllDecks()
        }

        
    }
</script>

<style scoped>
.mainappbody{
    display: flex;
}
</style>