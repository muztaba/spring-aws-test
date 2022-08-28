FROM gradle:7.5.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar app/

RUN ls app/

ENTRYPOINT ["java","-jar","/app/dockertest-0.0.1-SNAPSHOT.jar"]