FROM bellsoft/liberica-runtime-container:jdk-21-crac-musl
WORKDIR /application

COPY build/quarkus-app quarkus-app
WORKDIR quarkus-app

ENTRYPOINT ["java","-XX:CRaCCheckpointTo=/checkpoint","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","quarkus-run.jar"]
