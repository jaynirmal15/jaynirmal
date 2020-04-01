###################################################################################
#starting of script
#Get a STACK name to create new one.
###################################################################################

echo "Please Enter a Name for the stack: "
read stack_name

###################################################################################
#starting of script
#Get a STACK name to create new one.
###################################################################################
#VPC Name
jq '.Resources.myVPC.Properties.Tags[0].Value = "'$stack_name'-csye6225-vpc"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Add subnets to the the VPC, reference the subnet value for each subnet in .json file
###################################################################################
###################################################################################
#Create Public Subnet 1
###################################################################################
#Subnets
jq '.Resources.publicsubnet1.Properties.Tags[0].Value = "'$stack_name'-public-subnet-1"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Create Private Subnet 1
###################################################################################
jq '.Resources.privatesubnet1.Properties.Tags[0].Value = "'$stack_name'-private-subnet-1"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Create Public Subnet 2
###################################################################################
jq '.Resources.publicsubnet2.Properties.Tags[0].Value = "'$stack_name'-public-subnet-2"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Create Private Subnet 2
###################################################################################
jq '.Resources.privatesubnet2.Properties.Tags[0].Value = "'$stack_name'-private-subnet-2"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Create Public Subnet 3
###################################################################################
jq '.Resources.publicsubnet3.Properties.Tags[0].Value = "'$stack_name'-public-subnet-3"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#Create Private Subnet 3
###################################################################################
jq '.Resources.privatesubnet3.Properties.Tags[0].Value = "'$stack_name'-private-subnet-3"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json


###################################################################################
#Create an internetGateway dynamically to attach subnets with route tables....
###################################################################################
jq '.Resources.myInternetGateway.Properties.Tags[0].Value = "'$stack_name'-csye6225-InternetGateway"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json

###################################################################################
#add route table to assign subnetIds routes to public subnets...
###################################################################################
jq '.Resources.publicRouteTable.Properties.Tags[0].Value = "'$stack_name'-csye6225-public-route-table"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json


###################################################################################
#add route table to assign subnetIds routes to private subnets...
###################################################################################
jq '.Resources.privateRouteTable.Properties.Tags[0].Value = "'$stack_name'-csye6225-private-route-table"' ../cloudformation/csye6225-cf-networking.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-networking.json


###################################################################################
#Execute command to create stack with VPC and all other required information....
###################################################################################
echo "Executing Create Stack....."

aws cloudformation create-stack --stack-name ${stack_name} --template-body file://../cloudformation/csye6225-cf-networking.json --capabilities=CAPABILITY_NAMED_IAM

if [ $? -eq 0 ]; then
	echo "Waiting to create gets executed completely...!"
else
	echo "Error in Create Stack...Exiting..."
	exit 1
fi


###################################################################################
#Wait until cloudFormation is done.....
###################################################################################
aws cloudformation wait stack-create-complete --stack-name ${stack_name}

if [ $? -eq 0 ]; then
	echo "Create successfully executed...!"
else
	echo "Error in Create Stack...Exiting..."
	exit 1
fi


###################################################################################
#Stack created successfully.. End of the Script.....
###################################################################################
echo "Stack Create Execution Complete...!!!"
