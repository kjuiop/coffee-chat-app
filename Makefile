TARGET_DIR=./bin
TARGET_BACKUP_DIR=./bin/backup

BUILD_NUM=$$(cat docker/build_num.txt)
BUILD_NUM_FILE=docker/build_num.txt
VERSION_NUM=$$(cat docker/version.txt)

SERVICE_MODULE_NAME=coffee-chat-service-api
SERVICE_PID_NAME=coffee-chat-service-api.jar
SERVICE_API_DIR=./coffee-chat-service-api/build/libs/
SERVICE_API_PID=coffee-chat-service-api.jar

service-api: config boot_jar move_jar

config:
	@if [ ! -d $(TARGET_DIR) ]; then mkdir $(TARGET_DIR); fi
	@if [ ! -d $(TARGET_BACKUP_DIR) ]; then mkdir $(TARGET_BACKUP_DIR); fi

build_num:
	@echo $$(($$(cat $(BUILD_NUM_FILE)) + 1 )) > $(BUILD_NUM_FILE)


boot_jar:
	./gradlew clean :$(SERVICE_MODULE_NAME):bootjar

move_jar:
	cp $(SERVICE_API_DIR)/$(SERVICE_API_PID) $(TARGET_DIR)/$(SERVICE_API_PID)
	cp $(SERVICE_API_DIR)/$(SERVICE_API_PID) $(TARGET_BACKUP_DIR)/$(VERSION_NUM).$(BUILD_NUM)_$(SERVICE_API_PID)

give_chmod:
	sudo chmod +x ./docker/service-api/docker_build.sh
	sudo chmod +x ./docker/service-api/docker_push.sh
	sudo chmod +x ./docker/service-api/docker_run.sh
	sudo chmod +x ./docker/ecr/ecr_access.sh

ecr_access:
	bash -c ./docker/ecr/ecr_access.sh

docker_build:
	docker-compose -f docker-compose.yml build service-api

docker_push:
	docker-compose -f docker-compose.yml push service-api

docker_run:
	bash -c ./docker/service-api/docker_run.sh

clean:
	rm -rf $(TARGET_DIR)/*.jar


