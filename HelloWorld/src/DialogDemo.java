import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DialogDemo {
	

	public static void main(String[] args) {
		
//	final Frame f = new Frame("Demo");
//	final TextField t1 = new TextField(30);
//	Button b1 = new Button("Login");
		// 下三句是swing方式，上三句是awt方式。
		
		final JFrame f = new JFrame("Demo");
		final JTextField t1 = new JTextField(30);
		JButton b1 = new JButton("Login");
		 
		f.add(t1,  BorderLayout.NORTH);
		
		
		f.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(t1.getText() + ": " + f.getLocation().getX());
				f.setTitle(t1.getText());
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Exiting");
				System.exit(0);
			}
		});

		f.setBackground(Color.blue);
		f.setLocation(400,  500);
		f.pack();
		f.setSize(300,  200);
		
		f.setVisible(true);
	}
}
