FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
COPY target/security-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]