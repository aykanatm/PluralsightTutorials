package org.murat.pluralsight.controllers;

import org.murat.pluralsight.models.TollUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter{
    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping("/")
    public String loadHome(){
        return "home";
    }

    @RequestMapping("/reports")
    public String loadReports(Model model){
        OAuth2AccessToken token = clientContext.getAccessToken();
        System.out.println("Token: " + token.getValue());

        // Automatically adds the token while doing the REST call to the service
        ResponseEntity<List<TollUsage>> tolls = oAuth2RestTemplate.exchange("http://localhost:9001/services/tolldata", HttpMethod.GET, null, new ParameterizedTypeReference<List<TollUsage>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

        model.addAttribute("tolls", tolls.getBody());

        return "reports";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Every page except the home page and the login page needs to authenticate
        http.authorizeRequests().antMatchers("/","/login**").permitAll().anyRequest().authenticated();
    }
}
