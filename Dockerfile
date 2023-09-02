FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
COPY target/security-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]