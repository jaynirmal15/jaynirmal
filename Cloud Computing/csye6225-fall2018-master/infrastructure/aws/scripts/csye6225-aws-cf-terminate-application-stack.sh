echo "Please Enter a Name for the stack you want to delete"
read stack_name

echo "Deleting S3 bucket............"
bucketname=`aws cloudformation describe-stacks --stack-name ${stack_name} | jq -r '.Stacks[].Parameters[] | select(.ParameterKey == "s3domain").ParameterValue' `

if [ -n "$bucketname" ]; then
  aws s3 rm s3://${bucketname} --recursive
else
  echo "s3 bucket is not available for this stack...."
fi
#bucketname = $(aws s3api list-buckets --query "Buckets[1].Name" --output text)
# aws s3 rm s3://${bucketname} --recursive

echo "Deleting Stack: $stack_name"
aws cloudformation delete-stack --stack-name ${stack_name}

aws cloudformation wait stack-delete-complete --stack-name ${stack_name}
echo "Stack successfully deleted...!"

