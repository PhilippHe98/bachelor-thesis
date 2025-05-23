FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl  AS builder
WORKDIR /builder
COPY ./build/libs/*.jar application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /application
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./
# there is an issue regarding aot + cds when migration with flyway is used: https://github.com/spring-projects/spring-boot/issues/41348
# solution is to not use aot during the cds run. Apparently the cds archive will contain the aot generated classes anyway instead of the spring autoconfigure classes
RUN java -XX:ArchiveClassesAtExit=application.jsa -Dspring.context.exit=onRefresh -jar application.jar --spring.profiles.active=cds
ENTRYPOINT ["java","-XX:SharedArchiveFile=application.jsa","-Xshare:on","-Dspring.aot.enabled=true","-jar","application.jar"]