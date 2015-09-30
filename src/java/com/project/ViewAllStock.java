

package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Naveen Yadav
 */
public class ViewAllStock 
{  
    private DatabaseClass dbObj=new DatabaseClass();
    
    private ArrayList<StockMaster> userList = new ArrayList<StockMaster>();
    public String execute() throws Exception 
    {  String resultHint=null;
        try
        {
            Connection con=getDbObj().getConnection();
            if(con!=null)
            {
               Statement st= con.createStatement();
               ResultSet rs=st.executeQuery("SELECT * FROM StockMaster");
                StockMaster u = null;
            getUserList().clear();
            while(rs.next())
            {
              u = new StockMaster();
              u.setStockName(rs.getString("StockName"));
              u.setVersion(rs.getString("Version"));
              u.setCasting(rs.getString("Casting"));
              u.setDirector(rs.getString("Director"));
              u.setYear(rs.getString("Year"));
              u.setQuantity(rs.getInt("Quantity"));
              u.setPrice(rs.getDouble("Price"));
                getUserList().add(u);
            } 
            con.close();
            resultHint = "Success";
            }
        }
        catch(Exception e)
        {
            resultHint = "Error";
        }
       return resultHint;
    }    

    /**
     * @return the dbObj
     */
    public DatabaseClass getDbObj() {
        return dbObj;
    }

    /**
     * @param dbObj the dbObj to set
     */
    public void setDbObj(DatabaseClass dbObj) {
        this.dbObj = dbObj;
    }

    /**
     * @return the userList
     */
    public ArrayList<StockMaster> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList<StockMaster> userList) {
        this.userList = userList;
    }
    
}
