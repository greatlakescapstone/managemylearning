FROM maven:3.3-jdk-8
WORKDIR /app
#RUN wget -O MMLAdminPortal.tar.gz https://s3.amazonaws.com/adminportalcodebase/MMLAdminPortal/MMLAdminPortal.tar.gz
COPY ./appfiles .
RUN tar -xzvf ./target/MMLAdminPortal.tar.gz
ADD mmladminportal.jar ./
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "./mmladminportal.jar" ]
