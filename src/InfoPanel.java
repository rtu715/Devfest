import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
//import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel implements ActionListener {
	private JLabel title;
	private JLabel label;
	private ControlPanel controlPanel;
	private Container parentPane;
	//private JButton settingsButton;
	
	public InfoPanel(JFrame frame) {
		super();
		parentPane = frame.getContentPane();
		this.setBackground(new Color(1,15,1,0));
		parentPane.setLayout(new BoxLayout(parentPane, BoxLayout.Y_AXIS));

		//instantiate components and parent the panel
		title = new JLabel("Welcome to LAYER");
		label = new JLabel(":)");
		controlPanel = new ControlPanel(this);
		this.addComponent(title);
		this.addComponent(label);
		this.addComponent(controlPanel);
		title.setForeground(Color.white);
		label.setForeground(Color.white);
		title.setFont(new Font(title.getName(), Font.BOLD, 24));
		label.setFont(new Font(label.getName(), Font.BOLD, 24));
	}

	// update the text part
	public void updateText(ScriptType type) {
    	switch (type) {
    		case CPU_INFO:
    			title.setText("<html>|----|<br>| CPU |------<br>|----|</html>");
    			label.setText(Scripts.getCpu());
    			break;
    		case WEATHER:
    			title.setText("<html>|---------|<br>| WEATHER |------<br>|---------|</html>");
    			label.setText(Scripts.getWeather());
    			break;
    		case CALENDAR:
    			title.setText("<html>|----------|<br>| CALENDAR |------<br>|----------|</html>");
    			label.setText(Scripts.getCalendar());
    			break;
    		case SPEED_TEST:
    			title.setText("<html>|----------|<br>| SPEED TEST |------<br>|----------|</html>");
    			label.setText(Scripts.getSpeedTest());
    			break;
    		case DIR_TREE:
    			title.setText("<html>|------------|<br>| CURRENT DIR |------<br>|------------|</html>");
    			label.setText(Scripts.getDirTree());
    			break;
    		case MEMORY:
    			title.setText("<html>|--------|<br>| MEMORY |------<br>|--------|</html>");
    			label.setText(Scripts.getMemory());
				break;
    		default:
    			title.setText("Default Info");
    			label.setText("Hi, this is a DevFest project.");
    			break;
    	}
    }
	
	public void actionPerformed (ActionEvent e){
		//open up the sub-menu
		//debug for now instead
		System.out.println("hi in info panel");
	}

	public void addComponent(JComponent c) {
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		parentPane.add(c);
	}
}
