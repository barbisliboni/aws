## Accessing relational database by DBeaver

AWS Console > RDS > Databases > select the db, right click and copy the Endpoint  

DBeaver > Switch plus button > 
Select your database: PostgreSQL > Next > Host: paste the endpoint copied > Port: the same shown on the Port section on the db description > Database, User and Password: the same that was written on main.tf 

Test connection will fail cause the db is not configured to be accessed by other application, so to change that,
go to EC2 > Security Groups > Create security group > name: postgres > Add Inbound rules: Type - PostgreSQL; 
Source - anywhere <br> > Add outbound rules: Type - PostgreSQL; Source - anywhere > Create security group > RDS > Databases > 
select db > Modify > Netword & Security: Security group - postgres (the one created) > Public access: yes > Continue > Scheduling <br> of modifications: Apply immediately > Modify DB Instance

DBeaver > Test connection > Ok 


## Accessing relational database by Spring Boot

After editing the pom.xml, AWSController and application.properties, go back to DBeaver > file terraformpostgres > <br>
`create table notes(`<br>
    `noteName varchar(30),` <br>
    `noteContent varchar(100)`<br>
`);`

`select * from notes;`
