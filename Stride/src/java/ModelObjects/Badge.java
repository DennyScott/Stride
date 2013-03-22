/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The Badge Bean and Model Object
 * @author Travis
 */
public class Badge {
    
    private int badgeID;
    private int color;
    private String name;
    private int count;
    private String description;

    /**
     * Gets the badgeID of the Badge
     * @return The badgeID of the badge
     */
    public int getBadgeID() {
        return badgeID;
    }

    /**
     * Sets the badgeID to the given value
     * @param badgeID The new badgeID to be set
     */
    public void setBadgeID(int badgeID) {
        this.badgeID = badgeID;
    }

    /**
     * Sets the color of the Badge, 1 being bronze, 2 being silver, and 3 being gold
     * @return The color of the badge
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets the color of the badge, 1 being bronze, 2 being silver, and 3 being gold
     * @param color The new color of the badge
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Gets the name of the Badge
     * @return The name of the Badge
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Badge
     * @param name The new name of the Badge
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the count of how many times this Badge has been earned
     * @return The Count of the Badge
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the amount of times the current Badge has been earned
     * @param count The new count of the Badge
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets the Description of the Badge
     * @return The Description of the current Badge
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of a Badge
     * @param description The new description of the badge
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
