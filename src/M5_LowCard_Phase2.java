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

import java.util.Random;

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
      
      /*
       * Filter inputs
       */
      if (numCardsPerHand < 1 || numCardsPerHand > MAX_CARDS_PER_HAND) {
         int randomInt = new Random().nextInt(MAX_CARDS_PER_HAND) + 1;
         // Pick some random amount of cards between 1 and MAX_CARDS_PER_HAND
         this.numCardsPerHand = randomInt;
      }
      else {
         this.numCardsPerHand = numCardsPerHand;
      }
      
      if (numPlayers < 2 || numPlayers > MAX_PLAYERS) {
         /*
          * We will assume the minimum amount of players is two but will not 
          * assume the max players will always be two. Thus, we will set the
          * filter to the minimum players of 2. JPanels will only display 2.
          */
         this.numPlayers = 2;
      }
      else {
         this.numPlayers = numPlayers;
      }
      // Setup a border layout
      setLayout(new BorderLayout());
      /*
       * Setup of the Public JPanels, give them a border with a title, then add
       * them to their appropriate boarder location
       */
      // Top Computer Hand 
      pnlComputerHand = new JPanel(new GridLayout(1,numCardsPerHand));
      pnlComputerHand.setBorder(new TitledBorder("Computer Hand"));
      add(pnlComputerHand, BorderLayout.NORTH);
      
      // Middle Playing Area
      pnlPlayArea = new JPanel(new GridLayout(2,numPlayers));
      pnlPlayArea.setBorder(new TitledBorder("Playing Area"));
      add(pnlPlayArea, BorderLayout.CENTER);
      
      // Bottom Human Player Hand
      pnlHumanHand = new JPanel(new GridLayout(1,numCardsPerHand));
      pnlHumanHand.setBorder(new TitledBorder("Your Hand"));
      add(pnlHumanHand, BorderLayout.SOUTH);
      
   }

   // Accessors (Getters)
   /**
    * @return the number of cards per hand
    */
   int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   /**
    * @return the number of players
    */
   int getNumPlayers()
   {
      return numPlayers;
   }
}

class GUICard {
   private static Icon[][] iconCards = new ImageIcon[14][4];
   private static Icon iconBack;
   static boolean iconsLoaded = false;
   
   static void loadCardIcons() {
      String imageDirectory = "images/";
      String imageExtension =".gif";
      
      // Check to see if this has been done already
      if(iconsLoaded) {
         return;
      }
      
      for(int suit = 0; suit < 4; suit++) {
         for(int value = 0; value < 14; value++) {
            String imageFile = imageDirectory.
                  concat(turnIntIntoCardValue(value)).
                  concat(turnIntIntoCardSuit(suit)).
                  concat(imageExtension);
            iconCards[value][suit] = new ImageIcon(imageFile);
         }
      }
      
      // Set a verification that this has been run
      iconsLoaded = true;
   }
   
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int valueInt)
   {
      // Need to increment all values up by one
      valueInt++;
      switch(valueInt) {
      case 1:
         return "A";
      case 10:
         return "T";
      case 11:
         return "J";
      case 12:
         return "Q";
      case 13:
         return "K";
      case 14:
         return "X";
      default:
         return Integer.toString(valueInt);
      }
   }
   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int suitInt)
   {
      switch(suitInt)
      {
      case 0:
         return "C";
      case 1:
         return "D";
      case 2:
         return "H";
      case 3:
         return "S";
      default:
         return null;
      }
   }
   
}