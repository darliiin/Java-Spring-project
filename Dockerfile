FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]

FROM postgres:15.2-alpine AS db
ENV POSTGRES_USER postgresql
ENV POSTGRES_PASSWORD 123       
ENV POSTGRES_DB uni 
ADD init.sql /docker-entrypoint-initdb.d/
