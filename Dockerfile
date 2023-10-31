FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/demo-1.0.jar BoardService.jar
ENTRYPOINT ["java", "-jar", "BoardService.jar"]