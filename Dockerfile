# Stage 1: Build stage
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn ./.mvn
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
