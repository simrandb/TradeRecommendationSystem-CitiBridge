package com.dao;

import java.math.BigInteger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;


import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	
	//Done
	public void alterSavedStockQuantity(int userid,String companySymbol, String plusminus)
	{
		String  updateRecord= "update stocks set quantity=quantity+(?) where customerid=? and savedstocksymbol=?";
		if(plusminus.toLowerCase().equals("plus"))
			template.update(updateRecord,+1, userid,companySymbol);
		else 
			template.update(updateRecord,-1, userid,companySymbol);
	}
	
	//Done
	public int getUid(String username) {
		String getuid = "select * from customer where username=?";
		User user = template.queryForObject(getuid, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new User(set.getInt(1));
			}

		},username);
		return user.getUserId();
	}
	
	
	//Done
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
	
	
	
	//Done
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
			changeUserLoggedStatus(0, username);
			return true;
		}
		return false;
	}

	
	
	//Done
	public List<NseStock> stocksForSelectedFilters(String marketCapSelected, String sector, int topHowMany ,String growthNumberOrGrowthPercent)
	{
		List<NseStock> stocks=null;
		if (marketCapSelected.equals("any"))
		{
			String find = "select * from nse_stocks where sector=? order by ? desc limit ?";
			stocks = template.query(find, new RowMapper<NseStock>() {

				@Override
				public NseStock mapRow(ResultSet set, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					return new NseStock(set.getString(1),set.getString(2),set.getDouble(3),set.getDouble(4),set.getString(6));
				}

			}, sector,growthNumberOrGrowthPercent,topHowMany);
		}
		else
		{
		String find = "select * from nse_stocks where marketCap=? and sector=? order by ? desc limit ?";
		stocks = template.query(find, new RowMapper<NseStock>() {

			@Override
			public NseStock mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new NseStock(set.getString(1),set.getString(2),set.getDouble(3),set.getDouble(4),set.getString(6));
			}

		}, marketCapSelected,sector,growthNumberOrGrowthPercent,topHowMany);
		}
		
		return stocks;
	}
	
	
	//Done
	public void updateDatabaseForToday()
	{
		int toUpdate=checkDateModifiedOfDatabase();
		
		if (toUpdate==0)
		{
			return;
		}
		Object raw=null;
		String  insertRecord= "update nse_stocks set marketCap=?, growth=?, growthpercent=?, dateModified=(select curdate()) where companySymbol=?";
		NseStock nsestock=new NseStock();
		String marketCapString="";
		ArrayList<Long> timestamps=Determinininggrowthdates();
		for(String stock : dummynsestocks)
		{
			 try {
				 
				 	//for market cap
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
			        JSONObject myResponse=null, level=null;
			        while ((inputLine = in.readLine()) != null) {
			        	response.append(inputLine);
			             //print in String
			             myResponse = new JSONObject(response.toString());
			             
			        
			             JSONObject getSth = myResponse.getJSONObject("price");
			             level = getSth.getJSONObject("marketCap");
			             
			             
			             
			        }
			             long marketCap=(long)level.get("raw");
			             if (marketCap>=500000000000L)
			             {
			            	 marketCapString="Large Cap";
			             }
			             else if (marketCap>=150000000000L)
			             {
			            	 marketCapString="Mid Cap";			            	 
			             }
			             else
			             {
			            	 marketCapString="Small Cap";			            	 			            	 
			             }
			             System.out.println(marketCapString);
			             
			        
			        
			        
			        
			        
			        //for growth and growthpercent
			        url="https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3/get-historical-data?symbol="+stock+".NS&region=IN";
			        obj = new URL(url);
			        con = (HttpURLConnection) obj.openConnection();
			        con.setRequestMethod("GET");
			        con.setRequestProperty("x-rapidapi-key",x_rapidapi_key );
			        con.setRequestProperty("x_rapidapi_host",x_rapidapi_host );
			        responseCode = con.getResponseCode();
			        in = new BufferedReader(
			                new InputStreamReader(con.getInputStream()));
			        response = new StringBuffer();
			        JSONArray getSth=null;
			        while ((inputLine = in.readLine()) != null) {
			        	response.append(inputLine);
			             myResponse = new JSONObject(response.toString());	
			             getSth = myResponse.getJSONArray("prices");
			        }
			        
			        
			             JSONObject object = getSth.getJSONObject(0);
			             Double priceToday = object.getDouble("open");
			             Double pricePast=0.0;
			             
			           for (int i = 0, size = getSth.length(); i < size; i++)
			           {
			        	   object = getSth.getJSONObject(i);
			        	   Long l1=object.getLong("date");
			        	   Long l2=timestamps.get(1);
			        	   if (l1.equals(l2))
			        	   {
			        		   pricePast=object.getDouble("open");
			        		   break;
			        	   }
			           }
			           System.out.println(priceToday);
			           System.out.println(pricePast);
			             
			           Double growthPercent=(java.lang.Math.abs(priceToday-pricePast)*100)/pricePast;
			           if (priceToday<pricePast)
			           {
			        	   growthPercent=-growthPercent;
			           }
			             
			        
					template.update(insertRecord,marketCapString,java.lang.Math.abs(priceToday-pricePast) ,growthPercent,stock);

			             
			  }

			        
			  

			     catch (Exception e) {
			        e.printStackTrace();
			    }
			  
			//nsestock.setMarketCap();
			//nsestock.setGrowth();
			//nsestock.setGrowthpercent();
	
		}

	}
		
	

	
	//Done
	public void insertCompanySymbolsAndSector() 
	{
		String  insertRecord= "insert into nse_stocks(companySymbol,sector) values(?,?)";
		String sector="";
		for(String stock:dummynsestocks)
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
	
	
	//Done
	public int unsaveAStock(int userid,String stockSymbol)
	{

		String  deleteRecord= "delete from stocks where customerid=? and savedstocksymbol=?";
		return template.update(deleteRecord,userid, stockSymbol);
		
	}
	
	
	//Done
	public int checkDateModifiedOfDatabase()
	{
		String findpwd = "select * from nse_stocks where companySymbol='RELIANCE'";
		NseStock stock = template.queryForObject(findpwd, new RowMapper<NseStock>() {

			@Override
			public NseStock mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new NseStock(set.getDate(5));
			}

		});
		 
		java.sql.Timestamp timestamp1 = new java.sql.Timestamp(stock.getDateModified().getTime());
		Date date1 = Date.valueOf(timestamp1.toLocalDateTime().toLocalDate());
		
		ArrayList<Long> timestamps=Determinininggrowthdates();
		Date date2 = new Date( (long)timestamps.get(0)* 1000);
		System.out.println(date2);
		
		System.out.println(date1+" and "+date2);
		System.out.println(date1.toString().equals(date2.toString()));
		if( date1.toString().equals(date2.toString()))
		{
			return 0;
		}
		
		return 1;
	}
	
	
	//Done
	public boolean checkUsernameExistInDatabase(String username)
	{
	try {	
		String findpwd = "select * from customer where username=?";
		User user = template.queryForObject(findpwd, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new User(set.getString(2), set.getString(3));
			}

		},username);
		
	}
	catch(Exception e)
	{
		return false;
	}
		return true;
	}
	
	
	//Done
	public void changeUserLoggedStatus(int loggedStatus,String username)
	{
		String  updateRecord= "update customer set logged=? where username=?";
		template.update(updateRecord,loggedStatus, username);
	}
	
	
	
	
public ArrayList<Long> Determinininggrowthdates()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    java.util.Date date = new java.util.Date();  
	 //   System.out.println(formatter.format(date));
		Calendar c= Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 9);
	    c.set(Calendar.MINUTE, 15);
	    c.set(Calendar.SECOND, 0);
		c.setTime(date);
		int day=c.get(Calendar.DAY_OF_WEEK);
		Long timestamp1 = calculate(day);  //for current workingday
		final Calendar cal3 = Calendar.getInstance(); 
	    cal3.set(Calendar.HOUR_OF_DAY, 9);
	    cal3.set(Calendar.MINUTE, 15);
	    cal3.set(Calendar.SECOND, 0);
	    cal3.add(Calendar.DATE, -14);
	    int date2=cal3.get(Calendar.DATE);
	    int datee = cal3.get(Calendar.DAY_OF_WEEK);
		Long timestamp2 = calculate1(datee);  //for 2 week ago workingday
		ArrayList<Long> timestamps = new ArrayList<>();
		timestamps.add(timestamp1);
	    timestamps.add(timestamp2);
	    System.out.println(timestamp1);
	    System.out.println(timestamp2);
	    return timestamps;
	}
	
	
	public long calculate(int day)
	{
		long ts = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		if(day==7)
		{
			    final Calendar call = Calendar.getInstance();
			    call.set(Calendar.HOUR_OF_DAY, 9);
			    call.set(Calendar.MINUTE, 15);
			    call.set(Calendar.SECOND, 0);
			    call.add(Calendar.DATE, -1);
			    int datee = call.get(Calendar.DATE);
			//    System.out.println("Working date is : ");
			  //  System.out.println(formatter.format(call.getTime()));
			   // System.out.println(call.getTimeInMillis());
			    ts=call.getTimeInMillis()/1000;
		}
		else if(day==1)
		{
			final Calendar call = Calendar.getInstance();
			call.set(Calendar.HOUR_OF_DAY, 9);
		    call.set(Calendar.MINUTE, 15);
		    call.set(Calendar.SECOND, 0);
		    call.add(Calendar.DATE, -2);
		    int date2=call.get(Calendar.DATE);
		   // System.out.println("Working date is : ");
		    //System.out.println(formatter.format(call.getTime()));
		    //System.out.println(call.getTimeInMillis()/1000);
		    ts= call.getTimeInMillis()/1000;
		}
		else
		{
			final Calendar call = Calendar.getInstance();
			call.set(Calendar.HOUR_OF_DAY, 9);
		    call.set(Calendar.MINUTE, 15);
		    call.set(Calendar.SECOND, 0);
		    call.add(Calendar.DATE,0);
		    int date2=call.get(Calendar.DATE);
			ts=call.getTimeInMillis()/1000;
		}
		return ts;
	}
	
	
	public long calculate1(int datee)
	{
		long ts = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		if(datee==7)
		{
			    final Calendar cal = Calendar.getInstance();
			    cal.set(Calendar.HOUR_OF_DAY, 9);
			    cal.set(Calendar.MINUTE, 15);
			    cal.set(Calendar.SECOND, 0);
			    cal.add(Calendar.DATE, -15);
			    int datt = cal.get(Calendar.DATE);
			   // System.out.println("Working date is : ");
			   // System.out.println(formatter.format(cal.getTime()));
			   // System.out.println(cal.getTimeInMillis());
			    ts=cal.getTimeInMillis()/1000;
		}
		else if(datee==1)
		{
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 9);
		    cal.set(Calendar.MINUTE, 15);
		    cal.set(Calendar.SECOND, 0);
		    cal.add(Calendar.DATE, -16);
		    int date2=cal.get(Calendar.DATE);
		   // System.out.println("Working date is : ");
		  //  System.out.println(formatter.format(cal.getTime()));
		  //  System.out.println(cal.getTimeInMillis()/1000);
		    ts= cal.getTimeInMillis()/1000;
		}
		else
		{
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 9);
		    cal.set(Calendar.MINUTE, 15);
		    cal.set(Calendar.SECOND, 0);
		    cal.add(Calendar.DATE,-14);
		    int date2=cal.get(Calendar.DATE);
			ts=cal.getTimeInMillis()/1000;
		}
		return ts;
	}
	
	 

}