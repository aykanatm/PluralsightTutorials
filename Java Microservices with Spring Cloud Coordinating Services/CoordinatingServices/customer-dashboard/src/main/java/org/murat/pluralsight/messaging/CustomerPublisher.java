package org.murat.pluralsight.messaging;

import org.murat.pluralsight.models.Customer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Random;

@EnableBinding(CustomerSource.class)
public class CustomerPublisher {
    Random r = new Random();
    @Bean
    @InboundChannelAdapter(channel = "channelOne", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Customer> sendCustomer(){
//        return "{\n" +
//                "    \"id\": \"1\",\n" +
//                "    \"name\": \"name1\",\n" +
//                "    \"lastname\": \"lastname1\"\n" +
//                "}";
        return () -> MessageBuilder.withPayload(new Customer("1","name1","lastname1")).setHeader("speed", r.nextInt(8) * 10).build();
    }
}
