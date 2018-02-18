package org.murat.pluralsight.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class CustomerPublisher {

    @InboundChannelAdapter(channel = Source.OUTPUT)
    public String sendCustomer(){
        return "{\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"name1\",\n" +
                "    \"lastname\": \"lastname1\"\n" +
                "}";
    }
}
