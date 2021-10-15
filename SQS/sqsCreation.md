## Simple Queue Service

Amazon Simple Queue Service (SQS) is a trustful, scalable and totally manageable messages queue service. 

An example is that we have 2 microservices, and they both need to interact with each other, so instead of using a HTTP REQUEST (which could be bad if the first
microservice is down), <br> we can use a queue (SQS), so then the first microservice sends a request to the queue, and the queue will be consumed by the second microservice.
The first microservice produces and <br> the second one consumes. The requests can be storaged on SQS and won't be lost.

## Creating a SQS Queue by console

AWS Console > SQS > Start using now > Queue name: Notes_Queue > Queue type: Standard  Queue > Configure Queue > Create

## Creating a SQS Queue by Terraform

(on main.tf) <br>`resource "aws_sqs_queue" "terraformQueue"{`<br>
    &nbsp;&nbsp;&nbsp;&nbsp;`name = "terraformQueue"`<br>
`}`

(on the IDE console) `terraform apply` > yes 
