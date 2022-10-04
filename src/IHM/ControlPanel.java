package IHM;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import config.Constente;

public class ControlPanel extends JPanel {
	
	private JButton  stopBT = new JButton("STOP");
	private JButton startBT = new JButton("START");
	private JButton speedBT = new JButton("+");
	private JButton slowBT = new JButton("-");
	private JLabel speedLB= new JLabel ("Speed");
	
	public ControlPanel() {
		this.setLayout(new FlowLayout());
		speedBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constente.SPEED = Constente.SPEED +10;
			}
	});
		slowBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constente.SPEED = Constente.SPEED -10;
			}
		});
		stopBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constente.threadStopped = false;
			}
	});
			

		//this.add(startBT);
		this.add(stopBT);
		this.add(speedLB);
		this.add(speedBT);
		this.add(slowBT);
	}
}
