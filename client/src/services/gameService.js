import axios from "axios"

export default {
    getGame() {
        return axios.get("/api/game").then(res => res.data)
    },
}