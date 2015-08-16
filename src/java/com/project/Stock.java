/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import java.io.File;

/**
 *
 * @author ubuntu
 */
public class Stock 
{
    private String id;
    private String name;
    private String version;
    private String casting;
    private String director;
    private String year;
    private String quantity;
    private String price;
    private String desc;
    private File image;
    private String imageFileName;
    private String imageContentType;

  

    /**
     * @return the version
     */
    public String getVersion() 
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) 
    {
        this.version = version;
    }

    /**
     * @return the casting
     */
    public String getCasting() 
    {
        return casting;
    }

    /**
     * @param casting the casting to set
     */
    public void setCasting(String casting) 
    {
        this.casting = casting;
    }

    /**
     * @return the director
     */
    public String getDirector() 
    {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) 
    {
        this.director = director;
    }

    /**
     * @return the year
     */
    public String getYear() 
    {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) 
    {
        this.year = year;
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

    /**
     * @return the price
     */
    public String getPrice() 
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) 
    {
        this.price = price;
    }

    /**
     * @return the desc
     */
    public String getDesc() 
    {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    /**
     * @return the image
     */
    public File getImage() 
    {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(File image) 
    {
        this.image = image;
    }

    /**
     * @return the imageFileName
     */
    public String getImageFileName() 
    {
        return imageFileName;
    }

    /**
     * @param imageFileName the imageFileName to set
     */
    public void setImageFileName(String imageFileName)
    {
        this.imageFileName = imageFileName;
    }

    /**
     * @return the imageContentType
     */
    public String getImageContentType() 
    {
        return imageContentType;
    }

    /**
     * @param imageContentType the imageContentType to set
     */
    public void setImageContentType(String imageContentType) 
    {
        this.imageContentType = imageContentType;
    }

    /**
     * @return the id
     */
    public String getId() 
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) 
    {
        this.id = id;
    }

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

}
