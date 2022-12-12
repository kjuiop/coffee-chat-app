FROM adoptopenjdk/openjdk11
ARG port
ARG JAR_FILE_PATH=./bin/coffee-chat-service-api.jar
COPY ${JAR_FILE_PATH} coffee-chat-service-api.jar
EXPOSE ${port}
ENTRYPOINT ["java", "-jar", "coffee-chat-service-api.jar"]
