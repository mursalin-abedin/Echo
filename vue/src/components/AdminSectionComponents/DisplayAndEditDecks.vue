<template>
  <div class="decks">
    <!-- <div class="deckstoolbar">
            <input class="deckssearch" placeholder="enter text here to filter decks"/>
            <div class="deckiconbox">
                <div class="collapsedecks">
                    <i class="fas fa-chevron-circle-up"></i>
                </div>
            </div>
        </div> -->
    <div class="deckarea">
      <div
        :class="deck.deckId == currentDeckId ? 'selecteddeck' : 'deck'"
        v-for="deck in sortedList"
        :key="deck.deckId"
        @click="$emit('get-deck', deck)"
      >
        <div class="decktitlebox">
          <div class="decktitle">
            {{ deck.deckName }}
          </div>
          <div
            class="editdeck"
            @click="
              isShowEdit = !isShowEdit;
              setEditDeck(deck);
            "
          >
            <i class="fas fa-edit"></i>
          </div>
          <!-- <div class="deletedeck" >
                <i class="fas fa-trash"></i>
                </div> -->
        </div>
        <div class="deckdescription">
          {{ deck.deckDescription }}
        </div>

        <div v-if="isShowEdit && deck.deckId == currentDeckId">
          <div class="decktitlebox">
            <div class="decktitle">Edit Deck</div>
            <div class="editdeck" @click="onSubmitEdit">
              <i class="fas fa-check"></i>
            </div>
          </div>
          <form class="add-deck">
            <div class="editform">
              <div class="editname">
                <div class="form-control">
                  <textarea
                    class="editinput"
                    type="text"
                    v-model="editDeckName"
                    name="editDeckName"
                    placeholder="Enter name..."
                  />
                </div>
                <div class="editdescription"></div>
                <div class="form-control">
                  <textarea
                    class="editinput"
                    type="text"
                    v-model="editDeckDescription"
                    name="editDeckDescription"
                    placeholder="Enter description...."
                  />
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>

      <div class="deck">
        <div class="decktitlebox">
          <div class="decktitle">Add New Deck</div>
          <div class="editdeck" @click="onSubmit">
            <i class="fas fa-plus-circle"></i>
          </div>
        </div>
        <form @submit="onSubmit" class="add-deck">
          <div class="editform">
            <div class="editname">
              <div class="form-control">
                <textarea
                  class="editinput"
                  type="text"
                  v-model="deckName"
                  name="deckName"
                  placeholder="Enter name..."
                />
              </div>
              <div class="editdescription"></div>
              <div class="form-control">
                <textarea
                  class="editinput"
                  type="text"
                  v-model="deckDescription"
                  name="deckDescription"
                  placeholder="Enter description...."
                />
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedDeck: 0,
      deckName: "",
      deckDescription: "",
      editDeckName: "",
      editDeckDescription: "",
      isShowEdit: false,
    };
  },
  name: "DisplayAndEditDecks",
  props: {
    decks: Array,
    currentDeckId: Number,
  },
  computed: {
    sortedList() {
      return this.decks.slice().sort(function (a, b) {
        return a.deckId - b.deckId;
      });
    },
  },
  methods: {
    setSelectedDeck(deckId) {
      this.selectedDeck = deckId;
    },
    clearSelectedDeck() {
      this.selectedDeck = 0;
    },
    showEditDeck(deck) {
      this.$emit("show-edit-deck", deck);
    },
    setEditDeck(deck) {
      this.editDeckName = deck.deckName;
      this.editDeckDescription = deck.deckDescription;
    },
    onSubmit(e) {
      e.preventDefault();
      if (!this.deckName) {
        alert("Please fill the blanks");
        return;
      }
      const ndeck = {
        deckName: this.deckName,
        deckDescription: this.deckDescription,
      };
      this.$emit("add-deck", ndeck);
    },
    onSubmitEdit(e) {
      e.preventDefault();
      if (!this.editDeckName) {
        alert("Please fill the blanks");
        return;
      }
      const ndeck = {
        deckName: this.editDeckName,
        deckDescription: this.editDeckDescription,
      };
      this.$emit("edit-deck", ndeck);
      this.isShowEdit = false;
    },
  },
};
</script>

<style scoped>
.add-deck {
  justify-content: center;
}

.btn-block {
  justify-content: right;
  margin-top: 5px;
}

.selectdeckarea {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: #a3d2ca;
  width: 80%;
  margin: 20px;
  padding: 0px 20px 0px 20px;
  border-radius: 5px;
  /*    border: 2px dotted #999999;*/
  box-shadow: 2px 2px 2px #c0c0c0;
  border-bottom: 4px solid #ffffff;
  transition: all 0.4s ease;
}

.selectdeckbannertext {
  margin: 20px;
  font-size: 20pt;
}

.decks {
  display: flex;
  flex-direction: column;
  background: #a3d2ca;
  width: 80%;
  margin: 20px;
  padding: 0px 20px 0px 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  justify-content: center;
  border-bottom: 4px solid #5eaaa8;
  transition: all 0.4s ease;
}

.deckstoolbar {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  background: #ffffff;
  width: 100%;
  padding: 10px;
  border-bottom: 1px solid #a0a0a0;
  border-radius: 5px 5px 0px 0px;
}

.deckarea {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  background: #a3d2ca;
  width: 100%;
}

.deckssearch {
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
  margin: 0px 0px 0px 10px;
}

.deckiconbox {
  display: flex;
}

.adddeckbox {
  display: block;
  margin: 0px 0px 0px 0px;
}

.adddeckbox:hover {
  cursor: pointer;
}

.adddeckogo {
  display: block;
  width: 30px;
  height: 30px;
  font-size: 16pt;
  background: #efefef;
  border-radius: 50%;
  border: 3px solid #666666;
  margin: 10px 0px 0px 20px;
}

.adddeckogo:hover {
  border: 3px solid #f05945;
  background: #cfcfcf;
}

.adddeckadjust {
  margin: 0px 0px 0px 0px;
  color: #f05945;
  margin: 5px 0px 0px 6px;
}

.adddeckwords {
  display: block;
  font-family: Montserrat;
  font-size: 12pt;
  margin: 5px 0px 0px 0px;
}

.deck {
  display: flex;
  flex-direction: column;
  background: #f7f3e9;
  width: 40%;
  min-height: 100px;
  margin: 20px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  border-bottom: 4px solid #5eaaa8;
  transition: all 0.4s ease;
  /*    border: 4px solid red;*/
}

.selecteddeck {
  display: flex;
  flex-direction: column;
  background: #f7f3e9;
  width: 40%;
  min-height: 100px;
  margin: 20px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  border-bottom: 4px solid #f05945;
  transition: all 0.4s ease;
  border: 4px solid #f05945;
}

.deck:hover {
  border-bottom: 4px solid #f05945;
  /*    box-shadow: 2px 2px 2px red;*/
}

.decktitlebox {
  display: flex;
  border-bottom: 1px solid #a0a0a0;
}

.collapsedecks {
  width: 10px;
  padding: 10px;
  color: #2c0777;
}

.collapsedecks:hover {
  color: #f05945;
}

.editdeck {
  width: 10px;
  padding: 10px;
  color: #f05945;
}

.editdeck:hover {
  color: #f05945;
}

.deletedeck {
  width: 10px;
  padding: 10px;
  color: #f05945;
}

.deletedeck2 {
  width: 10px;
  padding: 0px 10px 0px 10px;
  color: #f05945;
}

.decktitle {
  width: 90%;
  font-size: 16pt;
  padding: 10px;
  color: #333333;
}

.deckdescription {
  font-size: 12pt;
  padding: 10px 0px 10px 10px;
  color: #333333;
}

.editinput {
  border-top-style: hidden;
  border-right-style: hidden;
  border-left-style: hidden;
  border-bottom-style: groove;
  background-color: #a3d2ca;
  border-radius: 0px;
  height: 50px;
  width: 90%;
  padding: 10px;
  font-size: 12pt;
}

.editform {
  display: flex;
  flex-direction: column;
  flex-basis: 100%;
  flex: 1;
}

.editinput {
  border-top-style: hidden;
  border-right-style: hidden;
  border-left-style: hidden;
  border-bottom-style: groove;
  background-color: #eeeeee;
  border-radius: 0px;
  height: 50px;
  width: 90%;
  padding: 10px;
  font-size: 12pt;
}

textarea {
  outline: none;
  border-bottom: 2px solid #f05945;
  transition: all 0.4s ease;
  resize: none;
}
</style>