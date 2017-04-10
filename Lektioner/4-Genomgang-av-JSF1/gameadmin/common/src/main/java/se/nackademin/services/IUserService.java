/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.services;

import se.nackademin.domain.IUser;

/**
 *
 * @author carl
 */
public interface IUserService {
    
    public IUser login(String username, String newPassword);
    
}
