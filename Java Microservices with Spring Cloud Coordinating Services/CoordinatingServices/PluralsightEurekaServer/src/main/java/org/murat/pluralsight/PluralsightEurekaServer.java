package org.murat.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PluralsightEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(PluralsightEurekaServer.class, args);
    }
}
