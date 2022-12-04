#!/bin/bash

# docker push
# sudo docker push kjuiop/coffee-chat-service-api:1.0.1

# ecr docker push
# docker push 340651985871.dkr.ecr.ap-northeast-2.amazonaws.com/coffee-chat:latest

docker-compose -f docker-compose.yml push service-api
