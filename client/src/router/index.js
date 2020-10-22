import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginComponent from "../pages/Login/Login.vue"
import SecureComponent from "../pages/Login/Secure.vue"

Vue.use(VueRouter)

export default new VueRouter({
    routes: [
        {
            path: "",
            name: "login",
            component: LoginComponent
        },
        {
            path: "/secure",
            name: "secure",
            component: SecureComponent,
        }
    ]
})
