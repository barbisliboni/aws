package br.com.barbara.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.jdbc.core.JdbcTemplate

@RestController
@RequestMapping("/aws/s3")
public class AWSController {

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private AmazonSQSAsync sqs;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/note")
    public void note (@RequestParam String name, @RequestParam String content){
        //amazonS3.putObject("barbaraLiboni", name + ".txt", content); //amazonS3. - shows methods

        //the message will be posted here (note method) and will be consumed on consume method
        new QueueMessagingTemplate(sqs).convertAndSend("Notes_Queue", content); //queue name and the content

        //connecting database with spring boot
        jdbcTemplate.update("insert into notes (noteName, noteContent) values (?, ?)", name, content);
    }

    //the parameter will be the queue name set previously on aws 
    @SqsListener("Notes_Queue") 
    public void consume(String message){
        System.out.println("This is a test message!" + message)
    }



    //testing on postman: http://localhost:8080/aws/s3/note?name=Note&content=Call mom
    //then check on aws s3

}
