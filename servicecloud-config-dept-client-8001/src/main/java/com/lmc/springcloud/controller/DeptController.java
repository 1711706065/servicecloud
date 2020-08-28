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

@RestController
public class DeptController {
	
	  @Resource(name = "deptService")
	  private DeptService service;
	  @Autowired
	  private DiscoveryClient client;
	  
	  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
	  public boolean add(@RequestBody Dept dept){
	   return service.add(dept);
	  }
	  
	  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	  public Dept get(@PathVariable("id") Long id){
	   return service.get(id);
	  }	  

	  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
	  public List<Dept> list(){
	   return service.list();
	  }
	  
	  @RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	  public Object discovery(){
		  //获取Eureka服务中心的微服务
		  List<String> list = client.getServices();
		  System.out.println("====" + list + "====");
		  //从client中获取名为SERVICECLOUD-DEPT的微服务
		  List<ServiceInstance> srvList = client.getInstances("SERVICECLOUD-DEPT");
		  for(ServiceInstance e : srvList) {
			  System.out.println(e.getServiceId() + "\t" + e.getHost());
		  }
		  return this.client;
	  }

}
