<template>
  <div class="game">
    <h1>Here are some numbers:</h1>
    <ul>
      <li v-bind:key="num" v-for="num in sequence">{{ num }}</li>
    </ul>
    <h1>So what goes next?</h1>
    <label>
      <input v-model.number="userInput" type="number" placeholder="Type the number">
    </label>
    <p v-if="isGuessedCorrectly">
      Ok!
    </p>
    <p v-else-if="isNontrivialInput">
      No, you're wrong.
    </p>
  </div>
</template>

<script>
export default {
  name: "GuessingGame",
  computed: {
    isGuessedCorrectly() {
      return this.result === this.userInput
    },
    isNontrivialInput() {
      console.log(this.userInput.length)
      return this.userInput.length !== 0
    }
  },
  props: {
    sequence: {
      type: Array,
      required: true
    },
    result: {
      type: Number,
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