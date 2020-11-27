# BlackBox 

## Backend setup
Backend server will listen `localhost:3000`

### Legacy NodeJS backend
Setup dependencies:
```shell script
cd server-js 
npm install 
```

Run:
```shell script
node app.js 
```
### Glorious JVM backend
PostgreSQL required.  
Run with
```shell script
./gradlew bootRun
```

## Frontend setup
Frontend uses VueJS.

Setup dependencies:
```shell script
npm install
```

Start application:
```shell script
yarn serve
```

Test application:

There are two test configurations: local and e2e.
- For local(unit and component) test, be sure nothing listens localhost:3000 -- 
this address will be occupied by the mock server. Then you can run tests by the following command:
```shell script
yarn test:unit
```
- For e2e tests, you need to run backend at localhost:3030 and frontend at localhost:8000. 
Then the following command will run all e2e tests.
```shell script
yarn test:e2e
```

