/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Denny
 */
public class UtilityModel {
    
    public static String filter(String line){
        line = line.replaceAll("\"", "&quot;");
        return line;
    }
    
    public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    }
    // only got here if we didn't return false
    return true;
}
    
}
