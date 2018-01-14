package org.murat.pluralsight;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public TollProcessingTask tollProcessingTask(){
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner{

        @Override
        public void run(String... strings) throws Exception {
            // parameters stationid, license plate, timestamp
            if(null != strings){
                System.out.println("parameter length is " + strings.length);

                String stationId = strings[0];
                String licensePlate = strings[1];
                String timestamp = strings[2];

                System.out.println("Station ID: " + stationId);
                System.out.println("License Plate: " + licensePlate);
                System.out.println("Time Stamp: " + timestamp);
            }
        }
    }
}
