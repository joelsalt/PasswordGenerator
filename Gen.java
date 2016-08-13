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
	
	public void actionPerformed(ActionEvent e){
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
		
		//Set up the string to pull from
		String alphanumeric = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		
		//return an alphanumeric value
		s = alphanumeric.substring(randomNumber, randomNumber + 1);
		
		return s; //end function
	}
	
	public static String GenerateSpecial(){
		String s = new String(); //initialization
		int randomNumber = (int)(Math.random() * 21);
		
		//Set up the string to pull from
		String special = new String("@%+\\/\'!#$^?:,.{}[]~-_");
		
		//return one of the 22 accepted special characters
		/* note: the grave symbol (`) was left out so it wouldn't be confused
		 * with the single quote (')*/
		s = special.substring(randomNumber, randomNumber + 1);
		
		return s; //end function
	}
}
