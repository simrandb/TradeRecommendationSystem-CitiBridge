package com.pojo;

public class NseStock {

	private String companySymbol;
	private String Sector;
	private double growth;
	private double growthpercent;
	private double marketCap;
	
	
	
	
	
	
	
	public NseStock() {
		super();
	}
	public NseStock(String sector, double growth, double growthpercent, double marketCap) {
		super();
		Sector = sector;
		this.growth = growth;
		this.growthpercent = growthpercent;
		this.marketCap = marketCap;
	}
	public String getCompanySymbol() {
		return companySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}
	public String getSector() {
		return Sector;
	}
	public void setSector(String sector) {
		Sector = sector;
	}
	public double getGrowth() {
		return growth;
	}
	public void setGrowth(double growth) {
		this.growth = growth;
	}
	public double getGrowthpercent() {
		return growthpercent;
	}
	public void setGrowthpercent(double growthpercent) {
		this.growthpercent = growthpercent;
	}
	public double getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}
	@Override
	public String toString() {
		return "NseStock [companySymbol=" + companySymbol + ", Sector=" + Sector + ", growth=" + growth
				+ ", growthpercent=" + growthpercent + ", marketCap=" + marketCap + "]";
	}
	
	
	
	
	
	
}
