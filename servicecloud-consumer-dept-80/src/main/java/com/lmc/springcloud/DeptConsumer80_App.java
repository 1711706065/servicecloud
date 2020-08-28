package com.lmc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.lmc.myrules.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DeptConsumer80_App.class, args);

	}

}
