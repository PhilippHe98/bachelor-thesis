FROM bellsoft/liberica-runtime-container:jdk-21-cds-musl
WORKDIR /home/app

COPY --link build/docker/optimized/layers/libs /home/app/libs
COPY --link build/docker/optimized/layers/app /home/app/

# for non aot optimized images
# there seems to be an issue with non empty folders which do not contain only jar files
#COPY --link build/docker/main/layers/resources /home/app/resources

RUN java -XX:ArchiveClassesAtExit=application.jsa -Dmicronaut.environments=cds -jar application.jar

EXPOSE 8080

ENTRYPOINT ["java","-XX:SharedArchiveFile=application.jsa","-Xshare:on","-jar","application.jar"]
