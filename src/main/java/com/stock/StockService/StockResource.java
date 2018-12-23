package com.stock.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockService.modal.Stock;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {
	private StockRepo stockrepo;

	public StockResource(StockRepo stockrepo) {
		this.stockrepo = stockrepo;
	}

	@GetMapping("/add/{id}/{description}/{value}/{date}")
	public Stock add(@PathVariable("id") final int id, @PathVariable("description") final String description,
			@PathVariable("value") final Long value, @PathVariable("date") final String date) {
		stockrepo.save(createStockObject(id, description, value, date));
		return stockrepo.findById(id);
	}

	@GetMapping("/update/{id}/{description}/{value}/{date}")
	public Stock update(@PathVariable("id") final int id, @PathVariable("description") final String description,
			@PathVariable("value") final Long value, @PathVariable("date") final String date) {
		stockrepo.update(createStockObject(id, description, value, date));
		return stockrepo.findById(id);
	}

	@GetMapping("/delete/{id}")
	public Map<String, List<Stock>> delete(@PathVariable("id") final int id) {
		stockrepo.delete(id);
		return all();
	}

	@GetMapping("/all")
	public Map<String, List<Stock>> all() {
		return stockrepo.findAll();
	}

	private Stock createStockObject(int id, String description, Long value, String date) {
		return new Stock(id, description, value, date);
	}
}
