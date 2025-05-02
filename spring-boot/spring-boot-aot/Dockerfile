# recommended dockerfile used form: https://docs.spring.io/spring-boot/reference/packaging/container-images/dockerfiles.htm
## list of graalvm container images: https://github.com/graalvm/container
## optizations: https://learn.microsoft.com/en-us/azure/developer/java/containers/overview, https://developers.redhat.com/articles/2022/04/19/best-practices-java-single-core-containers#
#
## Build stage
#FROM bellsoft/liberica-runtime-container:jdk-21-musl AS build
#WORKDIR /builder
#COPY . .
#RUN ./gradlew clean build

# Optimization stage
FROM bellsoft/liberica-runtime-container:jdk-21-musl  AS optimizer
WORKDIR /optimizer
#COPY --from=build /builder/build/libs/*.jar application.jar
COPY ./build/libs/*.jar application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

# Final image
FROM bellsoft/liberica-runtime-container:jdk-21-musl
WORKDIR /application
COPY --from=optimizer /optimizer/extracted/dependencies/ ./
COPY --from=optimizer /optimizer/extracted/spring-boot-loader/ ./
COPY --from=optimizer /optimizer/extracted/snapshot-dependencies/ ./
COPY --from=optimizer /optimizer/extracted/application/ ./
ENTRYPOINT ["java","-Dspring.aot.enabled=true","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar","application.jar"]