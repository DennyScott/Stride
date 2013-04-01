/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class TagPage {
    private ArrayList<Tags> tags;
    private int totalTags;
    private int totalPages;
    private boolean leadingPages;
    private int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean getLeadingPages() {
        return leadingPages;
    }

    public void setLeadingPages(boolean leadingPages) {
        this.leadingPages = leadingPages;
    }
    

    public int getTotalTags() {
        return totalTags;
    }

    public void setTotalTags(int totalTags) {
        this.totalTags = totalTags;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }
    
    
}
