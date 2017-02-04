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
    			label.setText(Scripts.getCpu());
    			break;
    		case WEATHER:
    			label.setText(Scripts.getWeather());
    			break;
    		case CALENDAR:
    			label.setText(Scripts.getCalendar());
    			break;
    		case SPEED_TEST:
    			label.setText(Scripts.getSpeedTest());
    			break;
    		case DIR_TREE:
    			label.setText(Scripts.getDirTree());
    			break;
    		case MEMORY:
    			label.setText(Scripts.getMemory());
				break;
    		default:
    			label.setText("");
    			break;
    	}
    }
	
	public void actionPerformed (ActionEvent e){
		//open up the sub-menu
		//debug for now instead
		System.out.println("hi");
	}
}
