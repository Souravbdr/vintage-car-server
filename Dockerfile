# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/system-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application listens on
EXPOSE 8080

# Set the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
