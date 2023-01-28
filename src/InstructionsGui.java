//Andy Qu
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class InstructionsGui extends JFrame{

	private JFrame HelpFrame;

	public InstructionsGui() {
		HelpFrame = new JFrame();
//		Exit/Close/ok button
		HelpFrame.setBounds(100, 100, 512, 296);		
		JButton ExitBtn_1 = new JButton("Ok");
		ExitBtn_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				HelpFrame.dispose();
			}
		});
		HelpFrame.getContentPane().add(ExitBtn_1, BorderLayout.SOUTH);
		JLabel InstructionsGuiTitle = new JLabel("INSTRUCTIONS:");
		InstructionsGuiTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		InstructionsGuiTitle.setHorizontalAlignment(SwingConstants.CENTER);
		HelpFrame.getContentPane().add(InstructionsGuiTitle, BorderLayout.NORTH);
//		Displayed text- instructions in html format
		JLabel InstructionGuiLabel = new JLabel("<Html>Hover over to the \"File\" menu on the top left corner and select \"Import\".<br> Import the pokemon database.<br><br><br>Search: Search for a Pokemon by Pokedex number<br>Previous:Previous Pokemon from PokeDex<br>Next: Next Pokemon from the Pokedex</Html>");
		InstructionGuiLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InstructionGuiLabel.setVerticalAlignment(SwingConstants.TOP);
		HelpFrame.getContentPane().add(InstructionGuiLabel, BorderLayout.WEST);
		HelpFrame.setVisible(true);
	}

}
