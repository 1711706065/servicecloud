package com.lmc.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	@Test
	public void test(){
		Jedis jedis = new Jedis("192.168.159.129", 6379);
		jedis.auth("111");
		jedis.set("name", "lmc");
		String name = jedis.get("name");
		System.out.println("name = " + name);
		jedis.close();
	}
	
	@Test
	public void test2(){
		//获得连接池配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(16);
		//设置最大空间连接数
		config.setMaxIdle(8);
		//获得连接池
		JedisPool jedisPool = new JedisPool(config, "192.168.159.129", 6379);
		Jedis jedis = null;
		try{
			//通过连接池获得连接
			jedis = jedisPool.getResource();
			jedis.auth("111");
			//设置连接
			jedis.set("mname", "sb");
			System.out.println("mname = " + jedis.get("mname"));
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			jedis.close();
		}
	}

}
