###################################################################################
#starting of script
#Get a STACK name to create new one.
###################################################################################
echo "Please Enter a new name for the stack: "
read stack_name

###################################################################################
#starting of script
#Get a STACK name to create new one.
###################################################################################
echo "Retrieving VPC:"
echo "Please enter the Stack name where VPC belongs to: "
read nw_stack_name

###################################################################################
# Get a dynamoDB Table Name.....
###################################################################################
echo "Enter the DynamoDB table name"
read dynamoDB_table


dbidentifier="csye6225-fall2018-1"
dBsubnetGroup_name="dbSubnetGrp-1"

domain=$(aws route53 list-hosted-zones --query HostedZones[0].Name --output text)
trimdomain=${domain::-1}
senderEmail="noreply@$trimdomain"
bucket_name="$trimdomain.tld.csye6225.com"
echo "S3 Domain: $bucket_name"
###################################################################################
#retrieve VPC_Id from the existing created STACK
###################################################################################

vpc_id=$(aws ec2 describe-vpcs --query "Vpcs[?Tags[?Key=='aws:cloudformation:stack-name']|[?Value=='$nw_stack_name']].VpcId" --output text)
echo "VPC ID: " $vpc_id

subnet_id_pub=$(aws ec2 describe-subnets --query "Subnets[?Tags[?contains(Value, 'public')]] | [0].SubnetId " --output text)
#retrieve subnet_ids from the existing created vpc using vpc_id and stack name
###################################################################################

echo "Subnet ID: " $subnet_id


###################################################################################
# Get Private Route-Table Id for the application stack......
###################################################################################

pvt=$( aws ec2 describe-route-tables --query "RouteTables[?Tags[?Key=='Name']|[?Value=='$nw_stack_name-csye6225-private-route-table']].Associations[].SubnetId")
#pvt=$( aws ec2 describe-route-tables --query "RouteTables[?Tags[?Key=='Name']|[?Value=='net1-csye6225-private-route-table']].Associations[].SubnetId")
echo $pvt

count=0
for i in $pvt
do
    if [ "$i" = "[" ] || [ "$i" = "]" ]; then
    echo "...."
  else
    #subnets+=$i
    #subnet=`echo $i  | sed "s/\"//g" | sed 's/,/ /g'`
    subnet=`echo $i  | sed 's/,/ /g'`
    echo $subnet
    jq '.Resources.DBsubnetGroup.Properties.SubnetIds['$count'] =  '"$subnet"'' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json
    ((count++))
    echo $count
  fi;
done

#echo $subnets


subnet_id=$(aws ec2 describe-subnets --query "Subnets[?Tags[?contains(Value, 'private')]] | [0].SubnetId " --output text)
#echo "Subnet ID: " $subnet_id

###################################################################################
# VPC_ID reference given to the csye6225-cf-application.json for dynamic creation
###################################################################################

jq '.Resources.csye6225Webapp.Properties.VpcId = "'$vpc_id'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

###################################################################################
# VPC_ID reference given to the csye6225-cf-application.json for dynamic creation
###################################################################################

jq '.Resources.csye6225RDS.Properties.VpcId = "'$vpc_id'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

###################################################################################
# VPC_ID reference given to the csye6225-cf-application.json for dynamic creation
###################################################################################

jq '.Resources.Ec2Instance.Properties.Tags[0].Value = "'$stack_name'-ec2"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

jq '.Resources.Ec2Instance.Properties.SubnetId = "'$subnet_id_pub'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json
# stack name reference given to the csye6225-cf-application.json for dynamic creation
###################################################################################

###################################################################################
# reference of VPC_Id to EC2 instantace.......
###################################################################################

jq '.Resources.csye6225RDSSG.Properties.EC2VpcId = "'$vpc_id'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

###################################################################################
# Reference to dynamoDB table name to dynamoDB instance.....
###################################################################################

jq '.Resources.Dynamodb.Properties.TableName = "'$dynamoDB_table'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json


###################################################################################
# Reference of bucket name to s3_bucket instance.....
###################################################################################

jq '.Resources.S3Bucket.Properties.BucketName = "'$bucket_name'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json


###################################################################################
# Reference of dbSubnetGroup Name to DBSubnetGroup Instance....
###################################################################################

jq '.Resources.DBsubnetGroup.Properties.DBSubnetGroupName = "'$dBsubnetGroup_name'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json


###################################################################################
# Reference of dbIndentifier to DBInstanceIdentifier.....
###################################################################################

jq '.Resources.RDS.Properties.DBInstanceIdentifier = "'$dbidentifier'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

jq '.Parameters.s3domain.Default = "'$bucket_name'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

jq '.Parameters.dynamoDB.Default = "'$dynamoDB_table'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json

jq '.Parameters.senderEmail.Default = "'$senderEmail'"' ../cloudformation/csye6225-cf-application.json > tmp.$$.json && mv tmp.$$.json ../cloudformation/csye6225-cf-application.json
###################################################################################
# Create a stack with cloudformation  using all required parameters in .json and execute it
###################################################################################

echo "Executing Create Stack....."

aws cloudformation create-stack --stack-name ${stack_name} --template-body file://../cloudformation/csye6225-cf-application.json --capabilities=CAPABILITY_NAMED_IAM

if [ $? -eq 0 ]; then
	echo "Waiting to create gets executed completely...!"
else
	echo "Error in Create Stack...Exiting..."
	exit 1
fi

###################################################################################
# wait unitl cloudformation is completed successfully...
###################################################################################

aws cloudformation wait stack-create-complete --stack-name ${stack_name}

if [ $? -eq 0 ]; then
	echo "Create successfully executed...!"
else
	echo "Error in Create Stack...Exiting..."
	exit 1
fi

###################################################################################
# END of the cloud formation creation...
###################################################################################

echo "Stack Create Execution Complete...!!!"


val='
{
	"logs": {
		"logs_collected": {
			"files": {
				"collect_list": [
					{
						"file_path": "/var/log/messages",
						"log_group_name": "Log2"
					}
				]
			}
		}
	},
	"metrics": {
		"metrics_collected": {
			"collectd": {
				"metrics_aggregation_interval": 60
			},
			"statsd": {
				"metrics_aggregation_interval": 60,
				"metrics_collection_interval": 10,
				"service_address": ":8125"
			}
		}
	}
}
'

echo $val
parameter_name="WebApp"
aws ssm put-parameter --name "$parameter_name" --type "String" --value "$val"

