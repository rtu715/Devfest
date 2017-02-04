import javax.swing.JPanel;
import javax.swing.JLabel;

public class InfoPanel {
	private JLabel label;
	private JPanel panel;
	private ControlPanel controlPanel;
	
	private Vector2 pos;
	private Vector2 size;
	
	public InfoPanel() {
		//set instance vars
		
		//instantiate components and parent the panel
		panel = new JPanel();
		label = new JLabel();
		controlPanel = new ControlPanel(this);
		panel.add(label);
		panel.add(controlPanel);
	}

	// update the text part
	public void update(String control) {
    	if (control.equals(ScriptType.CPU_INFO.toString())) { 
            label.setText(Scripts.getCPUInfo());
        } else if (control.equals(ScriptType.WEATHER.toString())) { 
            label.setText(Scripts.getWeather());
        } else if (control.equals(ScriptType.CALENDAR.toString())) { 
            label.setText(Scripts.getCalendar());
        } else if (control.equals(ScriptType.SPEED_TEST.toString())) { 
            label.setText(Scripts.getSpeedTest());
        } else if (control.equals(ScriptType.DIR_TREE.toString())) { 
            label.setText(Scripts.getDirTree());
     	}
    }
}
