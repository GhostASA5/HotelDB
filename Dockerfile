# Первый этап: сборка приложения
FROM maven:3.9.7-amazoncorretto-21 AS build
WORKDIR /home/app
COPY pom.xml .mvn ./
COPY src ./src
RUN mvn package -DskipTests

FROM amazoncorretto:21

ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} /app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app.jar"]