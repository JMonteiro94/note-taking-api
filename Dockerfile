FROM openjdk:8-jre-alpine
EXPOSE 8081
VOLUME /tmp
WORKDIR /tmp
ARG JAR_FILE=/target/note-taking-api.jar
ADD ${JAR_FILE} note-taking-api.jar
ENTRYPOINT ["java", "-jar", "note-taking-api.jar"]