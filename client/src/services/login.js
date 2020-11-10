import axios from "axios"

axios.defaults.baseURL = location.protocol + "//" + location.hostname + ":" + 3000;

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
