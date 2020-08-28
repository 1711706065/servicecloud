package com.lmc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lmc.springcloud.entities.Dept;

@RestController
public class DeptController_Comsumer {
	
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://SERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(@RequestBody Dept dept){
	   return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}
	  
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
	   return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}	  

	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
	   return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list/", List.class);
	}
	
	/**
	 * 服务发现
	 * @return
	 */
	@RequestMapping(value = "/consumer/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
