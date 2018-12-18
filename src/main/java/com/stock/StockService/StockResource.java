package com.stock.StockService;

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
	public Stock add(@PathVariable("id") final String id,
				     @PathVariable("description") final String description,
				     @PathVariable("value") final Long value,
				     @PathVariable("date") final String date) {
		stockrepo.save(new Stock(id, description, value, date));
		return stockrepo.findById(id);
	}
	
	@GetMapping("/update/{id}/{description}/{value}/{date}")
	public Stock update(@PathVariable("id") final String id,
				     @PathVariable("description") final String description,
				     @PathVariable("value") final Long value,
				     @PathVariable("date") final String date) {
		stockrepo.update(new Stock(id, description, value, date));
		return stockrepo.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, Stock> delete(@PathVariable("id") final String id) {
		stockrepo.delete(id);
		return all();
	}
	
	@GetMapping("/find/{id}")
	public Stock find(@PathVariable("id") final String id) {
		return stockrepo.findById(id);
	}
	
	
	@GetMapping("/all")
	public Map<String, Stock> all(){
		return stockrepo.findAll();
	}
}
