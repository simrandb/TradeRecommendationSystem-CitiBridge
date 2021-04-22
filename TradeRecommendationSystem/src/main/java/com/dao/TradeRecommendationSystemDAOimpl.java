package com.dao;

import java.math.BigInteger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;


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

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.NseStock;
import com.pojo.StockForSector;
import com.pojo.User;
import java.net.URL;

import com.pojo.UserStock;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository
public class TradeRecommendationSystemDAOimpl implements TradeRecommendationSystemDAO {

	
	
	@Autowired
	JdbcTemplate template;

	RestTemplate restTemplate;
	
	public int getUid(String username) {
		String getuid = "select * from customerid where username=?";
		User user = template.queryForObject(getuid, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new User(set.getString(2), set.getString(3));
			}

		},username);
		return user.getUserId();
	}
	
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

	
	public List<String> stocksForSelectedFilters(String marketCapSelected, String sector, int topHowMany)
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
		String sector="";
		for(String stock:nsestocks)
		{
			  try {
			        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-summary?symbol="+stock+".NS"+"&region=IN";
			        URL obj = new URL(url);
			        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			        con.setRequestMethod("GET");
			        con.setRequestProperty("x-rapidapi-key",x_rapidapi_key );
			        con.setRequestProperty("x_rapidapi_host",x_rapidapi_host );
			        int responseCode = con.getResponseCode();
			        //System.out.println("\nSending 'GET' request to URL : " + url);
			        //System.out.println("Response Code : " + responseCode);
			        BufferedReader in = new BufferedReader(
			                new InputStreamReader(con.getInputStream()));
			        String inputLine;
			        StringBuffer response = new StringBuffer();
			        while ((inputLine = in.readLine()) != null) {
			        	response.append(inputLine);
			             //print in String
			             JSONObject myResponse = new JSONObject(response.toString());
			             
			             
			             JSONObject getSth = myResponse.getJSONObject("summaryProfile");
			             Object level = getSth.get("sector");
			             template.update(insertRecord,stock, level);
			             
			  }
			  }

			     catch (Exception e) {
			        e.printStackTrace();
			    }
			  
			
		}
		System.out.println("done");


	}
	
	
	public void unsaveAStock(int userid,String stockSymbol)
	{
		String  deleteRecord= "delete from stocks values where customerid=? and savedstocksymbol=?";
		template.update(deleteRecord,userid, stockSymbol);

	}
	

}

