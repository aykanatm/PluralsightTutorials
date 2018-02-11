package org.murat.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
// @EnableTurbine
public class PluralsightHystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(PluralsightHystrixDashboard.class, args);
    }
}
