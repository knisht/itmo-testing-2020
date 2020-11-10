import axios from "axios"

axios.defaults.baseURL = location.protocol + "//" + location.hostname + ":" + 3000;

export default {
    getGame() {
        return axios.get("/api/game").then(res => res.data)
    },
}
