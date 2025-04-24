### some inspiration; https://github.com/jonashackt/spring-boot-graalvm/blob/master/Dockerfile
#FROM ghcr.io/graalvm/graalvm-community:21 AS builder
#WORKDIR /builder
#COPY . .
#RUN ./gradlew nativeCompile
### bellsoft apaquita-linux because the other projects base image are based on that, and so it is more compareble
#FROM bellsoft/alpaquita-linux-base:glibc
#WORKDIR /application
#COPY --from=builder /builder/build/native/nativeCompile/mn-graalvm-application mn-graalvm-application
#CMD ["./mn-graalvm-application"]

FROM bellsoft/alpaquita-linux-base:glibc
WORKDIR /application
COPY build/native/nativeCompile/mn-graalvm-application mn-graalvm-application
CMD ["./mn-graalvm-application"]

