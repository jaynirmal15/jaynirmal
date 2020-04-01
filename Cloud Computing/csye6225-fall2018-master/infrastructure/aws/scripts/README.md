# Pre-requisites

This involves parsing of json file in shell script for which 'jq' module is used. To install jq, run command:

sudo dnf install jq


# Steps To Execute
1.
Execute ./csye6225-aws-cf-create-application-stack.sh from scripts and enter a stack name you want to create.

This will ask to enter the name of stack you created previously to configure VPC and subnet network.

This will create a stack with user given name with all the resource configurations mentioned in csye6225-cf-application.json file

2.
Execute ./csye6225-aws-cf-terminate-application-stack.sh from scripts. This command will terminate your respective stack and corrosponding resources
