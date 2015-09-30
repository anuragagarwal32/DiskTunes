/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import java.util.Date;

/**
 *
 * @author Naveen Yadav
 */
public class OrderMaster
{
    private int orderID;
    private Date orderDate;
    private String status;
    private int price;

    /**
     * @return the orderID
     */
    public int getOrderID()
    {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate()
    {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    
}
