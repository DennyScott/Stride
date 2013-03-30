/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class TagSearchNode {

    private Tag tag;
    private int popularity;
    private boolean Word;

    public TagSearchNode() {
        popularity = 0;
        this.Word = false;
    }

    
    public boolean isWord() {
        return Word;
    }

    public void setWord(boolean isWord) {
        this.Word = isWord;
    }
    

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void increasePopularity(int increaseAmount) {
        this.popularity += increaseAmount;
    }

    public void decreasePopularity(int decreaseAmount) {
        this.popularity -= decreaseAmount;
    }
}
