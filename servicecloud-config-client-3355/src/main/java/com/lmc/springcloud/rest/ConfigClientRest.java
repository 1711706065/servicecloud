package com.lmc.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers = "lmchh";
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig(){
		String url = "applicationName: " + applicationName +
				"\t eurekaServers: " + eurekaServers + "\t port: " + port;
		System.out.println(url);
		return url;
	}

}
