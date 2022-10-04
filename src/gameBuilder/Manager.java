package gameBuilder;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import IHM.DisplayPanel;
import Qlearning.*;
import business.Block;
import business.Grille;
import config.Constente;
import engime.Agent;
import engime.Bac;
import engime.BacPapier;
import engime.BacVerre;
import engime.Dechet;
import engime.Mur;
import engime.Papier;
import engime.Plastic;
import engime.Verre;


public class Manager {
	
	  
	
	private Agent agent;
	private ArrayList<Mur> murs;
	private ArrayList<Plastic> plastics;
	private ArrayList<Verre> verres;
	private ArrayList<Papier> papiers;
	private Bac bac;
	private BacVerre bacV;
	private BacPapier bacP;
	private Grille grille;
	private boolean size = true;
	
	public ArrayList<Papier> getPapiers() {
		return papiers;
	}
	public void setPapiers(ArrayList<Papier> papiers) {
		this.papiers = papiers;
	}
	
	public boolean isSize() {
		return size;
	}
	public void setSize(boolean size) {
		this.size = size;
	}
    
	public BacPapier getBacP() {
		return bacP;
	}
	public void setBacP(BacPapier bacP) {
		this.bacP = bacP;
	}
	public Bac getBac() {
		return bac;
	}
	public void setBac(Bac bac) {
		this.bac = bac;
	}
	
	public BacVerre getBacV() {
		return bacV;
	}
	public void setBacV(BacVerre bacV) {
		this.bacV = bacV;
	}
	public Manager(Grille grille) {
		this.grille = grille;
	
		
		}
	public Grille getGrille() {
		 return grille;
	}
	public void set(Agent agent) {
		this.agent = agent;
	}
	
	public Agent getAgent() {
		return agent;
	}

	
	public ArrayList<Mur> getMur() {
		return murs;
	}

	public void set(ArrayList<Mur> murs) {
		this.murs = murs;
	}
	
	public ArrayList<Plastic> getPlastic() {
		return plastics;
	}

	public void setPlastic(ArrayList<Plastic> plastics) {
		this.plastics = plastics;
	}
	
	public ArrayList<Verre> getVerre() {
		return verres;
	}

	public void setVerre(ArrayList<Verre> verres) {
		this.verres = verres;
	}
	


	public void move() {
		Block position = agent.getPosition();
		ArrayList<Integer> list = actionR(position.getLine(), position.getColumn());
		Block newPosition = grille.getBlock(list.get(0) , list.get(1));
		agent.setPosition(newPosition);
	}
	
	
	
	public void pickUp() {
		Block position = agent.getPosition();
		for ( int i=0;i<plastics.size();i++ ) {
			if((plastics.get(i).getPosition().getLine() == position.getLine()) && (plastics.get(i).getPosition().getColumn() == position.getColumn())) {
				plastics.remove(i);
			}
			
		}
		for ( int i=0;i<verres.size();i++ ) {
			if((verres.get(i).getPosition().getLine() == position.getLine()) && (verres.get(i).getPosition().getColumn() == position.getColumn())) {
				verres.remove(i);
			}
		}
		for ( int i=0;i<papiers.size();i++ ) {
			if((papiers.get(i).getPosition().getLine() == position.getLine()) && (papiers.get(i).getPosition().getColumn() == position.getColumn())) {
				papiers.remove(i);
			}
		}
		
		
		if(calculateKNN() instanceof Plastic) {
			Ecoro ecoro = new Ecoro(GenererTableau.map2(),'P');
			agent.setEcoro(ecoro);
		}
	
		/*else if(plastics.isEmpty()) {
			Ecoro ecoro = new Ecoro(GenererTableau.map2(),'F');
			agent.setEcoro(ecoro);
			if(bac.getPosition().getLine() == position.getLine() && (bac.getPosition().getColumn() == position.getColumn())) {
			setSize(false);
		}
		}*/
		else if(calculateKNN() instanceof Verre) {
			Ecoro ecoro1 = new Ecoro(GenererTableau.map2(),'V');
			agent.setEcoro(ecoro1);
		}
		/*else if(verres.isEmpty()) {
			Ecoro ecoro1 = new Ecoro(GenererTableau.map2(),'D');
			agent.setEcoro(ecoro1);
			if(bac.getPosition().getLine() == position.getLine() && (bac.getPosition().getColumn() == position.getColumn())) {
			setSize(false);
		}
		}
		else if(papiers.isEmpty()) {
			Ecoro ecoro11 = new Ecoro(GenererTableau.map2(),'T');
			agent.setEcoro(ecoro11);
			if(bac.getPosition().getLine() == position.getLine() && (bac.getPosition().getColumn() == position.getColumn())) {
			setSize(false);
		}*/
			else{
				Ecoro ecoro111 = new Ecoro(GenererTableau.map2(),'S');
				agent.setEcoro(ecoro111);
			}
		}
	
	
	public void nextRound() {
		move();
	    pickUp();		
	}
	
	public ArrayList<Integer> actionR (int x,int y) {
		int stat = agent.getPosition().getColumn() + agent.getPosition().getLine()*Constente.COLUMN_COUNT;
		
		int nextstat = agent.getEcoro().getPolicyFromState(stat);
		int nextX = nextstat/Constente.COLUMN_COUNT;
		int nextY = nextstat - nextX * Constente.COLUMN_COUNT;
	    ArrayList<Integer> xy = new ArrayList<Integer>();
	    xy.add(nextX);
	    xy.add(nextY);	
		return xy ;
	}
	
    public Dechet  calculateKNN()  {  
    	int px = getAgent().getPosition().getLine();
    	int py = getAgent().getPosition().getColumn();
    	ArrayList<Dechet> listeAll = new ArrayList<Dechet>();
    	listeAll.addAll(plastics);
    	listeAll.addAll(verres);
    	listeAll.addAll(papiers);
    	int nbObject = listeAll.size();
    	int K = 2;
    	 
    	Dechet nearest = null;
        for(int a = 0; a < K; a++){
            double shortestDist = 999999.9;
            for(int j = 0; j < nbObject; j++){
                    listeAll.get(j).setDist( distance(listeAll.get(j).getPosition().getLine(), px, 
                    		listeAll.get(j).getPosition().getColumn(), py));
                    if(listeAll.get(j).getDist() < shortestDist){
                        shortestDist = listeAll.get(j).getDist();  
                        nearest = listeAll.get(j);
                    }
                }
       		}
        System.out.println(nearest.getClass());
        //DisplayPanel panel = new DisplayPanel();
        //panel.field1.setText("le dechet le plus procher est" +nearest);
   		return nearest;
    }
     
    public double distance(int x1, int x2, int y1, int y2){   
        double d;
        d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); 
        return d;
    }

}