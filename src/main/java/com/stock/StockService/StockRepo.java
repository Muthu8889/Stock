package com.stock.StockService;

import java.util.Map;

import com.stock.StockService.modal.Stock;


public interface StockRepo {
	void save(Stock stock);
    Map<String, Stock> findAll();
    Stock findById(String id);
    void update(Stock stock);
    void delete(String id);
}
