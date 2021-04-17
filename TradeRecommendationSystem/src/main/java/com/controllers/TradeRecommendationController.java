package com.controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
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
	
	@RequestMapping(value = "/user-shares/{userid}", method = RequestMethod.GET)
	public List<UserStock> searchCustomerShares(@PathVariable int userid) {

		List<UserStock> stocks = dao.findCustomerStocks(userid);
		return stocks;
	}
	
	
	@RequestMapping(value = "/verifyuser")
	public boolean verifyUser(String username, String password) {

		boolean userPresent=dao.verifyUser(username, password);
				return userPresent;
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
