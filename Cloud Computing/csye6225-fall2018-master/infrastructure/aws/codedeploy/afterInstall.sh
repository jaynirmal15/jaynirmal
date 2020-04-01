#!/bin/bash

# update the permission and ownership of WAR file in the tomcat webapps directory
echo "#CSYE6225: doing after install"
cd /var
pwd
ls -lrt
echo "#CSYE6225: doing after install: remove webapp if already exist"
sudo rm -rf myapp
pwd
ls -lrt
echo "#CSYE6225: doing after install: go in webapp"
pwd
ls -lrt
pwd
ls -lrt
sudo cp .env ./webapp/WebApp
sudo chmod 777 ./webapp/WebApp/.env
pwd
ls -lrt
pwd
ls -lrt

