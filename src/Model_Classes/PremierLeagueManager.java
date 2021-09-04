/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; 

/**
 *
 * @author 94779 
 */
public class PremierLeagueManager implements LeagueManager{

    private final Scanner scn = new Scanner(System.in);

    private int numbOfClubs = 0;
    private List<FootballClub> club = new ArrayList<>();
    private final ArrayList<Match> matches = new ArrayList<>();;
    private final Workbook wbk = new HSSFWorkbook();
    
    

    public PremierLeagueManager(){}

    public void menu() {
        GUIOpenner guiOpenner = new GUIOpenner();
        
        Scanner scan = new Scanner(System.in);
        
        numbOfClubs++;
        String ch;
        int choice;
    

            System.out.println("******* Football Championship (League) Menu *******");
            System.out.println("");
            System.out.println("Create new club  - Press 1 -");
            System.out.println("Delete an existing club  - Press 2 -");
            System.out.println("Display statistics of club  - Press 3-");
            System.out.println("Display the Premier League table  - Press 4-");
            System.out.println("Add a played match with score with date  - Press 5-");
            System.out.println("Open GUI  - Press 6 -");
            System.out.println("Exit  - Press 9-");
            System.out.println("");
            System.out.print("Your Choice:");

            try {
                ch = scan.next();

                choice = Integer.parseInt(ch);
                
                switch(choice){
                    case 1:
                        addClubToLeague();
                        break;
                    case 2:
                        removeClubFrmLeague();
                        break;
                    case 3:
                        displayStatistics();
                        break;
                    case 4:
                        championShipLeagueTable();
                        break;
                    case 5:
                        addPlayedMatch();
                        break;
                    case 6:
                        guiOpenner.openGUI();
                        System.out.println("Openning GUI....");
                        break;
                    default:
                        break;
                        
                }
                
            } catch (Exception e) {
                System.out.println("Incorrect data type..!");
                menu();
            }
    }

    
    
//    Add Club to the league
    
    @Override
    public void addClubToLeague(){
        try {
            
            List<FootballClub> readFiles = readClubFile("Clubs.xls");
            
            club = readFiles;
            
            
            FootballClub clubObject = new FootballClub();
            String inputString;
            
            System.out.println("");
            System.out.println("******* Adding Club to League *******");
            System.out.print("Club Name: ");
            inputString = scn.next();
            
            clubObject.setNameOfClub(inputString);
            
            if (club.contains(clubObject)) {
                System.out.println("Club has already added to the league..");
                menu();
            }
            
            System.out.print("Club Location: ");
            inputString = scn.next();
            clubObject.setLocationOfClub(inputString);
            
            club.add(clubObject);
            
            excellClubWriter(club, "Clubs.xls");
            
            System.out.println("");
            
            menu();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    
//    Remove club from list
    
    @Override
    public void removeClubFrmLeague() {

        try {
            List<FootballClub> readFiles = readClubFile("Clubs.xls");
            
            club = readFiles;
            
            String rem;
            System.out.println("");
            System.out.println("******* Removing Club *******");
            System.out.print("Club Name: ");
            rem = scn.next();
            
            for (FootballClub clubObjRem : club) {
                if (clubObjRem.getNameOfClub().equalsIgnoreCase(rem)) {
                    
                    club.remove(clubObjRem);
                    
                    System.out.println( clubObjRem.getNameOfClub() + " successfully removed..!");
                    System.out.println("");
                    
                    excellClubWriter(club, "Clubs.xls");
                    
                    return;
                }
                
                System.out.println("There is no Club by the given name..!!");
                System.out.println("");
                menu();
            }
        
            menu();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
    
    
    @Override
    public void displayStatistics() {
        try {
            String stat;
            
            club = readFile("Matches.xls");
            List<FootballClub> readFiles = readClubFile("Clubs.xls");
            
            System.out.println("******* Statistics of Club *******");
            System.out.print("Club Name:  ");
            stat = scn.next();
            
            FootballClub fclubObjectNew = new FootballClub();
            fclubObjectNew.setNameOfClub(stat);
            
            if (readFiles.contains(fclubObjectNew)) {
                
                for (FootballClub objectFoot : readFiles) {
                    if (objectFoot.getNameOfClub().equals(stat)) {
                        System.out.println("Statistics of Club : " + objectFoot.getNameOfClub());
                        System.out.println("Matches Won : " + objectFoot.getWinningMatches());
                        System.out.println("Drawn Matches : " + objectFoot.getDrawnMatches());
                        System.out.println("Defeat Matches : " + objectFoot.getDefeatMatches());
                        System.out.println("Numb of Matches Played : " + objectFoot.getNumbOfMatchesPlayed());
                        System.out.println("Goals Scored : " + objectFoot.getNumbOfGoalsScored());
                        System.out.println("Goals Recieved : " + objectFoot.getNumbOfGoalsReceived());
                        System.out.println("Points : " + objectFoot.getPointsOfClub());
                        System.out.println("");
                        menu();
                    }
                }
                
            }else if(club.contains(fclubObjectNew)){
                
                for (FootballClub objectFoot : club) {
                    if (objectFoot.getNameOfClub().equals(stat)) {
                        System.out.println("Statistics of Club : " + objectFoot.getNameOfClub());
                        System.out.println("Matches Won : " + objectFoot.getWinningMatches());
                        System.out.println("Drawn Matches : " + objectFoot.getDrawnMatches());
                        System.out.println("Defeat Matches : " + objectFoot.getDefeatMatches());
                        System.out.println("Numb of Matches Played : " + objectFoot.getNumbOfMatchesPlayed());
                        System.out.println("Goals Scored : " + objectFoot.getNumbOfGoalsScored());
                        System.out.println("Goals Recieved : " + objectFoot.getNumbOfGoalsReceived());
                        System.out.println("Points : " + objectFoot.getPointsOfClub());
                        System.out.println("");
                        menu();
                    }
                }
            }
            
            System.out.println("There is no Club by the given name..!!");
            System.out.println("");
            menu();
            
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
    
    
    @Override
    public void championShipLeagueTable() {

        try {
            club = readFile("Matches.xls");
            
            System.out.println("******* Premier League Table *******");
            
            Collections.sort(club, new ClubComaparator());
            for (FootballClub clubTable : club) {
                System.out.println(
                        "Club name: " + clubTable.getNameOfClub()
                                +" | Club Location: " + clubTable.getLocationOfClub()
                                +" | Club Winnings: " + clubTable.getWinningMatches()
                                +" | Club Defeats: " + clubTable.getDefeatMatches()
                                +" | Club Goal Difference: " + (clubTable.getNumbOfGoalsScored()-clubTable.getNumbOfGoalsReceived())
                                +" |"
                );
            }
            System.out.println("");
            menu();
        } catch (IOException ex) {
            Logger.getLogger(PremierLeagueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void addPlayedMatch() {
        
        try {
            
            List<FootballClub> readFiles = readClubFile("Clubs.xls");
            
            club = readFiles;
            
            String plyedmtch;
            Date day;
            Match mtch = new Match();
            
            try {
                
                System.out.println("******* Add a Played Match *******");
                System.out.println("");
                System.out.println("Date : (mm/dd/yyyy);");
                plyedmtch = scn.next();
                
                day = new SimpleDateFormat("mm/dd/yyyy").parse(plyedmtch);
                
            } catch (Exception e) {
                System.out.println("You have to enter date in format ' month/day/year '...");
                menu();
                return;
            }
            mtch.setPlayedDate(day);
            
            FootballClub objFC1 = null;
            FootballClub objFC2 = null;
            
            System.out.print("Team 1: ");
            plyedmtch = scn.next();
            
            String t1Name = String.valueOf(plyedmtch);

            for (FootballClub clubPLMtch : club) {
                if (clubPLMtch.getNameOfClub().equals(t1Name))
                    objFC1 = clubPLMtch;
            }
            
            if (objFC1 == null) {
                System.out.println("Check the Name you entered.. ");
                System.out.println("Try again..!");
                menu();
            }
            
            System.out.print("Team 2: ");
            plyedmtch = scn.next();
            String t2Name = String.valueOf(plyedmtch);
            
            for (FootballClub clubPLMtch1 : club) {
                if (clubPLMtch1.getNameOfClub().equals(t2Name))
                    objFC2 = clubPLMtch1;
            }
            
            if (objFC2 == null) {
                System.out.println("Check the Name you entered.. ");
                System.out.println("Try again..!");
                menu();
            }                                                                                         // end of club adder
            
            
            int plydmtchGoals1 = -1;
            int plydmtchGoals2 = -1;
            
            System.out.println("Team 1 Goals: ");
            plyedmtch = scn.next();
            
            try {
                
                plydmtchGoals1 = Integer.parseInt(plyedmtch);
                
            } catch (Exception e) {
                System.out.println("Wrong Format.. ");
                menu();
            }
            
            if (plydmtchGoals1 == -1) {
                System.out.println("You have to enter number of goals");
                menu();
            }
            
            
            System.out.println("Team 2 Goals: ");
            plyedmtch = scn.next();
            
            try {
                
                plydmtchGoals2 = Integer.parseInt(plyedmtch);
                
            } catch (Exception e) {
                System.out.println("Wrong Format.. ");
                menu();
            }
            
            if (plydmtchGoals2 == -1) {
                System.out.println("You have to enter number of goals");
                menu();
            }
            
            mtch.setClubTeamA(objFC1);
            mtch.setClubTeamB(objFC2);
            mtch.setScoredGoalsClubTeamA(plydmtchGoals1);
            mtch.setScoredGoalsClubTeamB(plydmtchGoals2);
            
            matches.add(mtch);
            
            matchMaker(objFC1, objFC2, plydmtchGoals1, plydmtchGoals2);
            
            menu();
            
        } catch (IOException ex) {

            ex.printStackTrace();
        
        }
    }
    
    public void randomMatch() throws IOException{
        FootballClub fcOb1 = new FootballClub();
        FootballClub fcOb2 = new FootballClub();
        
        List<FootballClub> plyedMatches = readFile("Matches.xls");
        
        String randomClub1 = randomClub1();
        String randomClub2 = randomClub2();
        
        if (randomClub1 == null ? randomClub2 != null : !randomClub1.equals(randomClub2) ) {
            
            fcOb1.setNameOfClub(randomClub1);
            fcOb2.setNameOfClub(randomClub2);
            
            int rangeMin = 1;
            int rangeMax = 8;
                
            int randomNumb = (int) (Math.random() * (rangeMin - rangeMax ) + rangeMax);
            int randomNumb2 = (int) (Math.random() * (rangeMin - rangeMax ) + rangeMax);
            
            String location1 = "Location" + randomClub1;
            String location2 = "Location" + randomClub2;
            
            fcOb1.setLocationOfClub(location1);
            fcOb2.setLocationOfClub(location2);
            
            matchMaker(fcOb1,fcOb2,randomNumb,randomNumb2);
            
        }else{
            randomMatch();
        }
    }
    
    private String randomClub1(){
        String team1;
        
        int rangeMin = 1;
        int rangeTeamMax = 20;
        
        int randTeamNameNum1 = (int) (Math.random() * (rangeMin - rangeTeamMax ) + rangeTeamMax);
        
        team1 = "RandTeam" + randTeamNameNum1;
        
        return team1;
    }
    
    private String randomClub2(){
        String team2;
        
        int rangeMin = 1;        
        int rangeTeamMax = 20;
        
        int randTeamNameNum2 = (int) (Math.random() * (rangeMin - rangeTeamMax ) + rangeTeamMax);
        
        team2 = "RandTeam" + randTeamNameNum2;
        
        return team2;
    }
    

    public void matchMaker(FootballClub objFC1, FootballClub objFC2, int plydmtchGoals1, int plydmtchGoals2) throws IOException{        
        
        objFC1.setNumbOfGoalsScored(objFC1.getNumbOfGoalsScored() + plydmtchGoals1);
        objFC2.setNumbOfGoalsScored(objFC2.getNumbOfGoalsScored() + plydmtchGoals2);
        objFC1.setNumbOfGoalsReceived(objFC1.getNumbOfGoalsReceived() + plydmtchGoals2);
        objFC2.setNumbOfGoalsReceived(objFC2.getNumbOfGoalsReceived() + plydmtchGoals1);

        if (plydmtchGoals1 > plydmtchGoals2) {

            objFC1.setPointsOfClub(objFC1.getPointsOfClub() + 3);
            objFC1.setWinningMatches(objFC1.getWinningMatches() + 1);

            objFC2.setDefeatMatches(objFC2.getDefeatMatches() + 1);

        }else if(plydmtchGoals1 < plydmtchGoals2){

            objFC2.setPointsOfClub(objFC2.getPointsOfClub() + 3);
            objFC2.setWinningMatches(objFC2.getWinningMatches() + 1);

            objFC1.setDefeatMatches(objFC1.getDefeatMatches() + 1);

        }else{

            objFC1.setPointsOfClub(objFC1.getPointsOfClub() + 1);
            objFC2.setPointsOfClub(objFC2.getPointsOfClub() + 1);

            objFC1.setDrawnMatches(objFC1.getDrawnMatches() + 1);
            objFC2.setDrawnMatches(objFC2.getDrawnMatches() + 1);
        }


        List<FootballClub> plyedMatches = readFile("Matches.xls");
        plyedMatches.add(objFC1);
        plyedMatches.add(objFC2);

        excellWriter(plyedMatches, "Matches.xls");
    }

    
    
    
    
    
    
    
    
//    File riter and readers
    
    private Object getValueOfCell(Cell cellValue){
        
        switch(cellValue.getCellType()){
            case Cell.CELL_TYPE_STRING:
                return cellValue.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cellValue.getNumericCellValue(); 
        }
        
        return null;
    }
    
    
    public List<FootballClub> readFile(String excellFile) throws IOException{
        
        List<FootballClub> clubList = new ArrayList<>();
        FileInputStream fin = new FileInputStream(new File(excellFile));
        
        Workbook excellWorkbk = new HSSFWorkbook(fin);
        Sheet excelSheet = excellWorkbk.getSheetAt(0);
        Iterator<Row> excellRowItrator = excelSheet.iterator();

        while(excellRowItrator.hasNext()){
            
            Row excellRow = excellRowItrator.next();
            
            Iterator<Cell> excellCellItrator = excellRow.cellIterator();
            
            FootballClub clubObj = new FootballClub();
            
            while(excellCellItrator.hasNext()){
                
                Cell excellCell = excellCellItrator.next();
                
                int excellColumn = excellCell.getColumnIndex();
                
                switch(excellColumn){
                    case 1:
                        clubObj.setLocationOfClub((String) getValueOfCell(excellCell));
                        break;
                    case 2:
                        clubObj.setNameOfClub((String) getValueOfCell(excellCell));
                        break;
                    case 3:
                        clubObj.setWinningMatches((int) (double) getValueOfCell(excellCell));
                        break;
                    case 4:
                        clubObj.setPointsOfClub((int) (double) getValueOfCell(excellCell));
                        break;
                    case 5:
                        clubObj.setNumbOfGoalsScored((int) (double) getValueOfCell(excellCell));
                        break;
                    case 6:
                        clubObj.setNumbOfGoalsReceived((int) (double) getValueOfCell(excellCell));
                        break;
                    case 7:
                        clubObj.setDefeatMatches((int) (double) getValueOfCell(excellCell));
                        break;
                    case 8:
                        clubObj.setDrawnMatches((int) (double) getValueOfCell(excellCell));
                        break;
                }
            }
            clubList.add(clubObj);
        }
        
        excellWorkbk.close();
        fin.close();

        
        return clubList;
    }
    
    
    public List<FootballClub> readClubFile(String excellFile) throws IOException{
        
        List<FootballClub> clubList = new ArrayList<>();
        FileInputStream fin = new FileInputStream(new File(excellFile));
        
        Workbook excellWorkbk = new HSSFWorkbook(fin);
        Sheet excelSheet = excellWorkbk.getSheetAt(0);
        Iterator<Row> excellRowItrator = excelSheet.iterator();

        while(excellRowItrator.hasNext()){
            
            Row excellRow = excellRowItrator.next();
            
            Iterator<Cell> excellCellItrator = excellRow.cellIterator();
            
            FootballClub clubObj = new FootballClub();
            
            while(excellCellItrator.hasNext()){
                
                Cell excellCell = excellCellItrator.next();
                
                int excellColumn = excellCell.getColumnIndex();
                
                switch(excellColumn){
                    case 1:
                        clubObj.setLocationOfClub((String) getValueOfCell(excellCell));
                        break;
                    case 2:
                        clubObj.setNameOfClub((String) getValueOfCell(excellCell));
                        break;
                }
            }
            clubList.add(clubObj);
        }
        
        excellWorkbk.close();
        fin.close();
//        System.out.println(clubList);
        
        return clubList;
    }
    
    
    
    
    
    public void excellWriter(List<FootballClub> clubList, String excellFilePath) throws IOException{
//        FileInputStream fin = new FileInputStream(new File(excellFilePath));
        
        Workbook excellWorkbk = new HSSFWorkbook();
        Sheet excelSheet = excellWorkbk.createSheet();
        
        int excellRowCount = 0;
        
        for (FootballClub club : clubList) {
            Row excelRow = excelSheet.createRow(++excellRowCount);
            write(club, excelRow);
        }
        
        try(FileOutputStream fout = new FileOutputStream(excellFilePath)){
            excellWorkbk.write(fout);
        }
    }
    
    
    
    
    public void excellClubWriter(List<FootballClub> clubList, String excellFilePath) throws IOException{
        
        Workbook excellWorkbk = new HSSFWorkbook();
        Sheet excelSheet = excellWorkbk.createSheet();
        
        int excellRowCount = 0;
        
        for (FootballClub club : clubList) {
            Row excelRow = excelSheet.createRow(++excellRowCount);
            write(club, excelRow);
        }
        
        try(FileOutputStream fout = new FileOutputStream(excellFilePath)){
            excellWorkbk.write(fout);
        }
    }   
    
    
    private void write(FootballClub writeObjFC, Row excelRow) {
        Cell excellCell = excelRow.createCell(1);
        excellCell.setCellValue(writeObjFC.getLocationOfClub());

        excellCell = excelRow.createCell(2);
        excellCell.setCellValue(writeObjFC.getNameOfClub());

        excellCell = excelRow.createCell(3);
        excellCell.setCellValue(writeObjFC.getWinningMatches());

        excellCell = excelRow.createCell(4);
        excellCell.setCellValue(writeObjFC.getPointsOfClub());

        excellCell = excelRow.createCell(5);
        excellCell.setCellValue(writeObjFC.getNumbOfGoalsScored());

        excellCell = excelRow.createCell(6);
        excellCell.setCellValue(writeObjFC.getNumbOfGoalsReceived());

        excellCell = excelRow.createCell(7);
        excellCell.setCellValue(writeObjFC.getDefeatMatches());

        excellCell = excelRow.createCell(8);
        excellCell.setCellValue(writeObjFC.getDrawnMatches());
    }

    
    
}
