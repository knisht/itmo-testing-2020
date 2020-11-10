import LoginComponent from "@/pages/Login/Login";
import SecureComponent from "@/pages/Login/Secure";

export default [
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
