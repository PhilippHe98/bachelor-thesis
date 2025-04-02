#!/bin/sh

docker build -f Dockerfile-crac -t crac-image-checkpoint:1.0 .
docker run --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-container crac-image-checkpoint:1.0
docker commit --change='ENTRYPOINT ["java", "-XX:CRaCRestoreFrom=/checkpoint"]' --change='ENV SPRING_PROFILES_ACTIVE=default' crac-container crac-image-restore:1.0
docker rm -f crac-container
#docker run --rm -p 8080:8080 --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-restore-container crac-image-restore:1.0