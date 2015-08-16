/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

/**
 *
 * @author Naveen Yadav
 */
public class StockMaster
{
    private String StockName;
    private String Version;
    private String Casting;
    private String Director;
    private String Year;
    private int Quantity;
    private Double Price;

    /**
     * @return the StockName
     */
    public String getStockName() {
        return StockName;
    }

    /**
     * @param StockName the StockName to set
     */
    public void setStockName(String StockName) {
        this.StockName = StockName;
    }

    /**
     * @return the Version
     */
    public String getVersion() {
        return Version;
    }

    /**
     * @param Version the Version to set
     */
    public void setVersion(String Version) {
        this.Version = Version;
    }

    /**
     * @return the Casting
     */
    public String getCasting() {
        return Casting;
    }

    /**
     * @param Casting the Casting to set
     */
    public void setCasting(String Casting) {
        this.Casting = Casting;
    }

    /**
     * @return the Director
     */
    public String getDirector() {
        return Director;
    }

    /**
     * @param Director the Director to set
     */
    public void setDirector(String Director) {
        this.Director = Director;
    }

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Price
     */
    public Double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(Double Price) {
        this.Price = Price;
    }
    
}
