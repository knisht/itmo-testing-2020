<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p class="conversation">
      What is this website about?
    </p>
    <p class="conversation">
      No one knows!
    </p>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
  margin-top: 50px;
}
h1 {
  font-size: 300%;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.conversation {
  font-size: 120%;
}
</style>
