<template>
  <div id="app">
    <TopMenu class="top-menu" :links="linkData"/>
    <AboutDescription/>
  </div>
</template>

<script>
import TopMenu from "@/components/TopMenu";
import AboutDescription from "@/pages/About/AboutDescription";

export default {
  name: 'App',
  components: {
    AboutDescription,
    TopMenu,
  },
  data: function () {
    return {
      linkData: [ {text: "Home", link: "index.html"}, {text: "Login", link: "login"}]
    };
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
