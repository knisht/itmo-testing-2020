<template>
  <div id="app">
    <TopMenu class="top-menu"/>
    <img alt="BlackBox logo" src="../../assets/blackbox.png">
    <HelloWorld msg="Welcome to the BlackBox App, About page!"/>
  </div>
</template>

<script>
import HelloWorld from '../../components/Greeting.vue'
import TopMenu from "@/components/TopMenu";

export default {
  name: 'App',
  components: {
    TopMenu,
    HelloWorld
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
