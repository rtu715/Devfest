import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SettingsButton extends JButton {
	public SettingsButton(ActionListener c){
		this.addActionListener(c);
		this.setBackground(new Color(0,1,0,1));
	}
}