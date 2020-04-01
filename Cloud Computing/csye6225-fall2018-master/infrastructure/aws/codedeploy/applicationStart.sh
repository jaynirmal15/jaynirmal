#!/bin/bash
echo "#CSYE6225: start application pwd and move into nodeapp dir"
pwd
cd var/webapp/WebApp/
echo "PWD AND FILES"
pwd
pm2 stop index
ls -lrt
sudo kill $(lsof -t -i :3000)
pm2 start -f index.js

