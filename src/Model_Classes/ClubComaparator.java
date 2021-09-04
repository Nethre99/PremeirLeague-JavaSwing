/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Classes;

import java.util.Comparator;

/**
 *
 * @author 94779
 */
public class ClubComaparator implements Comparator<FootballClub>{

    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        if (o1.getPointsOfClub() > o2.getPointsOfClub()) {
            return -1;
        }else{
            if (o1.getPointsOfClub() < o2.getPointsOfClub()) {
                return 1;
            }else{
                int differenceOfGoalsTeamA = o1.getNumbOfGoalsScored() - o1.getNumbOfGoalsReceived();
                int differenceOfGoalsTeamB = o2.getNumbOfGoalsScored() - o2.getNumbOfGoalsReceived();
                
                if (differenceOfGoalsTeamA > differenceOfGoalsTeamB) {
                    return 1;
                }else return 0;
                
            }
        }
    }    
}
