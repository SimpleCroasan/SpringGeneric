# Fase de construcción con Java 21
FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -Dmaven.test.skip=true

COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true -DskipTests

# Fase de ejecución con Java 21
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]