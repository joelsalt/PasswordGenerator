package GenPack;
import javax.swing.JApplet;

/*This is the main class that runs when the Applet is started.
 * setContentPane() simply creates a new instance of the Gen
 * class and adds it to the window pane.*/

public class WebApplet extends JApplet{
	private static final long serialVersionUID = 1L;
	
	public void init(){
		setContentPane(new Gen());
	}
}
