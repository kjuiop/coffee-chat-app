FROM adoptopenjdk/openjdk11
ARG port
ARG JAR_FILE_PATH=./bin/coffee-chat-service-discovery.jar
COPY ${JAR_FILE_PATH} coffee-chat-service-discovery.jar
EXPOSE ${port}
ENTRYPOINT ["java", "-jar", "coffee-chat-service-discovery.jar"]
