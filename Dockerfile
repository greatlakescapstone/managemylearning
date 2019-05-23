FROM maven:3.3-jdk-8
WORKDIR /app
ADD mmladminportal.jar ./
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "./mmladminportal.jar" ]
