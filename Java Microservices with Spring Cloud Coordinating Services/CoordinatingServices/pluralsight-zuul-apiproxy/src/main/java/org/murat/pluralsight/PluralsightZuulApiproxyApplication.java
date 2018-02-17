package org.murat.pluralsight;

import org.murat.pluralsight.filters.ProxyFilter;
import org.murat.pluralsight.filters.StartPreFilter;
import org.murat.pluralsight.filters.StopPostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class PluralsightZuulApiproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightZuulApiproxyApplication.class, args);
	}

	@Bean
	public ProxyFilter proxyFilter(){
	    return new ProxyFilter();
    }

    @Bean
    public StartPreFilter startPreFilter(){
	    return new StartPreFilter();
    }

    @Bean
    public StopPostFilter stopPostFilter(){
	    return new StopPostFilter();
    }
}
