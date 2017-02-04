import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {

	private static String[] controls = {"Please Choose One", "CPU", 
				"Weather", "Calendar", "SpeedTest", "DirectoryTree"};
	private JPanel parentPanel;
	private JComboBox dropDown;
	
	public ControlPanel(InfoPanel parent) {
		super();
		parentPanel = parent;
		dropDown = new JComboBox(controls);
		dropDown.setSelectedIndex(0);
		dropDown.addActionListener(this);
	}

	/** Listens to the drop down. */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String control = (String) cb.getSelectedItem();
        parentPanel.update(control); 
    }

}