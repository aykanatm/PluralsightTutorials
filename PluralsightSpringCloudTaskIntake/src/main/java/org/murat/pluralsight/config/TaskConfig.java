package org.murat.pluralsight.config;

import org.murat.pluralsight.controllers.TaskProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
    public TaskProcessor taskProcessor(){
        return new TaskProcessor();
    }
}
