FROM bellsoft/liberica-runtime-container:jdk-21-musl
WORKDIR /home/app
COPY --link build/docker/main/layers/libs /home/app/libs
COPY --link build/docker/main/layers/app /home/app/
COPY --link build/docker/main/layers/resources /home/app/resources
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/home/app/application.jar"]
