FROM eclipse-temurin:17

LABEL maintainer="reachvaibhavsaxena@gmail.com"

WORKDIR /app

COPY target/department-service-0.0.1-SNAPSHOT.jar app/department-service.jar

ENTRYPOINT ["java", "-jar", "department-service.jar"]