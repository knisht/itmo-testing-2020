<template>
  <div class="top-menu">
    <div class="topnav">
      <a href="about">About</a>
      <a href="#contact">Login</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "TopMenu"
}
</script>

<style scoped>
.topnav {
  /*padding-bottom: 20px;*/
  /*margin-bottom: 10px;*/
  overflow: auto;
  width: 100%;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #000000;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 120%;
  width: 48.25%;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
  font-size: 150%;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>