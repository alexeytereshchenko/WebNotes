FROM adoptopenjdk:11-jdk-hotspot as builder
WORKDIR /build
COPY . .
RUN ["./mvnw", "package", "-Dmaven.test.skip=true"]

FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=builder "/build/target/WebNotes.jar" .
CMD ["java", "-jar", "WebNotes.jar"]