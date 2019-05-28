#!/bin/bash
curl -X POST http://localhost:8080/actuator/shutdown
java -version
java -jar /opt/capstone/mmladminportal.jar >/dev/null 2>&1 &
echo "finish"

