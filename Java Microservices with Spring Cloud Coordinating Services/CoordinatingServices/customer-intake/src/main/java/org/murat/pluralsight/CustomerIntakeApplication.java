package org.murat.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class CustomerIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerIntakeApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void log(String msg){
	    System.out.println(msg);
    }
}
