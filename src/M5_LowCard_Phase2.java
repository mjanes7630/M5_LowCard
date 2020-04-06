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
      @SuppressWarnings("unused")
      int k;
      @SuppressWarnings("unused")
      Icon tempIcon;
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", 
                                             NUM_CARDS_PER_HAND,
                                             NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // create labels
      playLabelText[0] = new JLabel("Computer", JLabel.CENTER);
      playLabelText[1] = new JLabel("Player 1", JLabel.CENTER);   
      
      for(int i = 0; i < NUM_CARDS_PER_HAND - 1; i ++) {
         Card playerCard = randomCardGenerator();         
                
         computerLabels[i] = (new JLabel(GUICard.getBackCardIcon()));
         humanLabels[i] = (new JLabel(GUICard.getIcon(playerCard)));
         
         // add labels to panels
         myCardTable.pnlComputerHand.add(computerLabels[i]);
         myCardTable.pnlHumanHand.add(humanLabels[i]);
      }
      
      // add two random cards in the play region (player1 + cpu)
      
      Card playerCard = randomCardGenerator();
      Card cpuCard = randomCardGenerator();
      myCardTable.pnlPlayArea.add(new JLabel(GUICard.getIcon(cpuCard)));
      myCardTable.pnlPlayArea.add(new JLabel(GUICard.getIcon(playerCard)));
      myCardTable.pnlPlayArea.add(playLabelText[0]);             
      myCardTable.pnlPlayArea.add(playLabelText[1]);
            
      
      // show everything to the user
      myCardTable.setVisible(true);

   }

   //TODO: remove, this is test code
   static Card randomCardGenerator() {
      Random random = new Random();
      char value = 'A';
      Card.Suit suit = Card.Suit.spades;
      
      // random value
      switch(random.nextInt(13)) {
      case 0 : 
         value = 'A';
         break;
      case 1 : 
         value = '2';
         break;
      case 2 : 
         value = '3';
         break;
      case 3 : 
         value = '4';
         break;
      case 4 : 
         value = '5';
         break;
      case 5 : 
         value = '6';
         break;
      case 6 : 
         value = '7';
         break;
      case 7 : 
         value = '8';
         break;
      case 8 : 
         value = '9';
         break;
      case 9 : 
         value = 'T';     
         break;
      case 10 : 
         value = 'J';
         break;
      case 11 : 
         value = 'Q';
         break;
      case 12 : 
         value = 'K';
         break;
      case 13 : 
         value = 'X';
         break;       
      }
      
      // random suit
      switch(random.nextInt(3)) {
      case 0 :
         suit = Card.Suit.clubs;
         break;
      case 1 : 
         suit = Card.Suit.diamonds;
         break;
      case 2 :
         suit = Card.Suit.hearts;
         break;
      case 3 : 
         suit = Card.Suit.spades;
         break;
      }
      
      return new Card(value, suit);
   }
}

@SuppressWarnings("serial")
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
      
      // The card back is also an icon so we should load this as well.
      iconBack = new ImageIcon(imageDirectory.
                               concat("BK").
                               concat(imageExtension));
      // Set a verification that this has been run
      iconsLoaded = true;
   }
   
   static public Icon getIcon(Card card) {
      // This is an opportunity to load the card icons
      loadCardIcons();
      return iconCards[valueAsInt(card)][suitAsInt(card)];
   }
   
   static public Icon getBackCardIcon() {
      // This is an opportunity to load the card icons
      loadCardIcons();
      return iconBack;
   }
   
   private static int suitAsInt(Card card)
   {
      Card.Suit suit = card.getSuit();
      
      switch(suit) {
      case clubs:
         return 0;
      case diamonds:
         return 1;
      case hearts:
         return 2;
      case spades:
         return 3;
      default:
         return -999; // The default case should never be met
      }
   }

   private static int valueAsInt(Card card)
   {
      char value = card.getValue();
      switch(value) {
      case 'A':
         return 1;
      case 'T':
         return 10;
      case 'J':
         return 11;
      case 'Q':
         return 12;
      case 'K':
         return 13;
      case 'X':
         return 14;
      default:
         return Integer.parseInt(String.valueOf(value));
      }
   }

   // Private Helper Methods
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   private static String turnIntIntoCardValue(int valueInt)
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
   private static String turnIntIntoCardSuit(int suitInt)
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

class Card
{
   // enum storing card suits (Method made static)
   public enum Suit
   {
      clubs, diamonds, hearts, spades
   }

   // Private Statics for Card Class
   private static final char DEFAULT_VALUE = 'A';
   private static final Suit DEFAULT_SUIT = Suit.spades;

   // Private Card class members
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   public static char[] valueRanks;
   
   

   /**
    * Card Constructor with no parameters
    */
   public Card()
   {
      this(DEFAULT_VALUE, DEFAULT_SUIT);
   }

   // Constructor with both parameters
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }

   // Accessors and Mutators (getters and setters)
   public char getValue()
   {
      return value;
   }

   public Suit getSuit()
   {
      return suit;
   }

   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   public boolean set(char value, Suit suit)
   {
      // Set value to upperCase
      char upperValue = Character.toUpperCase(value);

      // Check validity of the value and update members and errorFlag
      if (isValid(upperValue, suit))
      {
         this.value = upperValue;
         this.suit = suit;
         errorFlag = false;
         return true;
      } else
      {
         this.value = upperValue;
         this.suit = suit;
         errorFlag = true;
         return false;
      }
   }

   @Override
   public String toString()
   {
      if (errorFlag)
         return "** illegal **";
      else
         return value + " of " + suit;
   }

   // Check if passed card is equal to current card
   public boolean equals(Card card)
   {
      return getValue() == card.getValue() && getSuit() == card.getSuit();
   }

   // Private Methods
   private boolean isValid(char value, Suit suit)
   {
      // Although suit is passed it is not checked

      // Return true if value is a valid value else false (added 'Q')
      return ((value >= '2' && value <= '9') || value == 'A' || value == 'K'
            || value == 'Q' || value == 'J' || value == 'T');
   }

   /**
    * sorts arraySize using bubble sort method
    * @param cards - array of cards to be sorted
    * @param ararySize - length of the array being sorted?
    */
   static void arraySort(Card[] cards, int arraySize) {
      
      for(int i = 0; i < arraySize - 1; i++){
         
         for(int j = 0; i < arraySize - i - 1; j++) {
            Card currentCard = cards[j];
            Card nextCard = cards[j+1];            
            
            // if next card is lower, swap
            if(Character
                  .compare(currentCard.getValue(),
                        nextCard.getValue()) > 1) {
               // create a copy, reference will be overwritten
               Card tempCard = 
                     new Card(currentCard.getValue(), currentCard.getSuit());
               currentCard = new Card(nextCard.getValue(), nextCard.getSuit());
               nextCard = new Card(tempCard.getValue(), nextCard.getSuit());
            }
            
         }// end inner j loop         
         
      }// end outer i loop
      
   }
   
}// end Card class

// Phase 3: The Deck Class
class Deck
{   
   public final int MAX_CARDS = 312;
   private static Card[] masterPack = new Card[52 + 4]; // max deck + 4 jokers
   private Card[] cards;
   private int topCard;

   // Constructors
   public Deck(int numPacks)
   {
      allocateMasterPack();
      init(numPacks);
      topCard = 0;
   }

   public Deck()
   {
      allocateMasterPack();
      cards = masterPack;
   }

   // Re-populates the cards[] with new cards. Resetting it to its original,
   // un-shuffled state.
   // Methods
   public void init(int numPacks)
   {
      cards = new Card[numPacks * 52];
      int index = 0;

      while (numPacks > 0)
      {
         for (int i = 0; i < masterPack.length; i++)
         {
            cards[index] = masterPack[i];
            index++;
         }
         topCard = 0;
         numPacks -= 1;
      }
   }

   // Shuffles the cards[] by iterating through the cards[] and placing the
   // card in each index in a random index.
   public void shuffle()
   {
      Random rand = new Random();
      int num;
      Card tempCard;

      for (int i = 0; i < cards.length; i++)
      {
         num = rand.nextInt(52);
         tempCard = cards[num];
         cards[num] = cards[i];
         cards[i] = tempCard;
      }
   }

   // Returns the card at the 'topCard' position of the deck and simulates the
   // removal from the deck by incrementing topCard by 1. Also, returns
   // null if there are no more cards left.
   public Card dealCard()
   {
      if (topCard == cards.length)
      {
         return null;
      }

      int temp = topCard;
      topCard += 1;
      return cards[temp];
   }

   public int getTopCard()
   {
      return topCard;
   }

   // Returns the card in index k of the cards[]. If cards[k] is out of bounds,
   // then it returns a card with errorFlag set to true.
   public Card inspectCard(int k)
   {
      try
      {
         return cards[k];
      } catch (Exception e)
      {
         return new Card('f', Card.Suit.spades);
      }
   }

   // Populates the masterPack[] with cards.
   private static void allocateMasterPack()
   {
      // Checks to see if masterPack[] has already been filled
      if (masterPack[0] != null)
      {
         return;
      }

      // These four blocks fill the masterPack with Cards
      masterPack[0] = new Card('K', Card.Suit.spades);
      masterPack[1] = new Card('Q', Card.Suit.spades);
      masterPack[2] = new Card('J', Card.Suit.spades);
      masterPack[3] = new Card('T', Card.Suit.spades);
      masterPack[4] = new Card('9', Card.Suit.spades);
      masterPack[5] = new Card('8', Card.Suit.spades);
      masterPack[6] = new Card('7', Card.Suit.spades);
      masterPack[7] = new Card('6', Card.Suit.spades);
      masterPack[8] = new Card('5', Card.Suit.spades);
      masterPack[9] = new Card('4', Card.Suit.spades);
      masterPack[10] = new Card('3', Card.Suit.spades);
      masterPack[11] = new Card('2', Card.Suit.spades);
      masterPack[12] = new Card('A', Card.Suit.spades);

      masterPack[13] = new Card('K', Card.Suit.hearts);
      masterPack[14] = new Card('Q', Card.Suit.hearts);
      masterPack[15] = new Card('J', Card.Suit.hearts);
      masterPack[16] = new Card('T', Card.Suit.hearts);
      masterPack[17] = new Card('9', Card.Suit.hearts);
      masterPack[18] = new Card('8', Card.Suit.hearts);
      masterPack[19] = new Card('7', Card.Suit.hearts);
      masterPack[20] = new Card('6', Card.Suit.hearts);
      masterPack[21] = new Card('5', Card.Suit.hearts);
      masterPack[22] = new Card('4', Card.Suit.hearts);
      masterPack[23] = new Card('3', Card.Suit.hearts);
      masterPack[24] = new Card('2', Card.Suit.hearts);
      masterPack[25] = new Card('A', Card.Suit.hearts);

      masterPack[26] = new Card('K', Card.Suit.diamonds);
      masterPack[27] = new Card('Q', Card.Suit.diamonds);
      masterPack[28] = new Card('J', Card.Suit.diamonds);
      masterPack[29] = new Card('T', Card.Suit.diamonds);
      masterPack[30] = new Card('9', Card.Suit.diamonds);
      masterPack[31] = new Card('8', Card.Suit.diamonds);
      masterPack[32] = new Card('7', Card.Suit.diamonds);
      masterPack[33] = new Card('6', Card.Suit.diamonds);
      masterPack[34] = new Card('5', Card.Suit.diamonds);
      masterPack[35] = new Card('4', Card.Suit.diamonds);
      masterPack[36] = new Card('3', Card.Suit.diamonds);
      masterPack[37] = new Card('2', Card.Suit.diamonds);
      masterPack[38] = new Card('A', Card.Suit.diamonds);

      masterPack[39] = new Card('K', Card.Suit.clubs);
      masterPack[40] = new Card('Q', Card.Suit.clubs);
      masterPack[41] = new Card('J', Card.Suit.clubs);
      masterPack[42] = new Card('T', Card.Suit.clubs);
      masterPack[43] = new Card('9', Card.Suit.clubs);
      masterPack[44] = new Card('8', Card.Suit.clubs);
      masterPack[45] = new Card('7', Card.Suit.clubs);
      masterPack[46] = new Card('6', Card.Suit.clubs);
      masterPack[47] = new Card('5', Card.Suit.clubs);
      masterPack[48] = new Card('4', Card.Suit.clubs);
      masterPack[49] = new Card('3', Card.Suit.clubs);
      masterPack[50] = new Card('2', Card.Suit.clubs);
      masterPack[51] = new Card('A', Card.Suit.clubs);
   }

   /**
    * check if the card exists in the deck
    * if possible, put the card on top of the deck
    * return false if impossible or card exists
    * @param card - card to be added to the deck
    * @return - true if addCard was successful false otherwise
    */
   boolean addCard (Card card) {
      return false;
   }

   /**
    * remove a specific card from the deck
    * put the current top card into its place
    * return false if the card doesn't exist
    * @param card - card to be removed
    * @return - true if removed from the deck, flase otherwise
    */
   boolean removeCard(Card card) {
      return false;
   }
   
   /**
    * put all the cards in the deck back into the right order according to value
    * *???????????????? check if this function exists
    */
   void sort() {
      
   }
   
   /**
    * return the number of cards remaining in the deck
    * @return
    */
   int getNumCards() {
      if(cards != null) {
         return cards.length;   
      }
      
      return 0;
   }
   
}// end Deck Class

class Hand
{
   // max number of cards in a deck, 1 person hand
   public static final int MAX_CARDS = 52 + 4; // add 4 jokers

   Card[] myCards;
   int numCards; // this could be a function that returns myCards.length()

   public int getNumCards()
   {
      return numCards;
   }

   Hand()
   {
      myCards = new Card[0];
      numCards = 0;
   }

   /**
    * removes all cards from the hand (simplest way possible)
    */
   public void resetHand()
   {
      myCards = new Card[0];
      numCards = 0;
   }

   /**
    * adds a card to the next available position in myCards provides object copy
    * not a reference copy
    * 
    * @param card - the card to be stored in the array
    * @return - t/f if card take was successful
    */
   public boolean takeCard(Card card)
   {

      // case for not adding a cards
      if (card.getErrorFlag() || numCards == MAX_CARDS)
      {
         return false;
      }

      // since we haven't learned about enummerated lists or vectors yet,
      // we have to create the array again with an additional space
      int currentLength = myCards.length;
      int newLength = currentLength + 1;
      Card[] currentHand = myCards.clone();
      myCards = new Card[newLength];

      // copy all cards, no references, the list can be deleted
      for (int i = 0; i < currentLength; i++)
      {
         myCards[i] = new Card(currentHand[i].getValue(),
               currentHand[i].getSuit());
      }

      // add the new card
      myCards[newLength - 1] = new Card(card.getValue(), card.getSuit());
      numCards++;

      return true;
   }

   /**
    * returns and removes the top occupied position of the array (last element)
    * 
    * @return - the card that was removed from the myCards
    */
   public Card playCard()
   {
      // what if there are no cards to play, for now return new card with error
      int length = myCards.length;
      if (length < 1)
      {
         return new Card('*', Card.Suit.spades);
      }

      int newLength = length - 1;
      Card playedCard = new Card(myCards[newLength].getValue(),
            myCards[newLength].getSuit());
      Card[] oldHand = myCards.clone();

      // remove the card from the array, recreate the array
      myCards = new Card[newLength];
      for (int i = 0; i < newLength; i++)
      {
         myCards[i] = new Card(oldHand[i].getValue(), oldHand[i].getSuit());
      }

      // decrement the hand count
      numCards--;

      return playedCard;
   }
   
   /**
    * Removes the card at index location and shifts cards down in the array
    * @param cardIndex - index of the card to be played
    * @return - the card that was played
    */
   public Card playCard(int cardIndex)
   {
      if ( numCards == 0 ) //error
      {
         //Creates a card that does not work
         return new Card('M', Card.Suit.spades);
      }
      //Decreases numCards.
      Card card = myCards[cardIndex];
      
      numCards--;
      for(int i = cardIndex; i < numCards; i++)
      {
         myCards[i] = myCards[i+1];
      }
      
      myCards[numCards] = null;
      
      return card;
    }

   /**
    * returns all cards in the hand as a string
    */
   @Override
   public String toString()
   {
      String hand = "Hand = ( ";

      for (int i = 0; i < numCards; i++)
      {
         hand += myCards[i].toString();
         if (i != numCards - 1)
         {
            hand += ", ";
         }
      }

      hand += " )";

      return hand;
   }

   /**
    * returns a copy of the card in myArray based on the parameter position if
    * the card is not found, return a new card with errorFlag = true
    * 
    * @param k - position in the array to search
    * @return - copy of the found card, or card with errorFlag
    */
   public Card inspectCard(int k)
   {
      try
      {
         return myCards[k];
      } catch (Exception ex)
      {
         // expect out of bounds or invalid parameter exception
         // return card with invalid data to set error flag (per instructions)
         // There is no other way to set the error flag
         return new Card('*', Card.Suit.spades);
      }
   }

   /**
    * sort the hand by calling arraySort() from Card class
    */
   void sort() {
      
   }
   
}// end Hand class

