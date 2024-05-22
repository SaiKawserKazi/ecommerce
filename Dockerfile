# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the local file system to the container
COPY build/libs/e-commerce-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
