This is a base project to get started using Vue with Spring Boot Web.

This project is designed to package the compiled code into a `.war` for deployment into web containers (default: Tomcat).

# Node npm & Vue CLI
You will need npm and the Vue CLI intalled. [Full Instructions](https://cli.vuejs.org/guide/installation.html)
## npm 
Goto the [Node.js Site](https://nodejs.org/en/) to install.
## Vue CLI
```
npm install -g @vue/cli
```

# Building and running
Here are some commands to get build and run the application
## Development
These sets of commands will continously build & serve the client and server as files change.
You will need 2 terminals open because the watch commands are interactive

### Terminal 1 - Building the client app
```
cd client
npm run build-dev
```
### Terminal 2 - Building and serving server w/SPA hosting
```
cd server
mvn spring-boot:run -Dspring-boot.run.profiles=development
```
### Alternative
These can be executed with the Vue UI and your IDE if desired;
just adjust the run configuration to match. 
