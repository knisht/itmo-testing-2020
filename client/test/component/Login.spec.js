/**
 * @jest-environment jsdom
 */
import {fireEvent, queryByAttribute, render} from '@testing-library/vue';
import ServerMock from "mock-http-server";
import App from "@/pages/Login/App";
import loginRoutes from "@/router/loginRoutes";

const routes = loginRoutes

const server = new ServerMock({host: "localhost", port: 3000}, {});

const getById = queryByAttribute.bind(null, 'id');

beforeEach(function (done) {
    server.start(done);
});

afterEach(function (done) {
    server.stop(done);
});


test('Successful login', async () => {

    const login = 'abcde'
    const password = 'abcdef'

    server.on({
        method: 'POST',
        path: '/login',
        reply: {
            status: 200,
            headers: {"content-type": "application/json"},
            body: req => JSON.stringify((req.username === login && req.password === password))
        }
    });
    server.on({
        method: 'GET',
        path: '/logged',
        reply: {
            status: 200,
            headers: {"content-type": "application/json"},
            body: JSON.stringify(false)
        }
    })

    const {getByPlaceholderText, getByText, container} = render(App, {routes});

    const usernameForm = getByPlaceholderText("Username");
    await fireEvent.update(usernameForm, 'abcde');

    const passwordForm = getByPlaceholderText("Password");
    await fireEvent.update(passwordForm, 'abcde');

    const button = getByText("Login", {selector: '#login-button'})
    await fireEvent.click(button)

    const delay = ms => new Promise(res => setTimeout(res, ms));
    await delay(100) // waiting for asynchronous query
    getById(container, "secure")
})
