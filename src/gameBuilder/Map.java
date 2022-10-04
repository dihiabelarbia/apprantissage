package gameBuilder;

import java.util.ArrayList;

import business.Block;
import business.Grille;
import config.Constente;
import engime.Agent;
import engime.Bac;
import engime.BacPapier;
import engime.BacVerre;
import engime.Mur;
import engime.Papier;
import engime.Plastic;
import engime.Verre;

public class Map {
	public static ArrayList <Mur> murs = new ArrayList<Mur>();
	public static ArrayList <Plastic> plastics = new ArrayList<Plastic>();
	public static ArrayList <Verre> verres = new ArrayList<Verre>();
	public static ArrayList <Papier> papiers = new ArrayList<Papier>();

	
	public static Grille buildMap() {
		return new Grille(Constente.LINE_COUNT, Constente.COLUMN_COUNT);
	}
	
	public static Manager buildInitMobile(Grille grille) {
	Manager manager = new Manager(grille);
		
		intialize(grille, manager);
		return manager;
	}

	private static void intialize(Grille map, Manager manager) {
		Block block = map.getBlock(1, 1);
		Agent agent = new Agent(block);
		manager.set(agent);
		
		block = map.getBlock(Constente.COLUMN_COUNT-2 , Constente.COLUMN_COUNT-2);
		Bac bac = new Bac(block);
		manager.setBac(bac);
		
		block = map.getBlock(Constente.COLUMN_COUNT-2 , Constente.COLUMN_COUNT-3);
		BacVerre bacV = new BacVerre(block);
		manager.setBacV(bacV);
		
		block = map.getBlock(Constente.COLUMN_COUNT-2 , Constente.COLUMN_COUNT-4);
		BacPapier bacP = new BacPapier(block);
		manager.setBacP(bacP);
		
		for (int i=1; i<2; i++) {
			Block block1 = map.getBlock((int) (Math.random() * (Constente.LINE_COUNT)),
					(int) (Math.random() * (Constente.COLUMN_COUNT)));
			Plastic plastic = new Plastic(block1);
			manager.setPlastic(plastics);
			plastics.add(plastic);
		}
		for (int i=1; i<2; i++) {
			Block block1 = map.getBlock((int) (Math.random() * (Constente.LINE_COUNT)),
					(int) (Math.random() * (Constente.COLUMN_COUNT)));
			Verre verre = new Verre(block1);
			manager.setVerre(verres);
			verres.add(verre);
		}
		for (int i=1; i<2; i++) {
			Block block1 = map.getBlock((int) (Math.random() * (Constente.LINE_COUNT)),
					(int) (Math.random() * (Constente.COLUMN_COUNT)));
			Papier papier = new Papier(block1);
			manager.setPapiers(papiers);
			papiers.add(papier);
		}
		for (int i=1; i<6; i++) {
			Block block1 = map.getBlock(Constente.LINE_COUNT - i, (Constente.COLUMN_COUNT - 1) / 2);
			Mur mur = new Mur(block1);
			manager.set(murs);
			murs.add(mur);
		}
		for (int i=1; i<10; i++) {
			Block block2 = map.getBlock((Constente.COLUMN_COUNT - 15) , Constente.LINE_COUNT -i );
			Mur mur = new Mur(block2);
			manager.set(murs);
			murs.add(mur);
		}
	}	
}
