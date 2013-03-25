/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobs;

/**
 *
 * @author Travis
 */
public class Location {
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" + "longitude=" + longitude + ", latitude=" + latitude + '}';
    }

    
    
    
    
    
    
}
