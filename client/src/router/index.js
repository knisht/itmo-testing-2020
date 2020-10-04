import Vue from "vue"
import Router from "vue-router"
import GuessingGame from "@/pages/Guess/GuessingGame"

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: "/game",
            name: "Game",
            component: GuessingGame
        }
    ]
})