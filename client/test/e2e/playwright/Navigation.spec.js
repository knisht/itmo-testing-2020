const { chromium, devices } = require('playwright')
const { expect } = require('chai')
const delay = ms => new Promise(res => setTimeout(res, ms));

describe('My example E2E test with Playwright', () => {
  let browser
  let page
  const iphone = devices['iPhone 11 Pro']

  it('Go to Login and Back', async () => {

    browser = await chromium.launch()
    page = await browser.newPage()
    await page.goto('http://localhost:8080/')

    const point = await page.$('text=Login')
    await point.click()

    await delay(200) // waiting for asynchronous query

    const back = await page.$('text=go back')
    expect(back).not.null
    await back.click()

    await delay(200) // waiting for asynchronous query

    const pointAgain = await page.$('text=Login')
    expect(pointAgain).not.undefined

    await page.close()
    await browser.close()
  })

  it('Usage with iphone', async () => {

    browser = await chromium.launch()
    const context = await browser.newContext({...iphone})
    page = await context.newPage()
    await page.goto('http://localhost:8080/')

    const point = await page.$('text=Login')
    await point.click()

    await delay(200) // waiting for asynchronous query

    const back = await page.$('text=go back')
    expect(back).not.null
    await back.click()

    await delay(200) // waiting for asynchronous query

    const pointAgain = await page.$('text=Login')
    expect(pointAgain).not.undefined

    await page.close()
    await browser.close()
  })
})
