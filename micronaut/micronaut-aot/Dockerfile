FROM eclipse-temurin:21-jre
WORKDIR /home/app
COPY --link build/docker/optimized/layers/libs /home/app/libs
COPY --link build/docker/optimized/layers/app /home/app/
EXPOSE 8080
ENTRYPOINT ["java","-XX:+UseParallelGC","-XX:MaxRAMPercentage=75","-XX:MinRAMPercentage=75","-jar", "/home/app/application.jar"]
