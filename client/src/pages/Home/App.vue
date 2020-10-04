<template>
  <div id="app">
    <TopMenu class="top-menu" :links="linkData"/>
    <img alt="BlackBox logo" src="../../assets/blackbox.png">
    <Greeting msg="Welcome to the BlackBox App"/>
  </div>
</template>

<script>
import Greeting from './Greeting.vue'
import TopMenu from "@/components/TopMenu";

export default {
  name: 'App',
  components: {
    TopMenu,
    Greeting
  },
  data: function() {
    return {
      linkData: [ {text: "About", link: "about"}, {text: "Guess", link: "guess"}, {text: "Login", link: "login"}]
    }
  }
}
</script>

<style>
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
