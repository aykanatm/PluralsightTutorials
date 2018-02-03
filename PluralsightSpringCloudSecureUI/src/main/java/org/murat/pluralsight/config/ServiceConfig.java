package org.murat.pluralsight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;

@Configuration
public class ServiceConfig {
    @Bean
    public OAuth2RestTemplate auth2RestTemplate(BaseOAuth2ProtectedResourceDetails resource, OAuth2ClientContext context){
        return new OAuth2RestTemplate(resource, context);
    }
}
