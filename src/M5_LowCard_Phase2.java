/**
 * Group 4 
 * Justin Thomas 
 * Marcos Barrera 
 * Cristian Vazquez 
 * Michael Janes 
 * CST338 Module 5
 * 04/07/2020
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class M5_LowCard_Phase2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		  ImageIcon icon = new ImageIcon("images/2C.gif");
		  JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);

	}

}
