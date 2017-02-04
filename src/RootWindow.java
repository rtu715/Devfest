import java.awt.Color;
import javax.swing.JFrame;

public class RootWindow extends JFrame {
	public RootWindow(){
		System.out.println("yo");
		setTitle("");
		setSize(300,200);
		setUndecorated(true);
		setBackground(new Color(0,0,0,1));
		
		//disable dragging of window
		getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}