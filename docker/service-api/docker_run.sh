#!/bin/bash

sudo docker run -d -p 8080:8080 --name coffee-chat-service-api --net host kjuiop/coffee-chat-service-api:1.0.1
