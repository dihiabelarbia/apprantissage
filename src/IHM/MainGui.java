package IHM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import business.Grille;
import config.Constente;
import gameBuilder.Manager;
import gameBuilder.Map;

public class MainGui extends JFrame implements Runnable {

	//private static final long serialVersionUID = 1L;

	private Grille map;

	private final static Dimension preferredSize = new Dimension(Constente.WINDOW_WIDTH, Constente.WINDOW_HEIGHT);

	private Manager manager;

	private GameDisplay dashboard;
	
	private ControlPanel controlBoard;
	
	private DisplayPanel displayBoard;
	
	
	public MainGui(String title) {
		super(title);
		init();
	}
	
	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
    

		map = Map.buildMap();
		manager = Map.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		displayBoard= new DisplayPanel(manager);
		
		controlBoard = new ControlPanel();

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		contentPane.add(controlBoard, BorderLayout.SOUTH);
		contentPane.add(displayBoard, BorderLayout.EAST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}
	
	public void run() {
		while (Constente.threadStopped) {
			try {
				Thread.sleep(Constente.SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			manager.nextRound();
			dashboard.repaint();
		}
	}

}
