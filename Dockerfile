FROM maven:3.9.8-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

FROM eclipse-temurin:17-alpine
# WORKDIR /app
COPY --from=build /app/target/practice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
