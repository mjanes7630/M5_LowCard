import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
   
public class Assig5 
{
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.
   
   static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
       
   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop.  For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      String imgExt = ".gif";
      String imgDir = "images/";
      int index = 0;
      for(int suit = 0; suit < 4; suit++) 
      {
         for(int val = 0; val < 14; val++) 
         {
            String img = imgDir.concat(turnIntIntoCardValue(val)).
                  concat(turnIntIntoCardSuit(suit)).
                  concat(imgExt);
            icon[index] = new ImageIcon(img);
            index++;
         }
      }
      icon[index] = new ImageIcon(imgDir.concat("BK").concat(imgExt));
   }
   
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
      k++;
      switch(k) 
      {
      //ace
      case 1:
         return "A";
      //10
      case 10:
         return "T";
      //Jack
      case 11:
         return "J";
      //Queen
      case 12:
         return "Q";
      //King
      case 13:
         return "K";
      //Joker
      case 14:
         return "X";
      //Cards 2-9
      default:
         return Integer.toString(k);      
      }
   }
   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
      switch (j) 
      {
      //clubs
      case 0:
         return "C";
      //diamonds       
      case 1:
         return "D";
      //hearts
      case 2:
         return "H";
      //spades
      case 3:
         return "S";
      default:
         return null;
      }
   }
 //TODO:Delete this code, i'm just trying to spin icons :)
   static void iconSpin() 
   {
      int currentIconHeight = 0;
      int currentIconWidth = 0;
      int maxRow = 0;
      int rGB = 0;
      for(int i = NUM_CARD_IMAGES - 1; i >= 0; i--) 
      {
         currentIconHeight = icon[i].getIconHeight();
         currentIconWidth = icon[i].getIconWidth();
         maxRow = currentIconHeight;

         BufferedImage tempImage = new BufferedImage(currentIconHeight, 
               currentIconWidth, BufferedImage.TYPE_INT_RGB);
         
         BufferedImage currentIcon = new BufferedImage(
               icon[i].getIconWidth(), icon[i].getIconHeight(),
               BufferedImage.TYPE_INT_RGB);
         Graphics g = currentIcon.createGraphics();
         icon[i].paintIcon(null, g, 0, 0);
         g.dispose();
         
         for(int y = 0; y < currentIconHeight; y++) {
            maxRow--;
            for(int x = 0; x < currentIconWidth; x++) 
            {
               rGB = currentIcon.getRGB(x, y);
               tempImage.setRGB(maxRow, x, rGB);
            }
         }
         icon[i] = new ImageIcon(tempImage);                
      }
   }

   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;
      
      // prepare the image icon array
      loadCardIcons();
      iconSpin();
      iconSpin();
      iconSpin();
      iconSpin();
      
      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
      frmMyWindow.setLayout(layout);
      
      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);
      
      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}