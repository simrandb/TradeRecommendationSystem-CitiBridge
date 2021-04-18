package com.dao;

import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;

import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.pojo.NseStock;
import com.pojo.User;
import java.net.URL;

import com.pojo.UserStock;

@Repository
public class TradeRecommendationSystemDAOimpl implements TradeRecommendationSystemDAO {

	String symbol="";
	String region="";
	
	
	@Autowired
	JdbcTemplate template;

	
	
	public List<UserStock> findCustomerStocks(int userId) {
		// TODO Auto-generated method stub

		String FINDSTOCKS = "select * from stocks where customerid=?";
		List<UserStock> stocks = template.query(FINDSTOCKS, new RowMapper<UserStock>() {

			@Override
			public UserStock mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new UserStock(set.getString(3), set.getInt(4));
			}

		}, userId);

		return stocks;
	}
	
	public boolean verifyUser(String username, String password)
	{
		
		String findpwd = "select * from customer where username=?";
		User user = template.queryForObject(findpwd, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new User(set.getString(2), set.getString(3));
			}

		},username);
		
		if (user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}

	
	public List<String> stocksWithinMarketCap(BigInteger marketCapSelected)
	{
		
		List <String> stockNames=null;
		return stockNames;
	}
	
	public void updateDatabaseForToday()
	{
		String  insertRecord= "insert into nse_stocks(marketCap,growth,growthpercent,dateModified) values(?,?,?,curdate())";
		NseStock nsestock=new NseStock();
		for(String stock : nsestocks)
		{
			//nsestock.setMarketCap();
			//nsestock.setGrowth();
			//nsestock.setGrowthpercent();
			template.update(insertRecord,nsestock.getMarketCap(), nsestock.getGrowth(),nsestock.getGrowthpercent());
		}

		
	}

	public void insertCompanySymbolsAndSector() 
	{
		
		 
		   
		String  insertRecord= "insert into nse_stocks(companySymbol,sector) values(?,?)";
		NseStock nsestock=new NseStock();
		
		for(String stock:nsestocks)
		{
			  try {
			        URL url = new URL("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-summary?symbol="+stock+".NS"+"&region="+region);
			        
			  }

			     catch (Exception e) {
			        e.printStackTrace();
			    }
			
			//nsestock.setSector();
			template.update(insertRecord,stock, nsestock.getSector());
		}


	}
	
	
	public void unsaveAStock(int userid,String stockSymbol)
	{
		String  deleteRecord= "delete from stocks values where customerid=? and savedstocksymbol=?";
		template.update(deleteRecord,userid, stockSymbol);

	}
	

}

