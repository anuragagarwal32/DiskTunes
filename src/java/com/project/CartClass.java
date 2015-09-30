/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

/**
 *
 * @author ubuntu
 */
public class CartClass
{
    private String name;
    private int quantity;
    private int price;
    private int diskID;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
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

    /**
     * @return the diskID
     */
    public int getDiskID()
    {
        return diskID;
    }

    /**
     * @param diskID the diskID to set
     */
    public void setDiskID(int diskID)
    {
        this.diskID = diskID;
    }

    
}
