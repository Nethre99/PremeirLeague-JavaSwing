/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Classes;

/**
 *
 * @author 94779
 */
public class FootballClub extends SportsClub{
    
    private int winningMatches;
    private int defeatMatches;
    private int drawnMatches;
    private int numbOfGoalsReceived;
    private int numbOfGoalsScored;
    private int pointsOfClub;
    private int numbOfMatchesPlayed;

    
        
    public int getWinningMatches() {
        return winningMatches;
    }

    public void setWinningMatches(int winningMatches) {
        this.winningMatches = winningMatches;
    }

    public int getDefeatMatches() {
        return defeatMatches;
    }

    public void setDefeatMatches(int defeatMatches) {
        this.defeatMatches = defeatMatches;
    }

    public int getDrawnMatches() {
        return drawnMatches;
    }

    public void setDrawnMatches(int drawnMatches) {
        this.drawnMatches = drawnMatches;
    }

    public int getNumbOfGoalsReceived() {
        return numbOfGoalsReceived;
    }

    public void setNumbOfGoalsReceived(int numbOfGoalsReceived) {
        this.numbOfGoalsReceived = numbOfGoalsReceived;
    }

    public int getNumbOfGoalsScored() {
        return numbOfGoalsScored;
    }

    public void setNumbOfGoalsScored(int numbOfGoalsScored) {
        this.numbOfGoalsScored = numbOfGoalsScored;
    }

    public int getPointsOfClub() {
        return pointsOfClub;
    }

    public void setPointsOfClub(int pointsOfClub) {
        this.pointsOfClub = pointsOfClub;
    }

    public int getNumbOfMatchesPlayed() {
        return numbOfMatchesPlayed;
    }

    public void setNumbOfMatchesPlayed(int numbOfMatchesPlayed) {
        this.numbOfMatchesPlayed = numbOfMatchesPlayed;
    }

    @Override
    public String getStatisticsOfClub() {
        return super.getStatisticsOfClub(); 
    }

    @Override
    public void setLocationOfClub(String locationOfClub) {
        super.setLocationOfClub(locationOfClub); 
    }

    @Override
    public String getLocationOfClub() {
        return super.getLocationOfClub(); 
    }

    @Override
    public void setNameOfClub(String nameOfClub) {
        super.setNameOfClub(nameOfClub); 
    }

    @Override
    public String getNameOfClub() {
        return super.getNameOfClub(); 
    }

    @Override
    public String toString() {
        return "FootballClub{"+ getNameOfClub() + ", "+ getLocationOfClub() + ", " + winningMatches + ", " + defeatMatches + ", " + drawnMatches + ", " + numbOfGoalsReceived + ", " + numbOfGoalsScored + ", " + pointsOfClub + ", " + numbOfMatchesPlayed + '}';
    }
 
    
    
} 