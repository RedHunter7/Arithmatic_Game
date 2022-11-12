import layout.GameplayLayout;
import layout.HomeLayout;
import layout.GameoverLayout;
import javax.swing.JFrame;
import java.awt.event.*; 
import timer.CountdownTimer;

public class ArithmaticGame {
	public static void main(String[] args) {
		//creating instance of JFrame  with title "Arithmatic game"
		JFrame frame = new JFrame("Arithmatic Game");
		
		// show home layout
		HomeLayout home = new HomeLayout(true);
		
		// hide game over layout
		GameoverLayout gameover = new GameoverLayout(false);
		
		// 400 width, 500 height
		frame.setSize(400,500); 
	    
	    frame.add(home);
	    frame.add(gameover);
	    
	    frame.setLayout(null);  
	    frame.setVisible(true);
	    
	    // when user click start button
	    home.startBtn.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				
				// show game play layout
				GameplayLayout gameplay = new GameplayLayout(true);
				frame.add(gameplay); 
				
				// when countdown timer is up, game is over
				gameplay.countdownTimer.OnTimeUp(new CountdownTimer.TimeUpHandler() {
					public void call() {
						gameover.setVisible(true);
						gameover.setScoreText(gameplay.getScore());
						
						gameplay.setVisible(false);
						frame.remove(gameplay);
					}
				});
			}  
		});
	    
	    gameover.homeBtn.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				home.setVisible(true);
				gameover.setVisible(false);
			}  
		});
    }
}
