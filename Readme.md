# Spring boot Docker starter application
this app is use simple single table in memory database to setup docker in spring boot in many ways we start from use simple jdk-alpine and will use spring native creation image 
## Dockerfile
will use small jdk image and setup Docker file with following 
```dockerfile
FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```
we have User spring and rename jar file to start this docker image will run
```shell
$ mvn package
$ docker build -t docker-spring:17-alpine .
```
### environment variable
to change any application.properties variable will use environment variable option in docker run for example in this application I use spring-rest data so we can change base url using --env
```shell
$ docker run --rm -p 8080:8080 --env spring_data_rest_basePath=rest-api docker-spring:17-alpine
```

## docker-compose
in docker compase we use compose to build image and run application in port 8080 
### environment file
we need read environment variable form file so we use .env ass config variable to setup environment file .env
```dotenv
SPRING_DATA_REST_BASEPATH=rest-api
```
now run docker-compose 
```shell
$ mvn package
$ docker-compose up
```

