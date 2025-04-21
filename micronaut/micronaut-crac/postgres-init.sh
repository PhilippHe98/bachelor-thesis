#!/bin/bash
docker network create micronaut-network
docker run --name postgres \
  --network micronaut-network \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=postgres \
  -p 5432:5432 \
  -d postgres
