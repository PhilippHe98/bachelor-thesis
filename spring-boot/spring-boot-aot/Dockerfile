# recommended dockerfile used form: https://docs.spring.io/spring-boot/reference/packaging/container-images/dockerfiles.htm
## list of graalvm container images: https://github.com/graalvm/container
## optizations: https://learn.microsoft.com/en-us/azure/developer/java/containers/overview, https://developers.redhat.com/articles/2022/04/19/best-practices-java-single-core-containers#

# Optimization stage
FROM bellsoft/liberica-runtime-container:jdk-21-musl  AS builder
WORKDIR /builder
COPY ./build/libs/*.jar application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

# Final image
FROM bellsoft/liberica-runtime-container:jdk-21-musl
WORKDIR /application
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./
ENTRYPOINT ["java","-Dspring.aot.enabled=true","-jar","application.jar"]