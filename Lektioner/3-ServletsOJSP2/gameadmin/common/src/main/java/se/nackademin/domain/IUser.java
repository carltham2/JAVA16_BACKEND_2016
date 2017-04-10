/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.domain;

/**
 *
 * @author carl
 */
public interface IUser {

    public String getName();

    boolean sessionIsTimedOut();

    String getUserName();

    String getPassword();

    void setPassword(String password);
}
