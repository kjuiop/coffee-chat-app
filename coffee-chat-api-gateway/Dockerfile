FROM adoptopenjdk/openjdk11
ARG port
ARG JAR_FILE_PATH=./bin/coffee-chat-api-gateway.jar
COPY ${JAR_FILE_PATH} coffee-chat-api-gateway.jar
EXPOSE ${port}
ENTRYPOINT ["java", "-jar", "coffee-chat-api-gateway.jar"]
