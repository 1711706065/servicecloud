package com.lmc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient  //服务注册发现
@ComponentScan("com.lmc.springcloud.*")
@MapperScan("com.lmc.springcloud.dao")
public class DeptProvider8002_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8002_App.class, args);

	}

}
