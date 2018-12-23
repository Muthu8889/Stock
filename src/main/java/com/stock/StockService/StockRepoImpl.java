package com.stock.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.stock.StockService.modal.Stock;

@Repository
public class StockRepoImpl implements StockRepo {

	private RedisTemplate<String, List<Stock>> redisTemplate;

	private HashOperations<String, String, List<Stock>> hashOperations;

	public StockRepoImpl(RedisTemplate<String, List<Stock>> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations = this.redisTemplate.opsForHash();
	}

	@Override
	public void save(Stock stock) {
		hashOperations.put("STOCKSSS", "stocks", getList(stock));
	}

	@Override
	public Map<String, List<Stock>> findAll() {
		return hashOperations.entries("STOCKSSS");
	}

	@Override
	public Stock findById(int id) {
		return (Stock) hashOperations.get("STOCKSSS", id);
	}

	@Override
	public void update(Stock stock) {
		save(stock);
	}

	@Override
	public void delete(int id) {
		List<Stock> stocks = deleteFromList(id);
		saveAll(stocks);
	}

	private void saveAll(List<Stock> stocks) {
		hashOperations.put("STOCKSSS", "stocks", stocks);
	}

	private List<Stock> getList(Stock newStock) {
		List<Stock> stocks = new ArrayList<>();
		List<Stock> oldStockList = findAll().get("stocks");
		if (oldStockList != null) {
			oldStockList.forEach(stock -> {
				stocks.add(stock);
			});
		}
		stocks.add(newStock);
		return stocks;
	}

	private List<Stock> deleteFromList(int id) {
		List<Stock> stocks = new ArrayList<>();
		List<Stock> oldStockList = findAll().get("stocks");
		if (oldStockList != null) {
			oldStockList.forEach(stock -> {
				if (id != stock.getId()) {
					stocks.add(stock);
				}
			});
		}
		return stocks;
	}
}
