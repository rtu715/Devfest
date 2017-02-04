import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 A root window class to house other controls.
 author: armerala
 */

public class RootWindow{
	
	private JFrame frame;
	private int width;
	private int height;
	
	public RootWindow(){
		//set frame properties and create layout variables
		frame = new JFrame();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 10;
		constraints.gridheight = 10;
		
		frame.setUndecorated(true);
		frame.setBackground(new Color(1,1,1,100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		width = frame.getContentPane().getWidth();
		height = frame.getContentPane().getHeight();
		
		//create each panel that we need
		constraints.gridx = 1;
		constraints.gridy = 1;
		InfoPanel ip = new InfoPanel();
		ip.setLocation(100, 100);
		ip.setPreferredSize(new Dimension(200,200));
		frame.add(ip, constraints);
		

		//finalize frame and show
		frame.toBack();
		frame.pack();
		frame.setVisible(true);
	}
}