FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application
# optimized jar for aot optimazation
ARG JAR_FILE=build/libs/*-all-optimized.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","application.jar"]

