import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ControlPanel extends JPanel implements ActionListener {

	private static String[] controls = {"Please Choose One", "CPU", 
			"Weather", "Calendar", "SpeedTest", "DirectoryTree", "Memory"};
	private InfoPanel parentPanel;
	private JComboBox dropDown;
	
	public ControlPanel(InfoPanel parent) {
		super();
		parentPanel = parent;
		dropDown = new JComboBox(controls);
		dropDown.setSelectedIndex(0);
		dropDown.addActionListener(this);
		this.setBackground(new Color(0,1,0,1));
		parentPanel.addComponent(dropDown);
		//parentPanel.updateText(ScriptType.values()[0]);
	}

	/** Listens to the drop down. */
    @Override
	public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        int itemIndex = Arrays.asList(controls).indexOf((String)cb.getSelectedItem());
        parentPanel.updateText(ScriptType.values()[itemIndex]);
    }
}