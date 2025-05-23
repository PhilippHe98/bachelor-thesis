FROM bellsoft/liberica-runtime-container:jdk-21-crac-musl AS builder
WORKDIR /builder

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar

RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

FROM bellsoft/liberica-runtime-container:jdk-21-crac-musl
WORKDIR /application
EXPOSE 8080

COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./

ENTRYPOINT ["java","-XX:CRaCCheckpointTo=/checkpoint","-Dspring.aot.enabled=true","-jar","application.jar"]