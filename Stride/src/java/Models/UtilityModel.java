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
    
}
