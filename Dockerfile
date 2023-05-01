FROM openjdk:17-jdk-alpine AS build
#WORKDIR /app
#COPY target/demo-0.0.1-SNAPSHOT.jar  /app
#CMD ["java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
