FROM eclipse-temurin:17

LABEL maintainer="reachvaibhavsaxena@gmail.com"

WORKDIR /app

COPY target/service-registry-0.0.1-SNAPSHOT.jar app/service-registry.jar

ENTRYPOINT ["java", "-jar", "service-registry.jar"]