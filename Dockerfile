FROM adoptopenjdk/openjdk11

ARG JAR_FILE_PATH=/bin/coffee-chat-service-api.jar

COPY ${JAR_FILE_PATH} coffee-chat-service-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "coffee-chat-service-api.jar"]
