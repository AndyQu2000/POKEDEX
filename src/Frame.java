import java.io.*;
import java.util.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
//	Current index for pokemon database
	private int currentNo = 1;
	
	HashMap<Integer,String> dex_data = new HashMap<Integer,String>();
	JButton SearchBtn,NextBtn,PreviousBtn;
	JTextField SearchPkmNo;
	JLabel pkmImage,pkmNo,NameLabel,TypeLabel,AbilitiesLabel,AtkLabel,DefLabel,HpLabel,SatkLabel,SdefLabel,SpdLabel,StatsLabel,ErrorLabel;
	JLayeredPane layeredPane;
	private JMenuItem ImportMenu;
	private JMenuItem InstructionsMenu;
	private JMenuItem ExitMenu;
	
//	Updates the current pokedex using values from hash.
//	updated items: Pokemon image, name,type,ability, and stats
	public void updateDex() {
		if(!dex_data.isEmpty()) {
			ImageIcon UpdatedImage = new ImageIcon(getClass().getResource("ImageDatabase/"+currentNo+".png"));
			Image img_up = UpdatedImage.getImage().getScaledInstance(327,338,Image.SCALE_SMOOTH);
			UpdatedImage = new ImageIcon(img_up);
			pkmImage.setIcon(UpdatedImage);
			pkmNo.setText("#" + currentNo);
			String[] str_stat = dex_data.get(currentNo).split(",",9);
			NameLabel.setText("Name: "+ str_stat[0]);
			TypeLabel.setText("Type: "+ str_stat[1]);
			AbilitiesLabel.setText("Abilities: "+ str_stat[2]);
			HpLabel.setText("Hp: "+ str_stat[3]);
			AtkLabel.setText("ATK: "+ str_stat[4]);
			DefLabel.setText("DEF: "+ str_stat[5]);
			SatkLabel.setText("S.ATK: "+ str_stat[6]);
			SdefLabel.setText("S.DEF: "+ str_stat[7]);
			SpdLabel.setText("SPD: "+ str_stat[8]);
		}
		
		
	}
	
	public Frame() {
		setSize(800,650);
		setLocation(0,0);
		setTitle("POKEDEX");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel background;
//		background with pokedex as image. img is used to resize imageicon
		ImageIcon bckgrd = new ImageIcon(this.getClass().getResource("ImageDatabase/dex.jpg"));
		Image img = bckgrd.getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
		bckgrd=new ImageIcon(img);
		background = new JLabel("",bckgrd,JLabel.CENTER);
		background.setBounds(-7, 5, 800, 600);
//		start up image. only displays when the program is started which is then updated to an image of a pokemon when database is imported
		ImageIcon startImage = new ImageIcon(getClass().getResource("ImageDatabase/start.png"));
		Image img_1 = startImage.getImage().getScaledInstance(300,150,Image.SCALE_SMOOTH);
		startImage = new ImageIcon(img_1);
		pkmImage = new JLabel("",startImage,JLabel.CENTER);
		pkmImage.setBounds(24, 159, 327, 338);
		
//		search button
		SearchBtn = new JButton("Search");
		SearchBtn.setBounds(661, 215, 89, 23);
		SearchBtn.addActionListener(this);
//		search text field
		SearchPkmNo = new JTextField();
		SearchPkmNo.setBounds(476, 216, 157, 20);
		SearchPkmNo.setColumns(10);
//		Pokemon number display. Will display start instructions on start up.
		pkmNo = new JLabel("TO START: IMPORT DATABASE");
		pkmNo.setHorizontalAlignment(SwingConstants.CENTER);
		pkmNo.setBounds(476, 272, 274, 23);
//		Pokemon name label
		NameLabel = new JLabel("");
		NameLabel.setBounds(476, 306, 256, 14);
//		Pokemon type label
		TypeLabel = new JLabel("");
		TypeLabel.setBounds(476, 331, 256, 14);
//		Pokemon abilities label
		AbilitiesLabel = new JLabel("");
		AbilitiesLabel.setBounds(476, 356, 256, 14);
//		pokemon attack label
		AtkLabel = new JLabel("");
		AtkLabel.setBounds(476, 458, 119, 14);
//		Stats label- only used as header
		StatsLabel = new JLabel("");
		StatsLabel.setBounds(571, 395, 119, 14);
//		pokemon Defense label
		DefLabel = new JLabel("");
		DefLabel.setBounds(476, 483, 119, 14);
//		pokemon HP/HeathPoints label
		HpLabel = new JLabel("");
		HpLabel.setBounds(476, 430, 114, 14);
//		pokemon Special attack label		
		SatkLabel = new JLabel("");
		SatkLabel.setBounds(600, 458, 130, 14);
//		pokemon special defense label
		SdefLabel = new JLabel("");
		SdefLabel.setBounds(600, 483, 130, 14);
//		pokemon speed label
		SpdLabel = new JLabel("");
		SpdLabel.setBounds(600, 430, 130, 14);
//		Previous button for going back to the pokemon whose number is one less than the current
		PreviousBtn = new JButton("Previous");
		PreviousBtn.setBounds(503, 183, 89, 23);
		PreviousBtn.addActionListener(this);
//		Next button for going back to the pokemon whose number is one greater than the current
		NextBtn = new JButton("Next");
		NextBtn.setBounds(616, 183, 89, 23);
		NextBtn.addActionListener(this);
//		Error label which displays error if user enters wrong credentials in search bar
		ErrorLabel = new JLabel(" ");
		ErrorLabel.setBounds(476, 253, 274, 14);
		
//		Layeredpane is added for overlapping images,buttons,text,text fields on top of the background
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		layeredPane.add(background, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(pkmImage, JLayeredPane.DRAG_LAYER);
		layeredPane.add(SearchBtn, JLayeredPane.DRAG_LAYER);
		layeredPane.add(SearchPkmNo, JLayeredPane.DRAG_LAYER);
		layeredPane.add(pkmNo, JLayeredPane.DRAG_LAYER);
		layeredPane.add(NameLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(TypeLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(AbilitiesLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(StatsLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(AtkLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(DefLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(HpLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(SatkLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(SdefLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(SpdLabel, JLayeredPane.DRAG_LAYER);
		layeredPane.add(PreviousBtn, JLayeredPane.DRAG_LAYER);
		layeredPane.add(NextBtn, JLayeredPane.DRAG_LAYER);
		layeredPane.add(ErrorLabel, JLayeredPane.DRAG_LAYER);
		
		getContentPane().add(layeredPane);

//		Menu bar which includes import,exit, and instructions
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
//		import currently only supports "1GDATABASE.txt" and is the only file it will open
//		If correct file is chosen, information will be set in the hash table used for running the program
//		If incorrect file is chosen, user will be directed to a invalidimportedinput gui which will inform the user to choose the corrret file
		ImportMenu = new JMenuItem("Import");
		ImportMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				JFileChooser file_upload= new JFileChooser();
				int res = file_upload.showOpenDialog(null);
				if(res==JFileChooser.APPROVE_OPTION) {
					File file_path = file_upload.getSelectedFile().getAbsoluteFile();
					String file_path_2 = file_upload.getSelectedFile().getAbsoluteFile().toString();
					if(file_path_2.substring(file_path_2.length()-14).equals("1GDATABASE.txt")) {
						StatsLabel.setText("STATS");
						pkmNo.setText("");
						dex_data.clear();
						currentNo = 0;
						Scanner scan;
						int hTemp = 1;
						
						try {
							scan = new Scanner(file_path);
							while(scan.hasNextLine()) {
								dex_data.put(hTemp++, scan.nextLine());
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
					else {
						InvalidImportInput errorgui = new InvalidImportInput();
					}
				}

			}
		});
		FileMenu.add(ImportMenu);
		
		ExitMenu = new JMenuItem("Exit");
		ExitMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		FileMenu.add(ExitMenu);
		
		JMenu HelpMenu = new JMenu("Help");
		menuBar.add(HelpMenu);
//		opens a new Gui with instructions on how to use the program.
		InstructionsMenu = new JMenuItem("Instructions");	
		InstructionsMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				InstructionsGui insGui = new InstructionsGui();
			}
		});
		HelpMenu.add(InstructionsMenu);
		
		
		layeredPane.setVisible(true);
	}

//	Actions based on the button pressed after uploading database.
	public void actionPerformed(ActionEvent arg0) {
		boolean validNo = false;
//		if search button is pressed and is a valid input, currentNo/current index of pokemon number will be updated to desired number
//		If search button is pressed and is an invalid input, an error will appear which is then cleared after correct input
		if(arg0.getSource()==SearchBtn) {
			ErrorLabel.setText("");
			int temp=0;
			try {
				temp = Integer.parseInt(SearchPkmNo.getText());
			}
			catch(Exception e) {
				ErrorLabel.setText("PLEASE ENTER POKEDEX NUMBERS 1-151!");
			}
			if(temp<1||temp>151)ErrorLabel.setText("PLEASE ENTER POKEDEX NUMBERS 1-151!");
			else {
				validNo = true;
				currentNo = temp;
			}
			
		}
//		increments currentNo by 1
		else if(arg0.getSource() == NextBtn) {
			ErrorLabel.setText("");
			validNo=true;
			if(currentNo==151)currentNo=1;
			else currentNo++;
		}
//		decrease currentNo by1
		else if(arg0.getSource() == PreviousBtn) {
			ErrorLabel.setText("");
			validNo=true;
			if(currentNo==1)currentNo=151;
			else currentNo--;
		}
//		if a valid number is selected from above, the program will continue and update the current information
		if(validNo==true) {
			updateDex();
		}
	}
}
