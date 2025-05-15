#!/bin/bash

docker network create spring-network

docker run --rm --name mysql \
  --network spring-network \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=secret \
  -e MYSQL_DATABASE=mydatabase \
  -e MYSQL_ROOT_PASSWORD=verysecret \
  -p 3306:3306 \
   mysql
