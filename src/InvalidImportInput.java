import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class InvalidImportInput extends JFrame{
	private JFrame ErrorFrame;

	public InvalidImportInput() {
		ErrorFrame = new JFrame();
		ErrorFrame.setBounds(100, 100, 303, 114);	
//		Exit/Close/ok button
		JButton ExitBtn_1 = new JButton("Ok");
		ExitBtn_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				ErrorFrame.dispose();
			}
		});
		ErrorFrame.getContentPane().add(ExitBtn_1, BorderLayout.SOUTH);
		
//		Displayed message
		JLabel WrongInputMessageLabel = new JLabel("Please import the correct pokemon database file!");
		ErrorFrame.getContentPane().add(WrongInputMessageLabel, BorderLayout.CENTER);
		ErrorFrame.setVisible(true);
	}
}
