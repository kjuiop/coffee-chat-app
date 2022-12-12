FROM adoptopenjdk/openjdk11
ARG port
ARG JAR_FILE_PATH=./bin/coffee-chat-external-api.jar
COPY ${JAR_FILE_PATH} coffee-chat-external-api.jar
EXPOSE ${port}
ENTRYPOINT ["java", "-jar", "coffee-chat-external-api.jar"]
