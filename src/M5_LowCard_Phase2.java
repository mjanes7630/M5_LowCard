/**
 * Group 4 
 * Justin Thomas 
 * Marcos Barrera 
 * Cristian Vazquez 
 * Michael Janes 
 * CST338 Module 5
 * 04/07/2020
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class M5_LowCard_Phase2 {
   static int NUM_CARDS_PER_HAND = 7;
   static int NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
   static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

   public static void main(String[] args) {
      int k;
      Icon tempIcon;
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", 
                                             NUM_CARDS_PER_HAND,
                                             NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);

      /*
       * CREATE LABELS ----------------------------------------------------
       * code goes here ...
       */
      
      /*
       * ADD LABELS TO PANELS -----------------------------------------
       * code goes here ...
       */

      /*and two random cards in the play region 
       * (simulating a computer/human play)
       * code goes here ...
       */

      // show everything to the user
      myCardTable.setVisible(true);

   }

}

class CardTable extends JFrame {
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2; 

   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
   
   // Constructor
   CardTable(String title, int numCardsPerHand, int numPlayers) {
      /*
       * Instantiate the JFrame super class with its own parameterized
       * constructor passing in the title
       */
      super(title);
      
      
   }

   // Accessors (Getters)
   /**
    * @return the number of cards per hand
    */
   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   /**
    * @return the number of players
    */
   public int getNumPlayers()
   {
      return numPlayers;
   }
}