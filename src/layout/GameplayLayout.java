package layout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import panel.DigitBtnGridPanel;
import timer.CountdownTimer;

public class GameplayLayout extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public CountdownTimer countdownTimer;
	
	protected JTextField answerField = new JTextField();
	protected JLabel questionText = new JLabel();
	protected JLabel countdownText = new JLabel();
	protected JLabel scoreText = new JLabel();
	protected JLabel wrongAnswerText = new JLabel("Wrong Answer!!!");
	
	// question result
	protected int result;
	
	protected int score;
	
	// total number for 1 seconds
	protected int totalNum;
	
	protected DigitBtnGridPanel digitButtons = new DigitBtnGridPanel(answerField);
	
	public GameplayLayout(boolean isVisible) {
		score = 0;
		
		countdownTimer = new CountdownTimer(countdownText);
	    
	    generateQuestion();
		
		//x axis, y axis, width, height
		digitButtons.setBounds(0, 215, 400, 250);
		questionText.setBounds(0, 60, 400, 40);
		answerField.setBounds(150, 110, 100, 30);
		countdownText.setBounds(20, 10, 100, 30);
		scoreText.setBounds(280, 10, 100, 30);
		wrongAnswerText.setBounds(120, 160, 160, 30);
		
		wrongAnswerText.setVisible(false);
		wrongAnswerText.setHorizontalAlignment(SwingConstants.CENTER);
		wrongAnswerText.setBackground(Color.pink);
		wrongAnswerText.setOpaque(true);
		
		Font textFont = new Font(
				questionText.getFont().getName(), 
				questionText.getFont().getStyle(), 
		    	24 // font size
		    );
		
		answerField.setEditable(false);
		answerField.setBackground(Color.white);
		
		answerField.setFont(textFont);
		answerField.setHorizontalAlignment(SwingConstants.CENTER);
	    
		questionText.setFont(textFont);
		
		countdownText.setFont(textFont);
		countdownText.setText("9.00");
		countdownText.setHorizontalAlignment(SwingConstants.CENTER);
		countdownText.setBackground(Color.magenta);
		countdownText.setOpaque(true);
		
		scoreText.setFont(textFont);
		scoreText.setText("0");
		scoreText.setHorizontalAlignment(SwingConstants.CENTER);
		scoreText.setBackground(Color.lightGray);
		scoreText.setOpaque(true);
	    
	    // set text align to center position
	    questionText.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(answerField);
		add(digitButtons);
		add(questionText);
		add(countdownText);
		add(scoreText);
		add(wrongAnswerText);
		
		setSize(400,500); 
	    
	    setLayout(null);  
	    setVisible(isVisible);
	    
	    // when user click enter button
	    ActionListener clickSubmitBtn = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inputValue = -1;
				if (digitButtons.digitValue != "") {
					inputValue = Integer.parseInt(digitButtons.digitValue);
				}
				
				// if answer is correct, generate new question
				if (inputValue == result) {
					// increment the game score
					float scoreIndex = (totalNum == 2) ? 2 * 0.8f : 6 * 0.6f;
					float questionScore = scoreIndex * countdownTimer.getTimeLeft();
					questionScore = Math.round(questionScore);
					score += questionScore;
					scoreText.setText(Integer.toString(score));
					
					generateQuestion();
				} else { // when answer is wrong
					// show alert text
					wrongAnswerText.setVisible(true);
					
					// reset value on input field
					digitButtons.digitValue = "";
					answerField.setText("");
				}
			}
		};
		digitButtons.submitBtn.addActionListener(clickSubmitBtn);
	}
	
	private void generateQuestion() {
		digitButtons.digitValue = "";
		answerField.setText("");
		wrongAnswerText.setVisible(false);
		
		// randomize number between 2 & 3
		totalNum = 2 + (int) (Math.random() * 2);
		
		// randomize 2-3 number between 11 - 100
		int[] numbers = new int[totalNum];
		for (int i=0;i<numbers.length;i++) {
			numbers[i] = 11 + (int) (Math.random() * 90);
		}
		
		result = numbers[0];
		String question = Integer.toString(result);
		for (int i=0;i<numbers.length-1;i++) {
			result += numbers[i+1];
			question = question.concat(
					" + " + Integer.toString(numbers[i+1])
			);
		}
		
		questionText.setText(question);
		
		// start countdown timer with 5 or 9 seconds
		int time = (totalNum == 2) ? 5 : 9;
		countdownTimer.start(time);
	}
	
	public Integer getScore() {return score;}
}
