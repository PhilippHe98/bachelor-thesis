FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application

COPY build/quarkus-app quarkus-app

ENTRYPOINT ["java","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","quarkus-app/quarkus-run.jar"]

