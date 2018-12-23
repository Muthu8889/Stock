package com.stock.StockService;

import java.util.List;
import java.util.Map;

import com.stock.StockService.modal.Stock;

public interface StockRepo {
	void save(Stock stock);

	Map<String, List<Stock>> findAll();

	Stock findById(int id);

	void update(Stock stock);

	void delete(int id);
}
