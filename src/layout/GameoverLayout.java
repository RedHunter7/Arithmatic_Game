package layout;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameoverLayout extends JPanel {

	private static final long serialVersionUID = 1L;

	//creating instance of JLabel
    JLabel gameoverText = new JLabel("Game Over");
    JLabel scoreText = new JLabel();
    
    //creating instance of JButton
    public JButton homeBtn = new JButton("Home");
    
	public GameoverLayout(boolean isVisible) {	
	    //x axis, y axis, width, height
	    gameoverText.setBounds(0, 120, 400, 30);
	    scoreText.setBounds(0, 160, 400, 40);
	    homeBtn.setBounds(150, 220, 100, 40);
	    
	    Font font = new Font(
	    		gameoverText.getFont().getName(), 
	    		gameoverText.getFont().getStyle(), 
	    		20 // font size
	    );
	    
	    gameoverText.setFont(font);
	    scoreText.setFont(font);
	    
	    // set text align to center position
	    gameoverText.setHorizontalAlignment(SwingConstants.CENTER);
	    scoreText.setHorizontalAlignment(SwingConstants.CENTER);					 
	    
	    setSize(400,500);
	    
	    add(gameoverText);
	    add(scoreText);
	    add(homeBtn);
	    
	    setLayout(null);  
	    setVisible(isVisible); 
	}
	
	public void setScoreText(int score) {
		scoreText.setText("Score: " + Integer.toString(score));
	}
}

