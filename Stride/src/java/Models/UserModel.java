/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.UserDA;
import ModelObjects.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class UserModel {

    public boolean addUser(ModelObjects.User user) {
        UserDA um = new UserDA();
        try {
            return um.add(user);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean editUser(ModelObjects.User user) {
        UserDA ua = new UserDA();
        try {
            ModelObjects.User oldUser = ua.query(user.getUserID());

            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setAnonymous(user.isAnonymous());
            oldUser.setBiography(user.getBiography());
            if (user.getProfilePictureLink() != null) {
                oldUser.setProfilePictureLink(user.getProfilePictureLink());
            }

            ua.update(oldUser);
            return true;


        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void incrementGold(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementGold(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementGold(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementGold(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementSilver(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementSilver(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementSilver(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementSilver(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementBronze(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementBronze(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementBronze(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementBronze(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementVotes(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementVotes(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementVotes(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementVotes(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementQuestions(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementQuestions(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementQuestions(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementQuestions(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementAnswers(int id) {
        UserDA uda = new UserDA();
        try {
            uda.incrementAnswers(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementAnswers(int id) {
        UserDA uda = new UserDA();
        try {
            uda.decrementAnswers(id);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void increaseReputation(int userID, int increaseAmount) {
        try {
            UserDA uda = new UserDA();
            User user = uda.increaseReputation(userID, increaseAmount);
            determineRank(increaseAmount, user);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isRankUp(int currentRep, int previousRep, int rankValue, int highestRep) {
        if (((currentRep >= rankValue) && (previousRep < rankValue)) && (currentRep > highestRep)) {
            return true;
        }
        return false;
    }

    public void determineRank(int increaseAmount, User user) {
        int previousRep = user.getReputation() - increaseAmount;
        int currentRep = user.getReputation();
        int highestRep = user.getHighestReputation();
        UserDA uda = new UserDA();
        try {
            if (isRankUp(currentRep, previousRep, 10000, highestRep)) {

                uda.updateRank(user.getUserID(), "Class Tutor");

            } else if (isRankUp(currentRep, previousRep, 5000, highestRep)) {
                uda.updateRank(user.getUserID(), "The Debugger");
            } else if (isRankUp(currentRep, previousRep, 2500, highestRep)) {
                uda.updateRank(user.getUserID(), "QC Junior Assistant");
            } else if (isRankUp(currentRep, previousRep, 1000, highestRep)) {
                uda.updateRank(user.getUserID(), "Child Prodigy");
            } else if (isRankUp(currentRep, previousRep, 500, highestRep)) {
                uda.updateRank(user.getUserID(), "High School Know-It-All");
            } else if (isRankUp(currentRep, previousRep, 100, highestRep)) {
                uda.updateRank(user.getUserID(), "GranGran's Little Repairman");
            }
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decreaseReputation(int userID, int increaseAmount) {
        try {
            UserDA uda = new UserDA();
            uda.decreaseReputation(userID, increaseAmount);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
