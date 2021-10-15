## Deploy from the previous Spring Boot Application 

AWS console > EC2 > Launch instance > Choose an AMI > Choose and Instance Type > 4 Next >
Configure Security Group: Type - Custom TCP Rule; Port Range - 8080; Custom - Anywhere > Review and Launch >
Launch > Select and existing key pair or create a new one > Launch instances 

Go back to Instances > Right click on the instance > Connect > Copy the command line > AWS-Cli > paste > yes >
check if java is installed and make sure it is on the same version as the application > `sudo yum remove java-1.7.0-openjdk` > 
yes > `sudo yum install java-1.8.0` > yes > `exit`; 

Go back to the application > Maven > Execute Maven Goal > package (generating a executable jar) > Execute 

(Clonning the jar to EC2) Go back to the terminal > `scp -i barbaraliboni.pem aws-0.0.1-SNAPSHOT.jar ec2-user@ec2-00-00-000-000.compute-1.amazonaws.com:~`  
(choose your key pair, the file you're sending which is the .jar, the destination that is shown on the example on AWS Instances Connect and to which file we want to send) > 
once the step above is completed, copy the command line on the example part that is shown on the AWS Instances Connect (ssh -i "barbaraliboni.pem" ec2-user@ec2-00-00-000-000.compute-1.amazonaws.com) > 

Go back to Instances > right click on the instance > copy the Public DNS shown > go back to Postman > replace localhost to the DNS copied

(Runnig a jar file from Spring Boot) Go back to the terminal > `java -jar aws-0.0.1-SNAPSHOT.jar`