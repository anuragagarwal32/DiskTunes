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
    private int OrderID;
    private Date OrderDate;
    private String Status;

    /**
     * @return the OrderID
     */
    public int getOrderID()
    {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(int OrderID)
    {
        this.OrderID = OrderID;
    }

    /**
     * @return the OrderDate
     */
    public Date getOrderDate()
    {
        return OrderDate;
    }

    /**
     * @param OrderDate the OrderDate to set
     */
    public void setOrderDate(Date OrderDate)
    {
        this.OrderDate = OrderDate;
    }

    /**
     * @return the Status
     */
    public String getStatus()
    {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status)
    {
        this.Status = Status;
    }
    
}
