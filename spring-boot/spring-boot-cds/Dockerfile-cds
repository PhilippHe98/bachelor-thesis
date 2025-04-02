FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl AS builder
WORKDIR /builder

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application

COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./
# Start the application jar - this is not the uber jar used by the builder
# This jar only contains application code and references to the extracted jar files
# This layout is efficient to start up and CDS friendly
# Execute the CDS training run
RUN java -XX:ArchiveClassesAtExit=application.jsa -Dspring.context.exit=onRefresh -jar application.jar --spring.profiles.active=cds
# Below are additional jvm flags to ensure an optimized jvm environment for containers and kubernetes
ENTRYPOINT ["java","-XX:SharedArchiveFile=application.jsa","-Xshare:on","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","application.jar"]
# -Xshare:on which prints an error message and exits if CDS can’t be enabled.
#,"-Xmx4g","-XX:ActiveProcessorCount=2" could be used later
