package com.stock.StockService.modal;

public class Stock {
	
	private String id;
	private String description;
	private Long value;
	private String date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Stock(String id, String description, Long value, String date) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.date = date;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
}
