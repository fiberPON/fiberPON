package fiberPON.Objetos;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class JlabelDemo extends JPanel {

	JLabel jlbLabel1;
	public JlabelDemo() {
		ImageIcon icon = new ImageIcon("C:\\Users\\David\\Desktop\\imagenes\\olt.gif");
		// Creating an Icon

		// 3 rows, 1 column Panel having Grid Layout
		jlbLabel1 = new JLabel("Image with Text", icon, JLabel.CENTER);
		// We can position of the text, relative to the icon:
		jlbLabel1.setVerticalTextPosition(JLabel.BOTTOM);
		jlbLabel1.setHorizontalTextPosition(JLabel.CENTER);
	
		
		// Add labels to the Panel
		add(jlbLabel1);
		
	
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("jLabel Usage Demo");
		frame.addWindowListener(new WindowAdapter() {

			// Shows code to Add Window Listener
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setContentPane(new JlabelDemo());
		frame.setBounds(500,250,500,500);;
		frame.setVisible(true);
	}
}