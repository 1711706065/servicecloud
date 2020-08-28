package com.lmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmc.interceptor.FeignClientInterceptor;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableResourceServer
@RestController
public class Oauth2ClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }
    
    @RequestMapping("/hello")
    public String hello() {
    	return "hello ... ";
    }
    

}
