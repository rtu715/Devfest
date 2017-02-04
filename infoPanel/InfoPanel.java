import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InfoPanel extends JPanel {

	private ControlPanel controlPanel;
	private JLabel label;
	
	public InfoPanel() {
		label = new JLabel();
		controlPanel = new ControlPanel(this);
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
