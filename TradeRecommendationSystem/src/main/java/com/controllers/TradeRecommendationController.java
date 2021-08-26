package com.controllers;
//import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.pojo.NseStock;
import com.pojo.User;
import com.pojo.UserStock;

//import yahoofinance.Stock;
//import yahoofinance.YahooFinance;

@CrossOrigin
@RestController
public class TradeRecommendationController {

	@Autowired
	TradeRecommendationSystemDAO dao;
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/savestock")
		public boolean saveStock(int customerid, String stocksymbol) {
			System.out.println("in save stock");
			System.out.println("customerid= "+customerid);
			System.out.println("stksym= "+stocksymbol);
			int res = dao.saveAStock(customerid, stocksymbol);
			return true;
		}
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/stocksavedornot")
		public boolean stockIsSavedOrNot(int customerid, String stocksymbol) {
			int res = dao.stockSavedOrNot(customerid, stocksymbol);
			System.out.println("in saved stocks or not res=" +res);

			if(res==1)
				return true;
			else
				return false;
				
		}
	
	

	//Ready-to-use
		//------------------------------------------------------------------------------------------------
		//alter saved stock quantity (+ or -)
		@RequestMapping(value = "/altersavedstockquantity", method = RequestMethod.GET )
		public int alterStockquantity(int userid,String companySymbol, String plusminus) {
			return dao.alterSavedStockQuantity(userid,companySymbol, plusminus);
			
		}
	
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//to get saved stocks of an user
	@RequestMapping(value = "/user-shares/{userid}", method = RequestMethod.GET)
	public List<UserStock> searchCustomerShares(@PathVariable int userid) {
		List<UserStock> stocks = dao.findCustomerStocks(userid);
		return stocks;
	}
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//to verify and login an user
	@RequestMapping(value = "/verifyuser")
	public boolean verifyUser(String username, String password) {
		
		boolean userVerified=dao.verifyUser(username, password);
		//dao.batch_updateDatabaseForToday();
		return userVerified;
		
		
		
	}
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//to check username exists in database
		@RequestMapping(value = "/checkuserexists/{username}", method= RequestMethod.GET)
		public boolean verifyUser(@PathVariable String username) {
			
			boolean userexist=dao.checkUsernameExistInDatabase(username);
			
			return userexist;
			
		}
	

		
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------		
	//to change status of user for login/logout
	@RequestMapping(value = "/loguser")
	public void logUser(String username, int logStatus) {
		dao.changeUserLoggedStatus(logStatus,username);
		
		
	}
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//to fetch userid
	@RequestMapping(value = "/getuserid")
	public int sendUserid(String username) {
			int uid=dao.getUid(username);		
			return uid;
	
	}
	
	@RequestMapping(value = "/searchStock")
	public List<NseStock> searchStock(String stkSym) {

		List <NseStock> stocks= dao.searchStk(stkSym);
		return stocks;
	}
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//Fetching stock recommendations for all selected filters
	@RequestMapping(value = "/stocksforselectedfilters")
	public List<NseStock> stocksforfilters(String marketCapSelected, String sector , int topHowMany,String growthNumberOrGrowthpercent ) {

		List <NseStock> stocks=dao.stocksForSelectedFilters(marketCapSelected, sector, topHowMany, growthNumberOrGrowthpercent);
		return stocks;
	}
	
	//Doing 
	//Producing graphs as an image for a particular stock
	@RequestMapping(value = "/get-image-with-media-type",produces = MediaType.IMAGE_JPEG_VALUE)
			public byte[] getImageWithMediaType() throws IOException { 
		
			
			    InputStream in = getClass()
			      .getResourceAsStream("/com/controllers/TradeRecommendationController/LineChart.jpg");
			    return IOUtils.toByteArray(in);
			}
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//!! Only to be used first one time! to insert all companySymbols and 
	@RequestMapping(value = "/insertnsestocklist")
	public void insertNseStockList() {

		//dao.insertCompanySymbolsAndSector();
		dao.batchinsertCompany_SymbolandSector();
		
	}
	
	
	
	
	
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//to delete saved stock entry for a customer
	@RequestMapping(value = "/unsavestock", method=RequestMethod.GET)
	public int unsaveStock(int userid,String stockSymbol) {

		return dao.unsaveAStock(userid, stockSymbol);
		

	}
	
	//Ready-to-use	
	//------------------------------------------------------------------------------------------------
	//
	@RequestMapping(value = "/topgainers", method=RequestMethod.GET)
	public List<NseStock> topGainers() {

		return dao.topGainers();
		

	}	
	
	//Ready-to-use	
		//------------------------------------------------------------------------------------------------
		//
		@RequestMapping(value = "/toplosers", method=RequestMethod.GET)
		public List<NseStock> topLosers() {

			return dao.topLosers();
			

		}	
	
	/*
	//to get marketPrice
	@RequestMapping(value = "/marketPrice", method = RequestMethod.GET)
	public double marketPrice(String stockSymbol) {
		
		return dao.getMarketPrice(stockSymbol);
	}
	*/
	
	
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