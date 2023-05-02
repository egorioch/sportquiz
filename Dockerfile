FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY build/libs/sportquiz-1.0-SNAPSHOT.jar app.jar
ENV APP_FILE=app.jar
ENTRYPOINT ["sh", "-c", "java -jar $APP_FILE"]
