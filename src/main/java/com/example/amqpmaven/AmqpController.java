package com.example.amqpmaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.amqpmaven.Publisher;

@RestController
class AmqpController {

    @Autowired
    Publisher publisher;

    @RequestMapping("/send")
    public String sendMessage(@RequestParam("msg") String msg){
        System.out.println("****************** " + msg);
        for(int i = 0; i < 10; i++){
            publisher.produceMsg(msg);
        }
        return "Your Message has been sent. Check the Terminal";
    }
}