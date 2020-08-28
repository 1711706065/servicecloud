package com.lmc.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
	
	/**
	 * 默认负载均衡算法是轮询算法，通过注入方式修改调度算法
	 * @return
	 */
	@Bean
	public IRule myRule(){
		return new RandomRule();//随机算法替代默认轮询
	}

}
