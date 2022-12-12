TARGET_DIR=./bin
TARGET_BACKUP_DIR=./bin/backup

BUILD_NUM=$$(cat deploy/build_num.txt)
BUILD_NUM_FILE=docker/build_num.txt
VERSION_NUM=$$(cat deploy/version.txt)

MODULE_NAME=coffee-chat-external-api
APP_DIR=./build/libs
APP_PID=coffee-chat-external-api.jar
DOCKER_REPOSITORY=kjuiop

external-api: config boot_jar move_jar

config:
	@if [ ! -d $(TARGET_DIR) ]; then mkdir $(TARGET_DIR); fi
	@if [ ! -d $(TARGET_BACKUP_DIR) ]; then mkdir $(TARGET_BACKUP_DIR); fi

build_num:
	@echo $$(($$(cat $(BUILD_NUM_FILE)) + 1 )) > $(BUILD_NUM_FILE)

boot_jar:
	../gradlew clean :$(MODULE_NAME):bootjar

move_jar:
	cp $(APP_DIR)/$(APP_PID) $(TARGET_DIR)/$(APP_PID)
	cp $(APP_DIR)/$(APP_PID) $(TARGET_BACKUP_DIR)/$(VERSION_NUM).$(BUILD_NUM)_$(APP_PID)

docker_build:
	sudo docker build --platform amd64 --tag $(DOCKER_REPOSITORY)/$(MODULE_NAME):$(VERSION_NUM).$(BUILD_NUM) .

docker_push:
	sudo docker push $(DOCKER_REPOSITORY)/$(MODULE_NAME):$(VERSION_NUM).$(BUILD_NUM)

clean:
	rm -rf $(TARGET_DIR)/*.jar


