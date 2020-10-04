<template>
  <div class="top-menu">
    <div class="topnav" id="top-list">
      <a v-bind:key="link" v-for="link in links" :href=link.link> {{ link.text }}</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "TopMenu",
  props: {
    links: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.top-menu {
  overflow: auto;
  width: 100%;
}

.topnav {
  margin: 0;
  overflow: auto;
  width: 100%;
}

.topnav a {
  float: left;
  color: #000000;
  text-align: center;
  height: 20px;
  margin: 0;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 120%;
  width: 48%;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
  font-size: 150%;
}

</style>