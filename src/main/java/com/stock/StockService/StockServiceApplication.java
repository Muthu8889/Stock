package com.stock.StockService;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.stock.StockService.modal.Stock;



@SpringBootApplication
public class StockServiceApplication {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, List<Stock>> redisTemplate() {
		RedisTemplate<String, List<Stock>> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

}

