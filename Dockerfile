FROM openjdk:17

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /demo.jar

CMD ["java", "-jar", "/demo.jar"]