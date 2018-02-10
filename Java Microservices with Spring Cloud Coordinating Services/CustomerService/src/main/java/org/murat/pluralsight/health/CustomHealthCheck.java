package org.murat.pluralsight.health;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator{

    private static final Log logger = LogFactory.getLog(CustomHealthCheck.class);

    private int errorcode=0;

    @Override
    public Health health() {
        System.out.println("Health check performed. Error code is " + errorcode);
        if(errorcode > 4 && errorcode < 8){
            errorcode++;
            return Health.down().withDetail("Custom Error Code", errorcode).build();
        }
        errorcode++;
        return Health.up().build();
    }
}
