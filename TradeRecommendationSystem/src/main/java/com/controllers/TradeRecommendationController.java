package com.controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dao.TradeRecommendationSystemDAO;
import com.pojo.User;
import com.pojo.UserStock;

//import yahoofinance.Stock;
//import yahoofinance.YahooFinance;

@CrossOrigin
@RestController
public class TradeRecommendationController {

	@Autowired
	TradeRecommendationSystemDAO dao;
	
	//to get saved stocks of an user
	@RequestMapping(value = "/user-shares/{userid}", method = RequestMethod.GET)
	public List<UserStock> searchCustomerShares(@PathVariable int userid) {

		List<UserStock> stocks = dao.findCustomerStocks(userid);
		return stocks;
	}
	
	//to verify and login an user
	@RequestMapping(value = "/verifyuser")
	public boolean verifyUser(String username, String password) {

		int userid=dao.verifyUser(username, password);
		dao.updateDatabaseForToday();
		if(userid!=-1)		dao.changeUserLoggedStatus(1,userid);
				return userid==-1?false:true ;
		
	}
	
	
	//to logout user from system
	@RequestMapping(value = "/logoutuser")
	public void logoutUser(int userid) {
		dao.changeUserLoggedStatus(0,userid);
		
		
	}
	
	
	//to fetch userid
	@RequestMapping(value = "/getuserid")
	public void sendUserid(String username) {
		//dao.changeUserLoggedStatus(0,username);
		
		
	}
	
	
	//Fetching stock recommendations for all selected filters
	@RequestMapping(value = "/stocksforselectedfilters")
	public List<String> stocksforfilters(String marketCapSelected, String sector , int topHowMany) {

		List <String> stockNames=dao.stocksForSelectedFilters(marketCapSelected, sector, topHowMany);
		return stockNames;
	}
	
	@RequestMapping(value = "/insertnsestocklist")
	public void insertNseStockList() {

		dao.insertCompanySymbolsAndSector();
		
	}
	
	@RequestMapping(value = "/unsavestock")
	public void unsaveStock(int userid,String stockSymbol) {

		dao.unsaveAStock(userid, stockSymbol);
		
	}
	
	
	/*
	@RequestMapping(value = "/testingYahooGithub", method = RequestMethod.GET)
	public Stock testShares() {

		Stock stock = null;
		try {
			stock=YahooFinance.get("INTC");
			BigDecimal price = stock.getQuote().getPrice();
			BigDecimal change = stock.getQuote().getChangeInPercent();
			BigDecimal peg = stock.getStats().getPeg();
			BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

			stock.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stock;

	}*/

}
