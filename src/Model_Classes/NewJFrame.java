
package Model_Classes;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 94779
 */
public class NewJFrame extends javax.swing.JFrame {

    
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame()  {
        initComponents();
    }

    
    public void rowRemover(){
        DefaultTableModel jtbleModle = (DefaultTableModel) jTable1.getModel();
        
        for (int i = jtbleModle.getRowCount() - 1; i >= 0; i--) {
            jtbleModle.removeRow(i);
        }
    }
    
    public void addRowsJtable(List<FootballClub> fclist) throws IOException{
        
        DefaultTableModel jtbleModle = (DefaultTableModel) jTable1.getModel();
        
        Object data[] = new Object[8];
        
        for (int i = 0; i < fclist.size(); i++) {
            data[0] = fclist.get(i).getLocationOfClub();
            data[1] = fclist.get(i).getNameOfClub();
            data[2] = fclist.get(i).getWinningMatches();
            data[3] = fclist.get(i).getPointsOfClub();
            data[4] = fclist.get(i).getNumbOfGoalsScored();
            data[5] = fclist.get(i).getNumbOfGoalsReceived();
            data[6] = fclist.get(i).getDefeatMatches();
            data[7] = fclist.get(i).getDrawnMatches();
            
            jtbleModle.addRow(data);
        }
    }
    
    public List<FootballClub> ascendingOrder() throws IOException{
        PremierLeagueManager premierLeagueManagerFileReader = new PremierLeagueManager();
        
        List<FootballClub> fclist = premierLeagueManagerFileReader.readFile("Matches.xls");
        
        Collections.sort(fclist, new ClubComaparator());
        
        return fclist;
        
    }
    
    public List<FootballClub> descendingOrder() throws IOException{
        PremierLeagueManager premierLeagueManagerFileReader = new PremierLeagueManager();
        
        List<FootballClub> fclist = premierLeagueManagerFileReader.readFile("Matches.xls");
        
        Collections.sort(fclist, new ClubComaparator().reversed());
        
        return fclist;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(150, 235, 247));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("Premier League Table");

        jButton1.setText("Descending Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Random Match");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Club Location", "Club Name", "Winning Matches", "Points", "Goals Scored", "Goals Received", "Defeat Matches", "Drawn Matches"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText(" Ascending Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            rowRemover();
            addRowsJtable(descendingOrder());
                        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            
            PremierLeagueManager premLeage = new PremierLeagueManager();
            premLeage.randomMatch();
            rowRemover();
            addRowsJtable(descendingOrder());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            
            rowRemover();
            addRowsJtable(ascendingOrder());
                        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    
    
    
    /**
     * @param args the command line arguments
     **/
    public static void main(String args[]) {
        
        Scanner scn = new Scanner(System.in);
        String line;
        int input = 0;
        
        while (true) {
            System.out.println("Premier League Manager");
            System.out.println("");
            
            System.out.println("To open CLI - Press 1 -");
            System.out.println("To Open GUI - Press 2 -");
            System.out.print("Your Choice: ");
            line = scn.next();
            
            try {
                input = Integer.parseInt(line);
                
                switch(input){
                    case 1:
                        PremierLeagueManager plm = new PremierLeagueManager();
                        plm.menu();
                        break;
                    case 2:
                        /* Create and display the form */
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new NewJFrame().setVisible(true);
                            }
                        });
                        break;
                    default:
                        break;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }        
    }
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
