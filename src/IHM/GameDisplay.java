package IHM;


import business.Grille;
import engime.Agent;
import engime.Bac;
import engime.BacPapier;
import engime.BacVerre;
import engime.Mur;
import engime.Papier;
import engime.Plastic;
import engime.Verre;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import gameBuilder.Manager;

public class GameDisplay extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private Grille map;
	private Manager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Grille map, Manager manager) {
		this.map = map;
		this.manager = manager;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		Agent agent = manager.getAgent();
		paintStrategy.paint(agent, g);
		 
		Bac bac = manager.getBac();
		paintStrategy.paint(bac, g);
		
		ArrayList<Plastic> plastic = manager.getPlastic();
		paintStrategy.paintP(plastic, g);
		
		ArrayList<Verre> verres = manager.getVerre();
		paintStrategy.paintV(verres, g);
		
		ArrayList<Mur> mur = manager.getMur();
		paintStrategy.paint(mur, g);	
		
		BacVerre bacV = manager.getBacV();
		paintStrategy.paintV(bacV, g);
		
		ArrayList<Papier> papiers = manager.getPapiers();
		paintStrategy.paintPa(papiers, g);
		
		BacPapier bacP = manager.getBacP();
		paintStrategy.paintP(bacP, g);
	}
	
}
