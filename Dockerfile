# Build stage
FROM openjdk:17-jdk-alpine AS build

COPY . /app
WORKDIR /app

RUN chmod +x mvnw  \
    && ./mvnw clean package -DskipTests  \
    && mv -f target/*.jar app.jar

# Production stage
FROM openjdk:17-jdk-alpine AS production

EXPOSE 8080

COPY --from=build /app/app.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]