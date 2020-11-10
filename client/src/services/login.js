import axios from "axios"

axios.defaults.baseURL = typeof location === 'undefined' ? "localhost:3000" : location.protocol + "//" + location.hostname + ":" + 3000;
axios.defaults.adapter = require('axios/lib/adapters/http');

export default {
    tryLogin(username, password) {
        return axios.post("/login", null, {
            params: {username: username, password: password},
            withCredentials: true
        }).then(res => res.data)
    },
    checkAuthentication() {
        return axios.get("/logged", {withCredentials: true}).then(res => res.data)
    },
    logout() {
        return axios.get("/logout", {withCredentials: true}).then(res => res.data)
    }
}
