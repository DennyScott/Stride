/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class User {

    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int numberOfQuestions;
    private int numberOfAnswers;
    private int votes;
    private String created;
    private String lastLoggedIn;
    private String profilePictureLink;
    private String biography;
    private String rank;
    private int bronzeCount;
    private int silverCount;
    private int goldCount;
    private boolean Anonymous;
    private int reputation;
    private int highestReputation;
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getProfilePictureLink() {
        return profilePictureLink;
    }

    public void setProfilePictureLink(String profilePictureLink) {
        this.profilePictureLink = profilePictureLink;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getBronzeCount() {
        return bronzeCount;
    }

    public void setBronzeCount(int bronzeCount) {
        this.bronzeCount = bronzeCount;
    }

    public int getSilverCount() {
        return silverCount;
    }

    public void setSilverCount(int silverCount) {
        this.silverCount = silverCount;
    }

    public int getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(int goldCount) {
        this.goldCount = goldCount;
    }

    public boolean isAnonymous() {
        return Anonymous;
    }

    public void setAnonymous(boolean Anonymous) {
        this.Anonymous = Anonymous;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getHighestReputation() {
        return highestReputation;
    }

    public void setHighestReputation(int highestReputation) {
        this.highestReputation = highestReputation;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", numberOfQuestions=" + numberOfQuestions + ", numberOfAnswers=" + numberOfAnswers + ", votes=" + votes + ", created=" + created + ", lastLoggedIn=" + lastLoggedIn + ", profilePictureLink=" + profilePictureLink + ", biography=" + biography + ", rank=" + rank + ", bronzeCount=" + bronzeCount + ", silverCount=" + silverCount + ", goldCount=" + goldCount + ", Anonymous=" + Anonymous + ", reputation=" + reputation + ", highestReputation=" + highestReputation + '}';
    }

    
    
    
}
