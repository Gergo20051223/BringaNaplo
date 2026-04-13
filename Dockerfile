# 1. szakasz: Az alkalmazás felépítése (Build)
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. szakasz: Az alkalmazás futtatása
FROM openjdk:17-jdk-slim
COPY --from=build /target/bringanaplo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]