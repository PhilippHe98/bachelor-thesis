#!/bin/sh

docker build -f Dockerfile -t quarkus-crac-checkpoint:1.0 .
docker run --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-container --network quarkus-network quarkus-crac-checkpoint:1.0
sleep 4
docker exec crac-container jcmd quarkus-run.jar JDK.checkpoint
sleep 4
docker commit --change='ENTRYPOINT ["java", "-XX:CRaCRestoreFrom=/checkpoint"]' crac-container quarkus-crac-restore:1.0
docker rm -f crac-container
docker run --rm -p 8080:8080 --cap-add CHECKPOINT_RESTORE --cap-add SYS_PTRACE --name crac-restore-container --network quarkus-network quarkus-crac-restore:1.0