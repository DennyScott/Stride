/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Denny
 */
public enum MedalColor {
    GOLD(1), SILVER(2), BRONZE(3);
    private int color;
    
    private MedalColor(int color){
        this.color=color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    
}
