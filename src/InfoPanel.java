import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel implements ActionListener{
	private JLabel label;
	private ControlPanel controlPanel;
	private JButton settingsButton;
	public ScriptType type;
	
	public InfoPanel() {
		super();
		this.setBackground(new Color(1f,0,0,0.5f));
		//this.setLayout();
		//instantiate components and parent the panel
		//settingsButton = new SettingsButton((ActionListener) this);
		label = new JLabel();
		this.add(label);
		//this.add(settingsButton);
		
		//use the position of the wrapper to dictate positon of components
		label.setAlignmentX(50);
		label.setText("TEST");
	}

	// update the text part
	public void update() {
    	switch(this.type){
    		case CPU_INFO:
    			break;
    		case WEATHER:
    			break;
    		case CALENDAR:
    			break;
    		case SPEED_TEST:
    			break;
    		case DIR_TREE:
    			break;
    		default:
    			break;
    	}
		/*
    	if (control.equals(ScriptType.CPU_INFO.toString())) { 
    	
            label.setText(Scripts.getCPUInfo());
        } else if (control.equals(ScriptType.WEATHER.toString())) { 
            label.setText(Scripts.getWeather());
        } else if (control.equals(ScriptType.CALENDAR.toString())) { 
            label.setText(Scripts.getCalendar());
        } else if (control.equals(ScriptType.SPEED_TEST.toString())) { 
            label.setText(Scripts.getSpeedTest());
        } else if (control.equals(ScriptType.DIR_TREE.toString())) {
            //label.setText(Scripts.getDirTree());
     	}
     	*/
    }
	
	public void actionPerformed (ActionEvent e){
		//open up the sub-menu
		//debug for now instead
		System.out.println("hi");
	}
}
