<template>
  <div id="app">
    <TopMenu class="top-menu" :links="linkData"/>
    <GuessingGame :sequence="sequence" :result="answer"/>
  </div>
</template>

<script>
import TopMenu from "@/components/TopMenu";
import GuessingGame from "@/pages/Guess/GuessingGame";

export default {
  name: 'App',
  components: {
    GuessingGame,
    TopMenu
  },
  data: function () {
    return {
      linkData: [{text: "Home", link: "index.html"}, {text: "Login", link: "login"}],
      sequence: [1, 2, 3, 4, 5],
      answer: 6
    }
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  height: 100%;
  margin: 0;
  top: 0;
}
</style>