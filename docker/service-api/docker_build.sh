#!/bin/bash

# docker build
# sudo docker build --platform amd64 --tag kjuiop/coffee-chat-service-api:1.0.1 .

# ecr docker build
# docker build -t coffee-chat .
# docker tag coffee-chat:latest 340651985871.dkr.ecr.ap-northeast-2.amazonaws.com/coffee-chat:latest

# docker build -t 340651985871.dkr.ecr.ap-northeast-2.amazonaws.com/coffee-chat-service-api:1.0.1 .

# docker compose
docker-compose -f docker-compose.yml build service-api

