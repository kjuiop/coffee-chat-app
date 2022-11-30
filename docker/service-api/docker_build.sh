#!/bin/bash

# docker
# sudo docker build --platform amd64 --tag kjuiop/coffee-chat-service-api:1.0.1 .

docker-compose -f docker-compose.yml build
