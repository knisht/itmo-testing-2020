<template>
  <div id="login">
    <h1>Login</h1>
    <div v-if="!isAuthenticated">
      <label>
        <input type="text" name="username" v-model="input.username" placeholder="Username" />
      </label>
      <label>
        <input type="password" name="password" v-model="input.password" placeholder="Password" />
      </label>
      <button type="button" v-on:click="login()">Login</button>
    </div>
    <div v-else>
      You are already logged in.
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      input: {
        username: "",
        password: ""
      }
    }
  },
  computed: {
    isAuthenticated() {
      return this.$parent.authenticated
    }
  },
  methods: {
    login() {
      if(this.input.username !== "" && this.input.password !== "") {
        if(this.input.username === this.$parent.mockAccount.username && this.input.password === this.$parent.mockAccount.password) {
          this.$emit("authenticated", true);
          this.$router.replace({ name: "secure" });
        } else {
          console.log("The username and / or password is incorrect");
        }
      } else {
        console.log("A username and password must be present");
      }
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
