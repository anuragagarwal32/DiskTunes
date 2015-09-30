

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
public class CheckPlacedOrders 
{  
    private DatabaseClass dbObj=new DatabaseClass();
    
    private ArrayList<OrderMaster> userList = new ArrayList<OrderMaster>();
    public String execute() throws Exception 
    {  String resultHint=null;
        try
        {
            Connection con=getDbObj().getConnection();
            if(con!=null)
            {
               Statement st= con.createStatement();
               ResultSet rs=st.executeQuery("SELECT * FROM OrderMaster");
                OrderMaster u = null;
            getUserList().clear();
            while(rs.next())
            {
              u = new OrderMaster();
              u.setOrderID(rs.getInt("OrderID"));
              u.setOrderDate(rs.getDate("OrderDate"));
              u.setStatus(rs.getString("Status"));
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
    public ArrayList<OrderMaster> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList<OrderMaster> userList) {
        this.userList = userList;
    }
    
}
