/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobs;

/**
 *
 * @author Travis
 */
public class KijAd {
    private String url;
    private String description;
    private String title;
    private String date;
    private Location loc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "KijAd{" + "url=" + url + ", description=" + description + ", title=" + title + ", date=" + date + ", loc=" + loc + '}';
    }
    
    
    
    
}
