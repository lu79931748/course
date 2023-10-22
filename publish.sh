#!/bin/bash

JAR_GATEWAY="gateway.jar"
JAR_FILE="file.jar"
JAR_SYSTEM="system.jar"
JAR_BUSINESS="business.jar"

jar_array=(${JAR_GATEWAY} ${JAR_FILE} ${JAR_SYSTEM} ${JAR_BUSINESS})

for i in 0 1 2 3
    do
        pid=`ps -ef|grep ${jar_array[i]}|grep -v grep|awk '{print $2}' `
        if [ -z "${pid}" ]; then
            echo "进程不存在"
        else
            echo "部署前${jar_array[i]}项目${pid}"
            kill -9 ${pid}
            nohup java -jar "${jar_array[i]}" >/root/logs/"${jar_array[i]%%.*}"-nohup.log 2>&1 &
            after_pid=`ps -ef|grep ${jar_array[i]}|grep -v grep|awk '{print $2}' `
            echo "部署后${jar_array[i]}项目${after_pid}"
        fi
done
