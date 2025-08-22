# ================================
# 1. Build stage
# ================================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set the working directory
WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .

# Download dependencies (this helps with Docker build caching)
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application (skip tests for faster build, remove -DskipTests if needed)
RUN mvn clean package -DskipTests

# ================================
# 2. Run stage
# ================================
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy jar file from builder
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
