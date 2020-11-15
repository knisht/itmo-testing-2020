# BlackBox 

## Backend setup
Backend server will listen `localhost:3000`

### Legacy NodeJS backend
Setup dependencies:
```
cd server-js 
npm install 
```

Run:
```
node app.js 
```

## Frontend setup
Frontend uses VueJS.

Setup dependencies:
```
npm install
```

Start application:
```
yarn serve
```

Test application:

There are two test configurations: local and e2e.
- For local(unit and component) test, be sure nothing listens localhost:3000 -- 
this address will be occupied by the mock server. Then you can run the tests by the following command:
```
yarn test:unit
```
- For e2e tests, you need to run backend at localhost:3030 and frontend at localhost:8080. 
Then the following command will run all e2e tests.
```
yarn test:e2e
```

