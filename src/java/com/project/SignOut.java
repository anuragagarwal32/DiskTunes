/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class SignOut
{
    HttpSession session;
    HttpServletRequest request;
    public String execute() throws Exception
    {
        request= ServletActionContext.getRequest();
        session = request.getSession(false);
        if(session!=null)
        {
            System.out.println("here in if");
            session.invalidate();
            //return "Success";
        }
        else
        {
            System.out.println("here in Else");
            return "Fail";
        }
        return "Success";
    }
    
}
