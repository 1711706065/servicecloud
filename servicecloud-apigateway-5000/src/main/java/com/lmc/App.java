package com.lmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
	
//	@Bean
//	public RouteLocator cuRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("lmc")
//						.uri("http://www.baidu.com"))
//						.build();
//	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
