const request = require('sync-request');
module.exports = getGameInstance

function buildQuery(id) {
    return `https://oeis.org/search?q=id:A${id}&fmt=json`
}

function buildHumanReadableQuery(id) {
    return `https://oeis.org/search?q=id:A${id}`
}

function get(url) {
    return request('GET', url)
}

function getGameInstance(req, res) {
    const instance = doGetGameInstance()
    res.send(instance)
}

function doGetGameInstance() {
    const randomNumber = Math.floor(Math.random() * 1000)
    const query = buildQuery(randomNumber)
    const res = get(query).body.toString('utf-8')
    const response = JSON.parse(res).results[0]
    const array = response.data.split(",").map(x => parseInt(x, 10))
    return {
        sequence: array.slice(0, 10),
        result: array[10],
        name: response.name,
        link: buildHumanReadableQuery(randomNumber)
    }
}
