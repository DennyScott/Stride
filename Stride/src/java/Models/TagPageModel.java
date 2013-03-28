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
        int questionPerPage = 20;
        int start = page * questionPerPage - 20;
        
        TagPage tPage = new TagPage();
        TagAdapter ta = new TagAdapter();
        
        tPage.setTotalTags(ta.getTotalTags());
        tPage.setTags(ta.collectAllTags(start, questionPerPage));
        return tPage;
    }
}
