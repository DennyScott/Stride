/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class QuestionSearchNode {
    Question foundQuestion;
    int popularity;

    public QuestionSearchNode() {
        this.popularity = 0;
    }
    
    

    public Question getFoundQuestion() {
        return foundQuestion;
    }

    public void setFoundQuestion(Question foundQuestion) {
        this.foundQuestion = foundQuestion;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    
    public void increasePopularity(int increaseAmount){
        this.popularity += increaseAmount;
    }
    
    public void decreasePopularity(int decreaseAmount){
        this.popularity -= decreaseAmount;
    }
}
