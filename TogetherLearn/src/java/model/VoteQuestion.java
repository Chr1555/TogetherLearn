package model;
// Generated Feb 16, 2017 4:30:43 PM by Hibernate Tools 4.3.1



/**
 * VoteQuestion generated by hbm2java
 */
public class VoteQuestion  implements java.io.Serializable {


     private VoteQuestionId id;
     private Questions questions;
     private Users users;
     private Long vote;

    public VoteQuestion() {
    }

	
    public VoteQuestion(VoteQuestionId id, Questions questions, Users users) {
        this.id = id;
        this.questions = questions;
        this.users = users;
    }
    public VoteQuestion(VoteQuestionId id, Questions questions, Users users, Long vote) {
       this.id = id;
       this.questions = questions;
       this.users = users;
       this.vote = vote;
    }
   
    public VoteQuestionId getId() {
        return this.id;
    }
    
    public void setId(VoteQuestionId id) {
        this.id = id;
    }
    public Questions getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Long getVote() {
        return this.vote;
    }
    
    public void setVote(Long vote) {
        this.vote = vote;
    }




}


