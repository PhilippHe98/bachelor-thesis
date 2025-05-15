#!/bin/sh

docker container rm crac-container

docker build -f Dockerfile -t crac-image-checkpoint:1.0 .
docker run -d --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-container --network spring-network crac-image-checkpoint:1.0
sleep 4
docker exec crac-container jcmd application.jar JDK.checkpoint
sleep 4
docker commit --change='ENTRYPOINT ["java", "-XX:CRaCRestoreFrom=/checkpoint"]' crac-container crac-image-restore:1.0
docker rm -f crac-container
docker run --rm -p 8080:8080 --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-restore-container --network spring-network crac-image-restore:1.0