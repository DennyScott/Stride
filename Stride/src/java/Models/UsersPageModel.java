/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.UserAdapter;
import Beans.UserPage;

/**
 *
 * @author Denny
 */
public class UsersPageModel {

    public UserPage getUserPage(int start, int end) {
        UserPage up = new UserPage();
        up.setUsers(new UserAdapter().getAllUsers(start, end));
        return up;
    }
}
