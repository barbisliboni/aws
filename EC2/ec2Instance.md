## Creating an instance by console

Instances > Launch instance > select a free AMI (only the Free tier eligible ones) > Select > Choose an Instance Type (t2.micro) > Review and Launch > 
Launch > Choose an existing key pair or Create a new one > Launch instances 


## Creating an instance by AWS-Cli

(on terminal) > `aws ec2` > `aws ec2 run-instances --instance-type t2.micro --image-id` (go back to AMI section and copy the id after the AMI name) `ami-01etc` 


## Creating an instance by Terraform

(on main.tf) >
    `resource = "aws_instance" "terraform-ec2-barbara" {
    ami = "ami-01etc"
    instance_type = "t2.micro"`
}

(on IDE terminal) `terraform plan` (shows information about the instance created) > `terraform apply` (applying the instance creation) > `Enter a value: yes` 
