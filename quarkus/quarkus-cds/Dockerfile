FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application

COPY build/quarkus-app quarkus-app

RUN java -XX:ArchiveClassesAtExit=application.jsa -Dquarkus.profile=cds -jar quarkus-app/quarkus-run.jar

ENTRYPOINT ["java","-XX:SharedArchiveFile=application.jsa","-Xshare:on","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","quarkus-app/quarkus-run.jar"]
