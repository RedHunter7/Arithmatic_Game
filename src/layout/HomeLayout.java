package layout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomeLayout extends JPanel {

	private static final long serialVersionUID = 1L;

	//creating instance of JLabel
    JLabel gameTitle = new JLabel("Arithmatic Game");
    
    //creating instance of JButton
    public JButton startBtn = new JButton("Start");
    
	public HomeLayout(boolean isVisible) {					
	    //x axis, y axis, width, height
	    gameTitle.setBounds(0, 120, 400, 30);
	    Font gameTitleFont = new Font(
	    		gameTitle.getFont().getName(), 
	    		gameTitle.getFont().getStyle(), 
	    		20 // font size
	    );
	    
	    gameTitle.setFont(gameTitleFont);
	    
	    // set text align to center position
	    gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
						    
	    //x axis, y axis, width, height  
	    startBtn.setBounds(150, 180, 100, 40);
	    
	    setSize(400,500); 
	    
	    add(gameTitle);
	    add(startBtn);
	    
	    setLayout(null);  
	    setVisible(isVisible); 
	}
}
