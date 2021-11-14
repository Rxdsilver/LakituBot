/**
 * @author Hippolyte "Redsilver" BERNARD
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * User interface class
 */
public class LakituGUI implements ActionListener {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    /**
     * Scores column
     */
	public static JLabel score[] = new JLabel[12];
	static JLabel genScore;
	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints c;
	
	private JButton refreshButton;
	
	private String places[] = {"1st  ","2nd  ","3rd  ","4th  ","5th  ","6th  ",
								"7th  ", "8th  ", "9th  ", "10th  ", "11th  ", "12th  "};
	private String maps[] = {"---","MKS", "WP", "SSC","TR","MC","TH","TM","SGF","SA",
								"DS","Ed","MW","CC","BDD","BC","RR","rMMM","rMC",
								"rCCB","rTT","rDDD","rDP3","rRRy","rDKJ","rWS","rSL",
								"rMP","rYV","rTTC","rPPS","rGV","rRRd","dYC","dEA",							
								"dDD","dMC","dWGM","dRR","dIIO","dHC","dBP","dCL","dWW",
								"dAC","dNBC","dRiR","dSBS","dBB"};
	/**
	 * 12x12 table of checkboxes
	 */
	public static JCheckBox chBoxes[][] = new JCheckBox[12][12];
	
	private static JComboBox<String> map1 = new JComboBox<>();
	
	private static JComboBox<String> map2 = new JComboBox<>();
	
	private static JComboBox<String> map3 = new JComboBox<>();
	
	private static JComboBox<String> map4 = new JComboBox<>();
	
	private static JComboBox<String> map5 = new JComboBox<>();
	
	private static JComboBox<String> map6 = new JComboBox<>();
	
	private static JComboBox<String> map7 = new JComboBox<>();
	
	private static JComboBox<String> map8 = new JComboBox<>();
	
	private static JComboBox<String> map9 = new JComboBox<>();
	
	private static JComboBox<String> map10 = new JComboBox<>();
	
	private static JComboBox<String> map11 = new JComboBox<>();
	
	private static JComboBox<String> map12 = new JComboBox<>();
	
	/**
	 * 
	 * @param line number of the map
	 * @return the number of checked boxes
	 */
	public static Integer lineCount(Integer line) {
		Integer count=0;
		for (int i=0; i<12;i++) {
			if (chBoxes[i][line].isSelected()){
				count++;
			}
		}
		return count;
	}	
	/**
	 * Create interface
	 */
	public LakituGUI() {
		
		War.initScores();
		
		frame = new JFrame();
		
		refreshButton = new JButton("Refresh");
		genScore = new JLabel("0-0 (0)");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		panel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets= new Insets(5,20,0,0);
		c.gridx = 14;
		c.gridy = 13;
		panel.add(refreshButton,c);
		c.gridx = 6;
		panel.add(genScore,c);
		
		
		for (int i = 0; i< 12; i++) {
			labelCreator(i);
		}
		for (int j = 0; j < 12; j++) {
			for (int i = 0; i< 12; i++) {
				checkBoxCreator(i,j);
			}
		}
		
		map1 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 0;
		panel.add(map1,c);
		
		map2 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 1;
		panel.add(map2,c);
		
		map3 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 2;
		panel.add(map3,c);
		
		map4 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 3;
		panel.add(map4,c);
		
		map5 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 4;
		panel.add(map5,c);
		
		map6 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 5;
		panel.add(map6,c);
		
		map7 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 6;
		panel.add(map7,c);
		
		map8 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 7;
		panel.add(map8,c);
		
		map9 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 8;
		panel.add(map9,c);
		
		map10 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 9;
		panel.add(map10,c);
		
		map11 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 10;
		panel.add(map11,c);
		
		map12 = new JComboBox<>(maps);
		c.gridx = 13;
		c.gridy = 11;
		panel.add(map12,c);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Lakitu Bot");
		frame.pack();
		frame.setVisible(true);
		
		refreshButton.addActionListener(this);
		
	}
	/**
	 * Create checkbox at precise coordinates
	 * @param i (x-location)
	 * @param j (y-location)
	 */
	public void checkBoxCreator(int i, int j) {
		chBoxes[i][j] = new JCheckBox(places[i]);
		c.gridx = i;
	    c.gridy = j;
		panel.add(chBoxes[i][j],c);
	}
	/**
	 * Create labels to display score of each maps
	 * @param i (y-location)
	 */
	public void labelCreator(int i) {
		score[i] = new JLabel();
		c.gridx = 14;
		c.gridy = i;
		panel.add(score[i],c);
		score[i].setText("---");
	}
	
	/**
	 * 
	 * @param mapNumber number of the map
	 * @return your team score this map
	 */
	public static Integer checkMapScore(Integer mapNumber) {
		Integer count = 0;
		if (chBoxes[0][mapNumber].isSelected()) {
			count+=15;
		}
		if (chBoxes[1][mapNumber].isSelected()) {
			count+=12;
		}
		if (chBoxes[2][mapNumber].isSelected()) {
			count+=10;
		}
		if (chBoxes[3][mapNumber].isSelected()) {
			count+=9;
		}
		if (chBoxes[4][mapNumber].isSelected()) {
			count+=8;
		}
		if (chBoxes[5][mapNumber].isSelected()) {
			count+=7;
		}
		if (chBoxes[6][mapNumber].isSelected()) {
			count+=6;
		}
		if (chBoxes[7][mapNumber].isSelected()) {
			count+=5;
		}
		if (chBoxes[8][mapNumber].isSelected()) {
			count+=4;
		}
		if (chBoxes[9][mapNumber].isSelected()) {
			count+=3;
		}
		if (chBoxes[10][mapNumber].isSelected()) {
			count+=2;
		}
		if (chBoxes[11][mapNumber].isSelected()) {
			count+=1;
		}
		
		return count;
	}
	
	/**
	 * Set scores when Refresh button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		War.setScores();
	}
}
