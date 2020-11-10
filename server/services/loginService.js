const config = require("../config.js")


function authorize(login, password) {
    let foundUser = false;
    // really smart authentication mechanism. it will be changed as soon as backend will be moved to java or so
    config.users.forEach(userInfo => {
        if (login === userInfo.username && password === userInfo.password) foundUser = true;
    });
    if (foundUser) {
        return {username: login, password: password};
    } else {
        return null;
    }
}

module.exports = authorize
