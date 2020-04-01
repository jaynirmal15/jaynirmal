echo "Please Enter a Name for the stack you want to delete"
read stack_name

echo "Deleting Stack: $stack_name"
aws cloudformation delete-stack --stack-name ${stack_name} 

aws cloudformation wait stack-delete-complete --stack-name ${stack_name}
echo "Stack successfully deleted...!"
