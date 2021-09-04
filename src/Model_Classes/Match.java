/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Classes;

import java.util.Date;

/**
 *
 * @author 94779
 */
public class Match {
    private FootballClub clubTeamA;
    private FootballClub clubTeamB;
    private int scoredGoalsClubTeamA;
    private int scoredGoalsClubTeamB;
    private Date playedDate;

    public FootballClub getClubTeamA() {
        return clubTeamA;
    }

    public void setClubTeamA(FootballClub clubTeamA) {
        this.clubTeamA = clubTeamA;
    }

    public FootballClub getClubTeamB() {
        return clubTeamB;
    }

    public void setClubTeamB(FootballClub clubTeamB) {
        this.clubTeamB = clubTeamB;
    }

    public int getScoredGoalsClubTeamA() {
        return scoredGoalsClubTeamA;
    }

    public void setScoredGoalsClubTeamA(int scoredGoalsClubTeamA) {
        this.scoredGoalsClubTeamA = scoredGoalsClubTeamA;
    }

    public int getScoredGoalsClubTeamB() {
        return scoredGoalsClubTeamB;
    }

    public void setScoredGoalsClubTeamB(int scoredGoalsClubTeamB) {
        this.scoredGoalsClubTeamB = scoredGoalsClubTeamB;
    }

    public Date getPlayedDate() {
        return playedDate;
    }

    public void setPlayedDate(Date playedDate) {
        this.playedDate = playedDate;
    }

    
    
}
