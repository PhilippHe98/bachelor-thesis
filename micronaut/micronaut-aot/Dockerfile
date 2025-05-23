FROM bellsoft/liberica-runtime-container:jdk-21-musl
WORKDIR /home/app
COPY --link build/docker/optimized/layers/libs /home/app/libs
COPY --link build/docker/optimized/layers/app /home/app/
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/home/app/application.jar"]
