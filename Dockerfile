# Сборка
FROM maven:3.9.7-amazoncorretto-21 AS build
WORKDIR /home/app
COPY pom.xml .mvn ./
COPY src ./src
RUN mvn clean package -DskipTests

# Запуск
FROM amazoncorretto:21
COPY --from=build /home/app/target/*.jar /app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app.jar"]
