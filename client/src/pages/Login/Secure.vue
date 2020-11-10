<template>
  <div id="secure">
    <h1>You have successfully logged in.</h1>
    <p>
      But what for? It will not give you anything.
    </p>
  </div>
</template>

<script>
export default {
  name: "Secure",
  mounted() {
    if (!this.$parent.isAuthenticated) {
      this.$router.replace({ name: "login" })
    }
  }
}
</script>

<style scoped>
#secure {
  background-color: #FFFFFF;
  border: 1px solid #CCCCCC;
  padding: 20px;
  margin-top: 10px;
}
</style>
