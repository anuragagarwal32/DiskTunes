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
public class UserAccount 
{
    private String loginId;
    private String cbal;
    private String nbal;

    /**
     * @return the cbal
     */
    public String getCbal() {
        return cbal;
    }

    /**
     * @param cbal the cbal to set
     */
    public void setCbal(String cbal) {
        this.cbal = cbal;
    }

    /**
     * @return the nbal
     */
    public String getNbal() {
        return nbal;
    }

    /**
     * @param nbal the nbal to set
     */
    public void setNbal(String nbal) {
        this.nbal = nbal;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
}
