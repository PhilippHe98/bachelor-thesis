#!/bin/bash

docker network create spring-network

docker run --rm --name postgres \
  --network spring-network \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=postgres \
  -p 5432:5432 \
  -d postgres
