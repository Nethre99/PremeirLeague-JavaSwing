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
abstract class SportsClub{
    private String nameOfClub;
    private String locationOfClub;
    private String statisticsOfClub;

    @Override
    public boolean equals(Object obj) {
        return this.nameOfClub.equals(((SportsClub)obj).nameOfClub); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public String getNameOfClub() {
        return nameOfClub;
    }

    public void setNameOfClub(String nameOfClub) {
        this.nameOfClub = nameOfClub;
    }

    public String getLocationOfClub() {
        return locationOfClub;
    }

    public void setLocationOfClub(String locationOfClub) {
        this.locationOfClub = locationOfClub;
    }

    public String getStatisticsOfClub() {
        return statisticsOfClub;
    }

    public void setStatisticsOfClub(String statisticsOfClub) {
        this.statisticsOfClub = statisticsOfClub;
    }

    @Override
    public String toString() {
        return "SportsClub{"+ nameOfClub + ", " + locationOfClub + ", " + statisticsOfClub + '}';
    }
    
    
}