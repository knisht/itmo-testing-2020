<template>
  <div class="game">
    <h1>Here are some numbers:</h1>
    <p v-if="!areNumbersLoaded">
      Loading...
    </p>
    <ul v-else id="numbers">
      <li v-bind:key="num" v-for="num in game.sequence">{{ num }}</li>
    </ul>
    <h1>So what goes next?</h1>
    <label>
      <input v-model.number="userInput" type="number" placeholder="Type the number" id="input_form" />
    </label>
    <p v-if="isGuessedCorrectly" id="correct_answer">
      Ok!
      <br>
      This is a "{{ game.name }}"
      <br>
      Read more at <a :href="game.link">OEIS</a>
    </p>
    <p v-else-if="isNontrivialInput" id="incorrect_answer">
      No, you're wrong.
    </p>
  </div>
</template>

<script>
export default {
  name: "GuessingGame",
  computed: {
    isGuessedCorrectly() {
      return this.game.result === this.userInput
    },
    isNontrivialInput() {
      return this.userInput.length !== 0
    },
    areNumbersLoaded() {
      return "sequence" in this.game
    }
  },
  props: {
    game: {
      required: true
    }
  },
  data() {
    return {
      userInput: '',
    }
  }
}
</script>

<style scoped>
.game {
  font-size: 120%;
}

li {
  margin: 10px;
}

input {
  font-size: 120%;
}
ul {
  list-style-type: none;
  padding: 0;
}
</style>
