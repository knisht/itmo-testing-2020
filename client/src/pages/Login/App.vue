<template>
  <div id="app">
    <a href="/">go back</a>
    <div id="nav">
      <router-link v-if="isAuthenticated" ref="logout" to="/" v-on:click.native="logout()" replace>Logout</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
import loginService from "@/services/login"

export default {

  name: 'App',
  data() {
    return {
      isAuthenticated: false,
    }
  },
  computed: {
    getAuthenticationStatus() {
      return loginService.checkAuthentication()
    }
  },
  mounted() {
    this.getAuthenticationStatus.then(isAuthenticated => {
      if (!isAuthenticated) {
        this.$router.replace({name: "login"});
      } else {
        this.$set(this, "isAuthenticated", true)
        this.$router.replace({name: "secure"})
      }
    })

  },
  methods: {
    logout() {
      loginService.logout()
      this.$set(this, "isAuthenticated", false);
      this.$router.replace({name: "login"});
    }
  }
}
</script>

<style scoped>
body {
  background-color: #F0F0F0;
}
h1 {
  padding: 0;
  margin-top: 0;
}
#app {
  width: 1024px;
  margin: auto;
}
</style>
