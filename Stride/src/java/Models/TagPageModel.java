/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.TagAdapter;
import Beans.TagPage;

/**
 *
 * @author Denny
 */
public class TagPageModel {

    public TagPage getPage(int page) {
        int questionPerPage = 40;
        int start = page * questionPerPage - 20;
        
        TagPage tPage = new TagPage();
        TagAdapter ta = new TagAdapter();
        int count = ta.getTotalTags();
        int pages = count/20;
        boolean leading = false;
        if(pages>=4){
            leading = true;
        }
        
        tPage.setLeadingPages(leading);
        tPage.setCurrentPage(page);
        
        tPage.setTotalPages(page);
        tPage.setTotalTags(count);
        tPage.setTags(ta.collectAllTags(start, questionPerPage));
        return tPage;
    }
}
