package com.stock.StockService.modal;

import java.io.Serializable;

public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8686728338668498294L;
	private int id;
	private String description;
	private Long value;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Stock(int id, String description, Long value, String date) {
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
