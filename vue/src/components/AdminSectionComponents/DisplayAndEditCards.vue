<template>
 <div class="editcardsarea">

    <div class="editcardsearchbox">
      <div class="spacer"></div>

      <input
        class="cardsfilter"
        v-model="searchbox"
        placeholder="Search cards by keywords here"
      />
      <div class="cardiconbox">
        <div class="showallcards" @click="toggleShowAllCardsSelected()">
          <i class="fas fa-globe"></i>
        </div>
        <!-- <div class="collapsecards">
                    <i class="fas fa-chevron-circle-up"></i>
                </div> -->
      </div>
    </div>
    
    <div class="cards">
      <div class="cardeditbox">
        <div class="editcardheader">
          <div class="cardnum">Create A New Card Here</div>

          <div class="editdeck" @click="onSubmit">
            <i class="fas fa-plus-circle"></i>
          </div>
        </div>
        <form @submit="onSubmit" class="add-deck">
          <div class="editcardbody">
            <div class="editquestion">
              <textarea
                class="editinput"
                v-model="nCard.question"
                name="question"
                placeholder="Enter Question..."
              ></textarea>
            </div>
            <div class="editanswer">
              <textarea
                class="editinput"
                v-model="nCard.answer"
                name="answer"
                placeholder="Enter Answer..."
              ></textarea>
            </div>
          </div>
          <div class="cardskeywordsbox">
            <input
              class="cardskeywords"
              v-model="nCard.keywords"
              name="keywords"
              placeholder="Enter Keywords"
            />
          </div>
        </form>
      </div>

      <div
        :class="
          card.deckIds.includes(currentDeckId) && showAllCardsSelected
            ? 'cardeditboxexistsindeck'
            : 'cardeditbox'
        "
        draggable="true"
        @dragstart="onDrag(card)"
        v-for="card in filteredList"
        :key="card.cardId"
      >
        <div class="editcardheader">
          <div class="cardnum">{{ card.question }}</div>

          <div class="editcardsiconbox">
            <div
              class="editcardbars"
              @click="
                isShowEdit = !isShowEdit;
                setEditCard(card);
              "
            >
              <i class="fas fa-edit"></i>
            </div>
            <div class="deletecard" @click="addOrRemoveCard(card)">
              <i
                :class="
                  card.deckIds.includes(currentDeckId)
                    ? 'fas fa-minus-circle'
                    : 'fas fa-plus-circle'
                "
              ></i>
            </div>
          </div>
        </div>
        <div class="editcardbody">
          {{ card.answer }}
        </div>
        <div class="cardskeywordsbox">Keywords: {{ card.keywords }}</div>

        <div v-if="isShowEdit && card.cardId == currentCardId">
          <div class="editcardheader">
            <div class="cardnum">Edit Card</div>

            <div class="editdeck" @click="onSubmitEdit">
              <i class="fas fa-check"></i>
            </div>
          </div>
          <form @submit="onSubmitEdit" class="add-deck">
            <div class="editcardbody">
              <div class="editquestion">
                <textarea
                  class="editinput"
                  v-model="editCard.question"
                  name="question"
                  placeholder="Enter Question..."
                ></textarea>
              </div>
              <div class="editanswer">
                <textarea
                  class="editinput"
                  v-model="editCard.answer"
                  name="answer"
                  placeholder="Enter Answer..."
                ></textarea>
              </div>
            </div>
            <div class="cardskeywordsbox">
              <input
                class="cardskeywords"
                v-model="editCard.keywords"
                name="keywords"
                placeholder="Enter Keywords"
              />
            </div>
          </form>
        </div>
      </div>
    </div>



<div class="drop-zone"
   v-if="currentDeckId > 0"
   @drop.prevent
   @dragover.prevent
   >

   <div><i/>Current Selected Deck: <b>{{currentDeckName}}</b>. Drag and Drop cards here to add to this deck.<i/></div>
  </div>

  

  </div>
</template>

<script>



export default {
  name: "DisplayAndEditCards",
  data() {
    return {
      searchbox: "",
      showAllCardsSelected: false,
      isShowEdit: false,
      currentCardId: "",
      nCard: {
        question: "",
        answer: "",
        keywords: "",
      },
      editCard: {
        question: "",
        answer: "",
        keywords: "",
        cardId: "",
      },
    };
  },
  props: {
    cards: Array,
    ncard: Object,
    currentDeckId: Number,
    currentDeckName: String
  },
  methods: {
    toggleShowAllCardsSelected() {
      this.showAllCardsSelected = !this.showAllCardsSelected;
    },
    setEditCard(card) {
      this.editCard.question = card.question;
      this.editCard.answer = card.answer;
      this.editCard.keywords = card.keywords;
      this.editCard.cardId = card.cardId;
      this.currentCardId = card.cardId;
    },
    addOrRemoveCard(card) {
      console.log(card);
      card.deckIds.includes(this.currentDeckId)
        ? this.$emit("remove-card-from-deck", card)
        : this.$emit("add-card-to-deck", card, this.currentDeckId);
    },
    onSubmit(e) {
      e.preventDefault();
      if (!this.nCard.question) {
        alert("Please fill the blanks");
        return;
      }
      const ncard = {
        question: this.nCard.question,
        answer: this.nCard.answer,
        keywords: this.nCard.keywords,
      };
      console.log("Created Ncard:" + ncard.question);
      this.$emit("add-new-card", ncard, this.currentDeckId);
      (this.nCard.question = ""),
        (this.nCard.answer = ""),
        (this.nCard.keywords = "");
    },
    onSubmitEdit(e) {
      e.preventDefault();
      if (!this.editCard.question) {
        alert("Please fill the blanks");
        return;
      }
      const ncard = {
        question: this.editCard.question,
        answer: this.editCard.answer,
        keywords: this.editCard.keywords,
        cardId: this.editCard.cardId,
      };
      this.$emit("edit-card", ncard);
      this.isShowEdit = false;
    },
    onDrag(card){
      console.log(card)

    }
  },
  computed: {
    filteredList() {
      console.log("this");
      if (this.showAllCardsSelected) {
        return this.cards
          .filter((card) => {
            return card.keywords
              .toLowerCase()
              .includes(this.searchbox.toLowerCase());
          })
          .slice()
          .sort(function (a, b) {
            return a.cardId - b.cardId;
          });
      }
      return this.cards
        .filter((card) => {
          return (
            card.keywords
              .toLowerCase()
              .includes(this.searchbox.toLowerCase()) &&
            card.deckIds.includes(this.currentDeckId)
          );
        })
        .slice()
        .sort(function (a, b) {
          return a.cardId - b.cardId;
        });
    },
  },
};
</script>

<style scoped>
.cards {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  background: #ffffff;
  width: 100%;
}

.editcardsarea {
  display: flex;
  flex-direction: column;
  background: #ffffff;
  width: 80%;
  margin: 20px;
  padding: 0px 20px 0px 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  justify-content: center;
  border-bottom: 4px solid #ffffff;
  transition: all 0.4s ease;
}

.editcardsiconbox {
  display: flex;
  padding: 0px;
}

.editcardsearchbox {
  display: flex;
  justify-content: space-between;
}

.cardeditbox {
  width: 40%;
  padding: 10px;
  min-height: 100px;
  margin: 10px;
  background: #fefefe;
  border: 1px solid #eeeeee;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  border-bottom: 4px solid #eeeeee;
  transition: all 0.4s ease;
}

.cardeditboxexistsindeck {
  width: 40%;
  padding: 10px;
  min-height: 100px;
  margin: 10px;
  background: #fefefe;
  border: 1px solid #eeeeee;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  border-bottom: 4px solid #eeeeee;
  transition: all 0.4s ease;
  border: 4px solid lightgreen;
}

.edittoolbar {
  display: flex;
}

.editcardheader {
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid #999999;
  padding: 10px 0px 10px 0px;
}

.editcardbody {
  padding: 10px 0px 10px 0px;
  display: flex;
}

.editquestion {
  width: 50%;
}

.editanswer {
  width: 50%;
}

.editinput {
  border-top-style: hidden;
  border-right-style: hidden;
  border-left-style: hidden;
  border-bottom-style: groove;
  background-color: #eeeeee;
  border-radius: 0px;
  height: 100px;
  width: 90%;
  padding: 10px;
  font-size: 12pt;
}
input,
textarea {
  outline: none;
}

textarea {
  resize: none;
}

textarea,
input:focus {
  outline: none;
  border-bottom: 2px solid #7b50d3;
  transition: all 0.4s ease;
}

.cardskeywords {
  line-height: 14px;
  background: #eeeeee;
  border-width: 0px;
  border: none;
  padding: 5px 20px 5px 20px;
  font-size: 11pt;
  color: #666666;
  transition: all 0.4s ease;
  width: 93%;
  border-bottom: 2px solid #7b50d3;
  margin: 0px 0px 0px 0px;
}

.cardsfilter {
  line-height: 20px;
  background: #e9e9e9;
  border-width: 0px;
  border: none;
  border-radius: 5px;
  padding: 5px 20px 5px 20px;
  font-size: 11pt;
  color: #999999;
  margin: 0px 0px 0px 0px;
  transition: all 0.4s ease;
  width: 50%;
  border-bottom: 2px solid #e9e9e9;
  text-align: center;
  margin: 10px 0px 0px 10px;
}

.editcardbars {
  width: 10px;
  padding: 0px 10px 0px 10px;
  color: #2c0777;
}

.cardnum {
  padding: 5px;
  font-size: 12pt;
}
.showallcards {
  width: 10px;
  padding: 10px;
  color: #2c0777;
}

.showallcards:hover {
  color: #7b50d3;
}

.collapsecards {
  width: 10px;
  padding: 10px;
  color: #2c0777;
}

.cardiconbox {
  display: flex;
}

.deletecard {
  width: 10px;
  padding: 0px 10px 0px 10px;
  color: #9d002d;
}

.cardskeywordsbox {
  font-size: 10pt;
  color: lightslategrey;
}

.fa-plus-circle {
  color: lightgreen;
}

.drop-zone {
  display: flex;
  height: 40px;
  position: fixed;
  bottom: 0;
  width: 50%;
  background-color: lightgreen;
  justify-content: center;
}
</style>