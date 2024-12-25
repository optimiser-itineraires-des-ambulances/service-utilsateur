# FROM maven:latest
# WORKDIR /app
# COPY . /app
# EXPOSE 8080
# CMD ["mvn", "spring-boot:run"]

FROM openjdk:21-slim
# Switch to root user to install additional packages
USER root

# Install PostgreSQL client
RUN apt-get update && apt-get install -y postgresql-client && apt-get clean

VOLUME /tmp
ADD target/service-user-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
