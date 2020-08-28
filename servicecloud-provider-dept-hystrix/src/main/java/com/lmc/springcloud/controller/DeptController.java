package com.lmc.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lmc.springcloud.entities.Dept;
import com.lmc.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	
	  @Resource(name = "deptService")
	  private DeptService service;
	  
	  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	  @HystrixCommand(fallbackMethod = "processHystrix_Get")
	  public Dept get(@PathVariable("id") Long id){
		  Dept dept = service.get(id);
		  if(dept == null){
			  throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		  }
		  return dept;
	  }	  

	  Dept processHystrix_Get(@PathVariable("id") Long id){
		  return new Dept().setDeptno(id)
		           .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
		           .setDb_source("no this database in MySQL");

		  }

}
