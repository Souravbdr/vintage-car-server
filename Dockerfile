# Use an official Maven image as the build environment
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project's POM file
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the project source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new stage for the runtime environment
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
