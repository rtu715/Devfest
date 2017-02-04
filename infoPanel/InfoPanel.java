import javax.swing.JPanel;
import javax.swing.JLabel;

public class InfoPanel extends JPanel {

	public enum ScriptType {
		CPU_INFO("CPU"), WEATHER("Weather"), CALENDAR("Calendar"), 
		SPEED_TEST("SpeedTest"), DIR_TREE("DirectoryTree")
	};


	private ControlPanel controlPanel;
	private JLabel label;
	
	public InfoPanel() {
		label = new JLabel();
		controlPanel = new controlPanel(this);
	}

	// update the text part
	/*public void update(String control) {
    	String text;
    	switch (control) {
    		CPU_INFO.toString(): text = Scripts.getCPUInfo();
    							 break;
    		WEATHER.toString(): text = Scripts.getWeather();
    							break;
    		CALENDAR.toString(): text = Scripts.getCalendar();
    							 break;
    		SPEED_TEST.toString(): text = Scripts.getSpeed();
    							   break;
    		DIR_TREE.toString(): text = Scripts.getDirTree();
    							 break;
    	}
    	label.setText(text);
    }*/
}