FROM bellsoft/liberica-runtime-container:jdk-21-crac-musl AS builder

ARG JAR_FILE=build/libs/*-all.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8080

ENTRYPOINT ["java","-XX:CRaCCheckpointTo=/checkpoint","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","application.jar"]