<template>
  <div id="login">
    <h1>Login</h1>
    <div>
      <form id="sign-in">
        <label>
          <input id="username-input" type="text" name="username" v-model="input.username" placeholder="Username"/>
        </label>
        <label>
          <input id="password-input" type="password" name="password" v-model="input.password" placeholder="Password"/>
        </label>
        <button id="login-button" type="button" v-on:click="login">Login</button>
        <div v-if="shouldShowAuthorizationError">Incorrect login or password</div>
      </form>
    </div>
  </div>
</template>

<script>
import loginService from "@/services/login"

export default {
  name: 'Login',
  data() {
    return {
      input: {
        username: "",
        password: ""
      },
      shouldShowAuthorizationError: false
    }
  },
  computed: {
    isAuthenticated() {
      console.log(this.isAuthenticated)
      return this.isAuthenticated
    }
  },
  methods: {
    login() {
      loginService.tryLogin(this.input.username, this.input.password).then(isAuthenticated => {
        if (isAuthenticated) {
          this.$router.replace({name: "secure"})
          this.$parent.$data.isAuthenticated = true
        } else {
          this.$set(this, "shouldShowAuthorizationError", true)
        }
      })
    }
  },
  mounted() {
    if (this.$parent.isAuthenticated) {
      this.$router.replace({ name: "secure" })
    }
  }
}
</script>

<style scoped>
#login {
  width: 500px;
  border: 1px solid #CCCCCC;
  background-color: #FFFFFF;
  margin: 200px auto auto;
  padding: 20px;
}
</style>
