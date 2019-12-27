#!/bin/bash

echo "Start diposable-service Deploy"

echo "kill legacy server"
kill $(ps -ef | grep java | grep taskservice | awk '{print $2}')


echo "Maven Build"
mvn -Dspring.profiles.active=local clean package

echo "Deploy Server"
cd target/
nohup java -jar -Dspring.profiles.active=local taskservice-0.0.1-SNAPSHOT.jar &

tail -f /home/keti/workspace/disposable_task_server/task_service/target/nohup.out
