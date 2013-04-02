/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.AnswerDA;
import DataAccessors.AnswerVoteDA;
import DataAccessors.QuestionDA;
import DataAccessors.QuestionVoteDA;
import ModelObjects.Answer;
import ModelObjects.Question;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class VotingModel {

    public int questionVoteUpAndGet(int questionID, int userID) {
        QuestionVoteDA vda = new QuestionVoteDA();
        boolean votes = false;
        QuestionDA qda = new QuestionDA();
        try {
            Question myQue = qda.query(questionID);
            if (!(myQue.getUserID() == userID)) {
                try {
                    votes = vda.exists(userID, questionID);

                } catch (IOException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (votes) {
                    try {
                        ModelObjects.QuestionVote temp = vda.query(userID, questionID);
                        if (!temp.isUp()) {
                            temp.setUp(true);
                            vda.update(temp);

                            qda.incrementVote(questionID);
                            qda.incrementVote(questionID);
                            UserModel um = new UserModel();
                            um.increaseReputation(myQue.getUserID(), 10);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!votes) {

                    ModelObjects.QuestionVote oldVotes = new ModelObjects.QuestionVote();
                    oldVotes.setQuestionID(questionID);
                    oldVotes.setUp(true);
                    oldVotes.setUserID(userID);

                    try {
                        vda.add(oldVotes);
                        qda.incrementVote(questionID);
                        UserModel um = new UserModel();
                        um.increaseReputation(myQue.getUserID(), 5);
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return qda.query(questionID).getVotes();
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int answerVoteUpAndGet(int answerID, int userID) {
        AnswerVoteDA vda = new AnswerVoteDA();
        boolean votes = false;
        AnswerDA qda = new AnswerDA();

        try {
            Answer myAns = qda.query(answerID);
            if (!(myAns.getUserID() == userID)) {
                try {

                    votes = vda.exists(userID, answerID);
                } catch (IOException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (votes) {
                    try {
                        ModelObjects.AnswerVote temp = vda.query(userID, answerID);
                        if (!temp.isUp()) {
                            temp.setUp(true);
                            vda.update(temp);
                            qda.incrementVotes(answerID);
                            qda.incrementVotes(answerID);
                            UserModel um = new UserModel();
                            um.increaseReputation(myAns.getUserID(), 10);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!votes) {

                    ModelObjects.AnswerVote oldVotes = new ModelObjects.AnswerVote();
                    oldVotes.setAnswerID(answerID);
                    oldVotes.setUp(true);
                    oldVotes.setUserID(userID);

                    try {
                        vda.add(oldVotes);
                        qda.incrementVotes(answerID);
                        UserModel um = new UserModel();
                        um.increaseReputation(myAns.getUserID(), 5);
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return qda.query(answerID).getVotes();
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int questionVoteDownAndGet(int questionID, int userID) {
        QuestionVoteDA vda = new QuestionVoteDA();
        boolean votes = false;
        QuestionDA qda = new QuestionDA();
        try {
            Question myQue = qda.query(questionID);
            if (!(myQue.getUserID() == userID)) {
                try {
                    votes = vda.exists(userID, questionID);

                } catch (IOException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (votes) {
                    try {
                        ModelObjects.QuestionVote temp = vda.query(userID, questionID);
                        if (temp.isUp()) {
                            temp.setUp(false);
                            vda.update(temp);

                            qda.decrementVote(questionID);
                            qda.decrementVote(questionID);
                            UserModel um = new UserModel();
                            um.decreaseReputation(myQue.getUserID(), 10);
                            um.decreaseReputation(userID, 1);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!votes) {

                    ModelObjects.QuestionVote oldVotes = new ModelObjects.QuestionVote();
                    oldVotes.setQuestionID(questionID);
                    oldVotes.setUp(false);
                    oldVotes.setUserID(userID);

                    try {
                        vda.add(oldVotes);
                        qda.decrementVote(questionID);
                        UserModel um = new UserModel();
                        um.decreaseReputation(myQue.getUserID(), 5);
                        um.decreaseReputation(userID, 1);
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return qda.query(questionID).getVotes();
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int answerVoteDownAndGet(int answerID, int userID) {
        AnswerVoteDA vda = new AnswerVoteDA();
        boolean votes = false;
        AnswerDA qda = new AnswerDA();
        try {
            Answer myAns = qda.query(answerID);
            if (!(myAns.getUserID() == userID)) {
                try {
                    votes = vda.exists(userID, answerID);
                } catch (IOException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (votes) {
                    try {
                        ModelObjects.AnswerVote temp = vda.query(userID, answerID);
                        if (temp.isUp()) {
                            temp.setUp(false);
                            vda.update(temp);
                            qda.decrementVotes(answerID);
                            qda.decrementVotes(answerID);
                            UserModel um = new UserModel();
                            um.decreaseReputation(myAns.getUserID(), 10);
                            um.decreaseReputation(userID, 1);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!votes) {

                    ModelObjects.AnswerVote oldVotes = new ModelObjects.AnswerVote();
                    oldVotes.setAnswerID(answerID);
                    oldVotes.setUp(false);
                    oldVotes.setUserID(userID);

                    try {
                        vda.add(oldVotes);
                        qda.decrementVotes(answerID);
                        UserModel um = new UserModel();
                        um.decreaseReputation(myAns.getUserID(), 5);
                        um.decreaseReputation(userID, 1);
                    } catch (IOException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return qda.query(answerID).getVotes();
        } catch (IOException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VotingModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
