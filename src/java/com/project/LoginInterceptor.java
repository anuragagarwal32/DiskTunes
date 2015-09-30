/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *
 * @author ubuntu
 */
public class LoginInterceptor implements Interceptor 
{
    
    @Override
    public void destroy() 
    {
        
    }
    
    @Override
    public void init() 
    {
        
    }
    
    /**
     *
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception 
    {
        try
        {
            ValueStack stack=actionInvocation.getStack();
            //System.out.println("\n"+stack+"\n value = "+stack.findString("username"));
            String uname=stack.findString("username");
            uname= uname.toLowerCase();
            stack.set("username",uname);
            return actionInvocation.invoke();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
            return null;
        }
    }
    
}
