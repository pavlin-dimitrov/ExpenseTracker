FROM eclipse-temurin:17-jdk-focal as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files into the image
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Copy the source files
COPY src ./src

# Run the Gradle wrapper to download dependencies and build the project
RUN ./gradlew clean build

# Create a new stage for the final image, using a JRE (Java Runtime Environment) base image
FROM eclipse-temurin:17-jdk-focal

# Set the working directory inside the container for the final image
WORKDIR /app

# Copy the built JAR file from the builder stage to the final stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
