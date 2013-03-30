/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class UserSearchNode {

    private int popularity;
    private User user;
    private boolean User;

    public UserSearchNode() {
        this.popularity = 0;
    }

    public boolean isUser() {
        return User;
    }

    public void setUser(boolean isUser) {
        this.User = isUser;
    }

    public void increasePopularity(int increaseAmount) {
        this.popularity += increaseAmount;
    }

    public void decreasePopularity(int decreaseAmount) {
        this.popularity -= decreaseAmount;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
