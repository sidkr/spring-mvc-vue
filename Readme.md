# Spring MVC + Hibernate + Maven + VueJS

## To run locally (development mode)

Prerequisites (Node 14 or greater, Java 8 or greater)

### UI (VueJS)
* cd `src/app` from root directory
* `npm install` 
* `npm run start`
* Go to `localhost:3000` for standalone UI app

### Backend (Java)
* Run as spring web project on favorite IDE on Tomcat server
* Backend runs on `localhost:8080`


## To run in production mode 
* Install node dependencies first by going to `src/app` and running `npm i`
* From root dir execute `mvn tomcat7:run` 
* Go to `localhost:8080` (UI Builds and runs in prod mode)
