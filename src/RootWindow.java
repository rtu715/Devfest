import java.awt.Color;

import javax.swing.JFrame;

public class RootWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public RootWindow(){
		//window properties--innate
		this.setUndecorated(true);
		this.setBackground(new Color(1,1,1,100));
		
		//disable dragging of window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
		pack();
		this.toBack();
	}
}