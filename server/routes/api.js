const express = require("express")
const router = express.Router()
const gameService = require("../models/guessingGame")


router.get("/game", gameService)

module.exports = router