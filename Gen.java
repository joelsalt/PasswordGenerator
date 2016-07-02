package GenPack;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gen extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	boolean specialCharacter = false; //Represents a check box to insert a spec. character
	String password = new String(); //This variable will contain the password after the program runs
	int passLength; //Length of password
	
	//Initialization for Gen()
	JLabel title = new JLabel("PASSWORD GENERATOR");
	JLabel lengthLabel = new JLabel("How long does your password have to be?");
	JTextField text = new JTextField(3);
	JCheckBox box = new JCheckBox("Does your password require a special character?");
	JButton button = new JButton("Generate Password");
	JLabel passText = new JLabel("Your password:");
	JLabel pass = new JLabel(password);
	
	Gen(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
		
		setBackground(Color.WHITE);
		add(title);
		add(lengthLabel);
		add(text);
		add(box);
		add(button);
		add(passText);
		add(pass);
		
		button.addActionListener(this); //Makes button clickable
	}
	
	public void actionPerformed(ActionEvent e) {
		if(box.isSelected()){
			specialCharacter = true; //password will contain a specChar
		}
		
		String intFieldText = text.getText();
		passLength = Integer.parseInt(intFieldText); //Grab the specified length
		
		
		//the coup de grace of this code, creates the password
		pass.setText(GeneratePassword(passLength, specialCharacter));
	}
	
	public static String GeneratePassword(int length, boolean specChar){
		String password = new String(); //initialization
		int randInt = 0; //initialization
		
		if(specChar){
			randInt = (int)(Math.random() * length);
			/* This statement is actually quite important. Math.random() returns a 
			 * random value between 0 to 0.999, meaning if you get a value of .48 and
			 * multiply it by 12 you would get a double instead of an integer.
			 * But by casting the value to an int, it forces java to drop the 
			 * decimals on a value thereby making it a whole value, creating a concise 
			 * placement of the specChar.*/
		}
		
		//run a for loop to place all the random letters/numbers into the password
		for(int i = 0; i < length; i++){
			if(specChar && i == randInt){
				password += GenerateSpecial();
			}
			else{
				password += GenerateRandom();
			}
		}
		
		return password; //end function
	}
	
	public static String GenerateRandom(){
		String s = new String(); //initialization
		int randomNumber = (int)(Math.random() * 62); //initialization
		
		//return a alphanumeric value
		switch (randomNumber){
		case 0: s = "a"; break;
		case 1: s = "b"; break;
		case 2: s = "c"; break;
		case 3: s = "d"; break;
		case 4: s = "e"; break;
		case 5: s = "f"; break;
		case 6: s = "g"; break;
		case 7: s = "h"; break;
		case 8: s = "i"; break;
		case 9: s = "j"; break;
		case 10: s = "k"; break;
		case 11: s = "l"; break;
		case 12: s = "m"; break;
		case 13: s = "n"; break;
		case 14: s = "o"; break;
		case 15: s = "p"; break;
		case 16: s = "q"; break;
		case 17: s = "r"; break;
		case 18: s = "s"; break;
		case 19: s = "t"; break;
		case 20: s = "u"; break;
		case 21: s = "v"; break;
		case 22: s = "w"; break;
		case 23: s = "x"; break;
		case 24: s = "y"; break;
		case 25: s = "z"; break;
		case 26: s = "A"; break;
		case 27: s = "B"; break;
		case 28: s = "C"; break;
		case 29: s = "D"; break;
		case 30: s = "E"; break;
		case 31: s = "F"; break;
		case 32: s = "G"; break;
		case 33: s = "H"; break;
		case 34: s = "I"; break;
		case 35: s = "J"; break;
		case 36: s = "K"; break;
		case 37: s = "L"; break;
		case 38: s = "M"; break;
		case 39: s = "N"; break;
		case 40: s = "O"; break;
		case 41: s = "P"; break;
		case 42: s = "Q"; break;
		case 43: s = "R"; break;
		case 44: s = "S"; break;
		case 45: s = "T"; break;
		case 46: s = "U"; break;
		case 47: s = "V"; break;
		case 48: s = "W"; break;
		case 49: s = "X"; break;
		case 50: s = "Y"; break;
		case 51: s = "Z"; break;
		case 52: s = "0"; break;
		case 53: s = "1"; break;
		case 54: s = "2"; break;
		case 55: s = "3"; break;
		case 56: s = "4"; break;
		case 57: s = "5"; break;
		case 58: s = "6"; break;
		case 59: s = "7"; break;
		case 60: s = "8"; break;
		case 61: s = "9"; break;
		}
		
		return s; //end function
	}
	
	public static String GenerateSpecial(){
		String s = new String(); //initialization
		int randomNumber = (int)(Math.random() * 21);
		
		//return one of the 22 accepted special characters
		/* note: the grave symbol (`) was left out so it wouldn't be confused
		 * with the single quote (')*/
		switch (randomNumber){
		case 0: s = "@"; break;
		case 1: s = "%"; break;
		case 2: s = "+"; break;
		case 3: s = "\\"; break;
		case 4: s = "/"; break;
		case 5: s = "\'"; break;
		case 6: s = "!"; break;
		case 7: s = "#"; break;
		case 8: s = "$"; break;
		case 9: s = "^"; break;
		case 10: s = "?"; break;
		case 11: s = ":"; break;
		case 12: s = ","; break;
		case 13: s = "."; break;
		case 14: s = "{"; break;
		case 15: s = "}"; break;
		case 16: s = "["; break;
		case 17: s = "]"; break;
		case 18: s = "~"; break;
		case 19: s = "-"; break;
		case 20: s = "_"; break;
		}
		
		return s; //end function
	}
}
