# Start with a base image containing Java runtime
FROM eclipse-temurin:17-jdk-focal

# Add Maintainer Info
LABEL maintainer="pavdimitrov@gmail.com"

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files into the image
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Add the application's source files to the image
COPY src ./src

# Give execution rights to gradlew
RUN chmod +x ./gradlew

# Make port 8080 available to the world outside this container
EXPOSE 8081

# Run the application
CMD ["./gradlew", "bootRun", "--continuous"]



#FROM eclipse-temurin:17-jdk-focal as builder
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the Gradle build files into the image
#COPY build.gradle settings.gradle gradlew ./
#COPY gradle ./gradle
#
## Copy the source files
#COPY src ./src
#
## Run the Gradle wrapper to download dependencies and build the project
#RUN ./gradlew clean build
#
## Create a new stage for the final image, using a JRE (Java Runtime Environment) base image
#FROM eclipse-temurin:17-jdk-focal
#
## Set the working directory inside the container for the final image
#WORKDIR /app
#
## Copy the built JAR file from the builder stage to the final stage
#COPY --from=builder /app/build/libs/*.jar app.jar
#
## Set the entry point to run the JAR file
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
