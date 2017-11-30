package com.nagarro.CasinoGame.models;

public class UpdateProfit {

	private Long id;
	public UpdateProfit() {
		super();
	}
	public UpdateProfit(Long id, Double profit) {
		super();
		this.id = id;
		this.profit = profit;
	}
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
	private Double profit;
	
	

}
