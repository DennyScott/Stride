/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Bounty;
import DataAccessors.BountyTransDA;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class BountyAdapter {
    
    public ArrayList<Bounty> getAwardedBounties(int id, int start, int end){
        BountyTransDA bt = new BountyTransDA();
        ArrayList<Bounty> returnList = new ArrayList<Bounty>();
        
        ArrayList<ModelObjects.BountyTrans> bounties = bt.getUserRecentBounties(id, start, end);
        
        for(ModelObjects.BountyTrans bounty: bounties){
            returnList.add(adaptBounty(bounty));
        }
        
        return returnList;
        
    }
    
    public Bounty adaptBounty(ModelObjects.BountyTrans bounty){
        Bounty b = new Bounty();
        
        b.setBounty(bounty.getBounty());
        b.setQuestionID(bounty.getQuestionID()+"");
        b.setTime(bounty.getTimeCollected());
        b.setUserID(bounty.getUserID()+"");
        
        return b;
    }
}


