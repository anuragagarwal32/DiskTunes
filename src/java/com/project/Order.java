/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

/**
 *
 * @author twinklesharma
 */
public class Order 
{
  private String loginID;  
  private String stockID;
  private String quantity;

    /**
     * @return the loginID
     */
    public String getLoginID()
    {
        return loginID;
    }

    /**
     * @param loginID the loginID to set
     */
    public void setLoginID(String loginID)
    {
        this.loginID = loginID;
    }

    /**
     * @return the stockID
     */
    public String getStockID()
    {
        return stockID;
    }

    /**
     * @param stockID the stockID to set
     */
    public void setStockID(String stockID)
    {
        this.stockID = stockID;
    }

    /**
     * @return the quantity
     */
    public String getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

   
          
}
