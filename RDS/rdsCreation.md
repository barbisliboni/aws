## Creating a relational database RDS by console

AWS Console > RDS > Databases > Create database > Choose a database creation method: Standard create > 
Engine type: PostgreSQL > Templates: Free tier <br> > Settings: identifier - any db name; Master password - any password >
Create database 


## Creating a relational database RDS by Terraform

(on main.tf) Terminal > `terraform init` > back to code > <br>
`resource "aws_db_instance" "terraformpostgres"{` <br>
    `allocated_storage = 20`  <br>
    `storage_type = "gp2"` <br>
    `engine = "postgres"` <br>
    `engine_version = "11.6"` <br>
    `instance_class = "db.t2.micro"` <br>
    `name = "terraformpostgres"` <br>
    `username = "postgres"` <br>
    `password = "postgres"` <br>
`}` <br><br>
Terminal > `terraform apply` > `yes `