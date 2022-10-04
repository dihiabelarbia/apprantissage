package IHM;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Grille;
import config.Constente;
import gameBuilder.Manager;
import gameBuilder.Map;

public class DisplayPanel extends JPanel {
	
	private JLabel evolutionLB= new JLabel ("Evolution");
	private JEditorPane displayEvolution = new JEditorPane();
	private Manager manager;
	private JLabel field1 = new JLabel();
	//private Grille grille = Map.buildMap();
	//private Manager manager = Map.buildInitMobile(grille);

	
	public DisplayPanel(Manager manager) {
 
		this.setLayout(new BorderLayout());
		
		field1.setText("" + manager.calculateKNN());
		
		displayEvolution.setEditable(false);
		this.add(field1,BorderLayout.NORTH);
		this.add(field1,BorderLayout.NORTH);

		
		this.add(displayEvolution,BorderLayout.CENTER);	
	}

}
