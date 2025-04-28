FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application
# all-optimized.jar for aot optimazation (startup still the same time though)
ARG JAR_FILE=build/libs/*-all.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","application.jar"]

