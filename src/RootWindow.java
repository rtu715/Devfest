import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

/*
 A root window class to house other controls.
 author: armerala
 */

public class RootWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private final Vector2 pos = new Vector2(0,0);
	List<InfoPanel> infoPanels;
	
	public RootWindow(){
		//window properties--innate
		this.setUndecorated(true);
		this.setBackground(new Color(1,1,1,100));
		
		//disable dragging of window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
		
		//add controls
		infoPanels.add(new InfoPanel());
		
		pack();
		this.toBack();
	}
}