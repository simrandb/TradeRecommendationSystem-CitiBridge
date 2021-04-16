package com.dao;

import java.util.List;

import com.pojo.UserStock;

public interface TradeRecommendationSystemDAO {

public List<UserStock> findCustomerStocks(int customerid);
public boolean verifyUser(String username, String password);
}
