package org.murat.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Sink.class)
// @EnableBinding(Processor.class)
@SpringBootApplication
public class CustomerIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerIntakeApplication.class, args);
	}

	@StreamListener(value = Sink.INPUT, condition = "headers[\"speed\"] > 40")
	// @ServiceActivator(inputChannel = Sink.INPUT)
	// @StreamListener(Processor.INPUT)
	// @SendTo(Processor.OUTPUT)
	public void logfast(String msg){
	    System.out.println("fsst - " + msg);
	    // return msg;
    }

    @StreamListener(value = Sink.INPUT, condition = "headers[\"speed\"] <= 40")
    // @ServiceActivator(inputChannel = Sink.INPUT)
    // @StreamListener(Processor.INPUT)
    // @SendTo(Processor.OUTPUT)
    public void logslow(String msg){
        System.out.println("slow - " + msg);
        // return msg;
    }
}
