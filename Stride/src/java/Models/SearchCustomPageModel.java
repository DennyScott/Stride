/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.TagAdapter;
import Adapters.UserAdapter;
import Beans.TagPage;
import Beans.UserPage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class SearchCustomPageModel {

    public UserPage getUserPage(String keyword) {

        UserPage page = new UserPage();
        UserAdapter ua = new UserAdapter();
        SearchModel sm = new SearchModel();
        try {
            page.setUsers(ua.adaptUserList(sm.searchUser(keyword)));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }
    
    public TagPage getTagPage(String keyword){
        TagPage page = new TagPage();
        TagAdapter ta = new TagAdapter();
        SearchModel sm = new SearchModel();
        try {
            page.setTags(ta.adaptTagList(sm.searchTag(keyword)));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }
}
