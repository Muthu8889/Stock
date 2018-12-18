package com.stock.StockService;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.stock.StockService.modal.Stock;

@Repository
public class StockRepoImpl implements StockRepo {
	
	private RedisTemplate<String, Stock> redisTemplate;

    private HashOperations hashOperations;

	public StockRepoImpl(RedisTemplate<String, Stock> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Stock stock) {
		hashOperations.put("STOCK", stock.getId(), stock);
	}

	@Override
	public Map<String, Stock> findAll() {
		return hashOperations.entries("STOCK");
	}

	@Override
	public Stock findById(String id) {
		return (Stock)hashOperations.get("STOCK", id);
	}

	@Override
	public void update(Stock stock) {
		save(stock);		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("STOCK", id);
	}

}
