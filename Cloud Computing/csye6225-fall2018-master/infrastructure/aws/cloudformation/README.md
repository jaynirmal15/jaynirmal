# CSYE6225-Fall2018

Team Members:
1. Supriya Bhide - bhide.su@husky.neu.edu
2. Jay Nirmal - nirmal.j@husky.neu.edu
3. Ronak Shingala - shingala.r@husky.neu.edu
4. Prashant Sawale - sawale.p@husky.neu.edu

# Pre-requisites:
This involves parsing of json file in shell script for which 'jq' module is used. To install jq, run command:

sudo dnf install jq

# Steps To Execute

Execute ./csye6225-aws-cf-create-stack.sh from scripts and enter a stack name you want to create. This will create a stack with user given name with all the resource configurations mentioned in csye6225-cf-networking.json file

Execute ./csye6225-aws-cf-terminate-stack.sh from scripts. This command will terminate your respective stack and corrosponding resources
