package timer;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

//sample class
public class CountdownTimer {
	//declare timer t
	public Timer timer;
	float time;
	JLabel timerText;
	
	private boolean isStart;
	
	private TimeUpHandler timeUpHandler;
	
	//constructor of the class
	public CountdownTimer(JLabel GUIText) {
		timerText = GUIText;
		isStart = false;
		
		timer = new Timer();
		
		//schedule the timer
		timer.schedule(new rt(), 0, 10);
	}
	
	public void start(float seconds) {
		isStart = true;
		time = seconds;
	}
	
	public float getTimeLeft() {
		return time;
	}
	
	//sub class that extends TimerTask
	class rt extends TimerTask {
		//task to perform on executing the program
		public void run() {
			time = time - 0.01f;
			String text = Float.toString(time);
			text = text.substring(0, 4);
			timerText.setText(text);
			
			if (time <= 0 && isStart == true) {
				timeUpHandler.call();
				
				//stop the thread of timer
				timer.cancel();
				timerText.setText("0.00");
			}
		}
	}
	
	public interface TimeUpHandler {
		void call();
	}
	
	public void OnTimeUp(CountdownTimer.TimeUpHandler callback) {
		timeUpHandler = callback;
	}
}
