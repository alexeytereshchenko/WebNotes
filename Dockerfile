FROM openjdk:11
WORKDIR /app
COPY /target/WebNotes-0.0.1-SNAPSHOT.jar WebNotes.jar
ENTRYPOINT ["java", "-jar", "WebNotes.jar"]