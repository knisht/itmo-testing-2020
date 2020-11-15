const express = require('express');
const port = 3000;
const passport = require('passport');
const Strategy = require('passport-local').Strategy;
const morgan = require('morgan');
const cors = require('cors');
const bodyParser = require('body-parser');
const expressSession = require('express-session');
const loginService = require("./services/loginService.js");
const apiRoutes = require('./routes/api');

passport.use(new Strategy(
    function (username, password, done) {
        const user = loginService(username, password)
        if (!user) {
            return done(null, false)
        }
        return done(null, user)

    }));


passport.serializeUser(function (user, cb) {
    cb(null, user);
});

passport.deserializeUser(function (obj, cb) {
    cb(null, obj);
});


// Create a new Express application.
const app = express();

// Configure view engine to render EJS templates.
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');


app.use(morgan('combined'));
app.use(bodyParser.urlencoded({extended: true}));
app.use(expressSession({secret: 'keyboard cat', resave: false, saveUninitialized: false}));
app.use(cors({credentials: true, origin: 'http://localhost:8080'}))

app.use(passport.initialize());
app.use(passport.session());

app.use('/api', apiRoutes)

app.post('/login',
    passport.authenticate('local', {}),
    function (req, res) {
        res.send(true);
    });

app.get('/logout',
    function (req, res) {
        req.logout();
        req.session.destroy()
    });

app.get("/logged", ((req, res) => {
    const x = req.user !== undefined
    res.send(x)
}));


const corsConfig = function (req, res, next) {
    res.header('Access-Control-Allow-Credentials', true)
    res.header('Access-Control-Allow-Origin', req.headers.origin)
    res.header('Access-Control-Allow-Methods', 'GET,HEAD,OPTIONS,POST,PUT')
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization, X-HTTP-Method-Override')
    next()
}

app.use(corsConfig);

module.exports = app;
app.listen(port);

console.log(`Server started at http://localhost:${port}`)
