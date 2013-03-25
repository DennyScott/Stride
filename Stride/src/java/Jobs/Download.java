package Jobs;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Travis
 */
public class Download {

    public ArrayList<KijAd> getAds() {
        XmlReader reader = null;
        ArrayList<KijAd> returnList = new ArrayList();

        try {
            URL url = new URL("http://winnipeg.kijiji.ca/f-SearchAdRss?CatId=54&Location=1700192");
            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);

            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                KijAd ad = new KijAd();
                SyndEntry entry = (SyndEntry) i.next();
                ad.setTitle(entry.getTitle().split("\\( Winnipeg \\)")[0]);

                String link = entry.getLink();
                ad.setUrl(link);

                ad.setDate(entry.getPublishedDate()+"");
                String desc = entry.getDescription().getValue();
                ad.setDescription(desc);

                returnList.add(ad);

            }
            return returnList;
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalArgumentException ie){
             Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ie);
        }catch(FeedException fe){
             Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, fe);
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return returnList;
    }

    public ArrayList<KijAd> getAdsWithLocation() {
        XmlReader reader = null;
        ArrayList<KijAd> returnList = new ArrayList();

        try {
            URL url = new URL("http://winnipeg.kijiji.ca/f-SearchAdRss?CatId=54&Location=1700192");
            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);

            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                KijAd ad = new KijAd();
                SyndEntry entry = (SyndEntry) i.next();
                ad.setTitle(entry.getTitle().split("\\( Winnipeg \\)")[0]);

                String link = entry.getLink();
                ad.setUrl(link);

                ad.setDate(entry.getPublishedDate()+"");
                
                String desc = entry.getDescription().getValue();
                ad.setDescription(desc);

                ad.setLoc(getCoords(link));

                returnList.add(ad);

            }
            return returnList;
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IllegalArgumentException ie){
             Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ie);
        }catch(FeedException fe){
             Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, fe);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return returnList;
    }

    private Location getCoords(String input) throws IOException {

        String newURL = findURLExtension(input);
        String html = Jsoup.connect(newURL).get().html();

        return processCoords(html);
    }

    private String findURLExtension(String input) {
        String adKey = input.split("AdIdZ")[1];
        String createdUrl = "http://winnipeg.kijiji.ca/c-ViewMap?AdId=" + adKey;

        return createdUrl;
    }

    private Location processCoords(String html) {

        String lat = html.split("latitude\" content=\"")[1].split("\"")[0];
        String longD = html.split("longitude\" content=\"")[1].split("\"")[0];
        Location newLoc = new Location();
        newLoc.setLatitude(Double.parseDouble(lat));
        newLoc.setLongitude(Double.parseDouble(longD));
        return newLoc;

    }
}
