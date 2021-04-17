package com.dao;

import java.math.BigInteger;
import java.util.List;

import com.pojo.UserStock;

public interface TradeRecommendationSystemDAO {
public String [] nsestocks={"AARTIIND","ACE","BAJAJFINSV","RELIANCE"};

public List<UserStock> findCustomerStocks(int customerid);
public boolean verifyUser(String username, String password);
public List<String> stocksWithinMarketCap(BigInteger marketCapSelected);
public void updateDatabaseForToday();
public void insertCompanySymbolsAndSector();

}
