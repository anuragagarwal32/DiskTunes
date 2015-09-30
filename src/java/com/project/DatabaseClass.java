/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ubuntu
 */
public class DatabaseClass 
{
    String url = "jdbc:mysql://localhost:3306/disktunes";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
    public Connection getConnection()
    {
        try
        {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,userName,password);
            return con;
        }
        catch(Exception e)
        {
            System.out.println("Exception Caught : "+e);
            return null;
        }
    }
}
