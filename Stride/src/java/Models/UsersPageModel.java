/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.UserPage;

/**
 *
 * @author Denny
 */
public class UsersPageModel {
    public UserPage getUserPage(){
    UserPage up = new UserPage();
    up.setUsers(new UserAdapter().getAllUsers());
    }
}
