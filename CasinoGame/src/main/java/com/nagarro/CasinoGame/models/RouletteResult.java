package com.nagarro.CasinoGame.models;

public class RouletteResult {
	
	private Long id;
	private Double profit;
	private Integer rouletteNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public Integer getRouletteNumber() {
		return rouletteNumber;
	}
	public void setRouletteNumber(Integer rouletteNumber) {
		this.rouletteNumber = rouletteNumber;
	}
	public RouletteResult(Long id, Double profit, Integer rouletteNumber) {
		super();
		this.id = id;
		this.profit = profit;
		this.rouletteNumber = rouletteNumber;
	}
	public RouletteResult() {
		super();
	}
	
	

}
