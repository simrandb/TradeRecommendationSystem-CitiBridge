package com.pojo;

import java.sql.Date;

public class NseStock {

	private String companySymbol;
	private String Sector;
	private double growth;
	private double growthpercent;
	private String marketCap;
	private Date dateModified;
	private double marketPrice;
	
	
	
	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public NseStock(Date dateModified) {
		super();
		this.dateModified = dateModified;
	}

	public NseStock() {
		super();
	}
	
	
	public NseStock(String companySymbol, double growth, double growthpercent) {
		super();
		this.companySymbol = companySymbol;
		this.growth = growth;
		this.growthpercent = growthpercent;
	}
	/*
	public NseStock(String companySymbol, double marketPrice, double growthpercent) {
		super();
		this.companySymbol = companySymbol;
		this.marketPrice = marketPrice;
		this.growthpercent = growthpercent;
	}
	*/
	public NseStock(String companySymbol, String sector, double growth, double growthpercent, String marketCap, double marketPrice) {
		super();
		this.companySymbol = companySymbol;
		this.Sector = sector;
		this.growth = growth;
		this.growthpercent = growthpercent;
		this.marketCap = marketCap;
		this.marketPrice = marketPrice;
	}

	public NseStock(String sector, double growth, double growthpercent, String marketCap) {
		super();
		this.Sector = sector;
		this.growth = growth;
		this.growthpercent = growthpercent;
		this.marketCap = marketCap;
	}
	public NseStock(String companySymbol,String sector, double growth, double growthpercent,String marketCap) {
		super();
		this.Sector = sector;
		this.companySymbol = companySymbol;
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
	
	public String getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	@Override
	public String toString() {
		return "NseStock [companySymbol=" + companySymbol + ", Sector=" + Sector + ", growth=" + growth
				+ ", growthpercent=" + growthpercent + ", marketCap=" + marketCap + ", dateModified=" + dateModified
				+ ", marketPrice=" + marketPrice + "]";
	}
	
	
	
	
	
	
	
}
