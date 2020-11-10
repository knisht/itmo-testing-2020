import Vue from 'vue'
import VueRouter from 'vue-router'
import loginRoutes from "@/router/loginRoutes";

Vue.use(VueRouter)

export default new VueRouter({
    routes: loginRoutes
})
