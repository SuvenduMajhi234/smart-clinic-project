# Stage 1: Build Stage (অ্যাপটি তৈরি করার জন্য)
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage (অ্যাপটি চালানোর জন্য)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# অ্যাপটি ৮০৮০ পোর্টে চলবে
EXPOSE 8080

# অ্যাপটি চালু করার কমান্ড
ENTRYPOINT ["java", "-jar", "app.jar"]
