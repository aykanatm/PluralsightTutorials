package org.murat.pluralsight.controllers;

import org.murat.pluralsight.messaging.CustomerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerSource customerSource;

    @RequestMapping(value = "/dashboard/customers", method = RequestMethod.POST)
    public String publishMessage(@RequestBody String payload){
        System.out.println(payload);
        Random r = new Random();
        customerSource.channelOne().send(MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(8) * 10).build());
        return "success";
    }
}
