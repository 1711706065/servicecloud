package com.lmc;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("/users")
public class OauthServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OauthServerApplication.class, args);
    }
    
    @RequestMapping(value = { "/current" })
    public Principal user(Principal principal) {
        return principal;
    }
    
    @RequestMapping("test")
    public String test(){
    	return "test lmc";
    }
    
}
