package KNN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import engime.Dechet;
import engime.Papier;
import engime.Plastic;
import engime.Verre;
import gameBuilder.Manager;
	
public class Knn_implement {
	private Manager manager;
	private Papier papier;
	private Verre verre;
	private Plastic plastic;
    public ArrayList<Dechet>  calculateKNN()  {  
    	int px = manager.getAgent().getPosition().getLine();
    	int py = manager.getAgent().getPosition().getColumn();
    	ArrayList<Dechet> listeAll = new ArrayList<Dechet>();
    	listeAll.addAll(manager.getPlastic());
    	listeAll.addAll(manager.getVerre());
    	listeAll.addAll(manager.getPapiers());
    	int nbObject = listeAll.size();
    	int K = 2; 
    	
    	ArrayList<Dechet> nearest = new ArrayList<Dechet>();
        for(int a = 0; a < K; a++){
            double shortestDist = 999999.9;
            int n = 0;
            for(int j = 0; j < nbObject; j++){
                    listeAll.get(j).setDist( distance(listeAll.get(j).getPosition().getLine(), px, 
                    		listeAll.get(j).getPosition().getColumn(), py));
                    if(listeAll.get(j).getDist() < shortestDist){
                        shortestDist = listeAll.get(j).getDist();     
                        nearest.add(listeAll.get(j));
                        n = j;
                    }
                }
       		}
        System.out.println(nearest.contains(papier));
   	return nearest;
    }
       
      public Dechet getMax() {
      	Dechet near = null;
	   int nbPlastic = 0;
	   int nbPapier = 0;
	   int nbVerre = 0;
       for (Dechet ner : calculateKNN()) {
    	   if (ner.getClass().equals(papier)) {
    		   nbPapier += 1;
    	   }
    	   if (ner.getClass().equals(plastic)) {
    		   nbPlastic += 1;
    	   }
    	   if (ner.getClass().equals(verre)) {
    		   nbVerre += 1;
    	   }
       }
       List<Integer> liste = new LinkedList<Integer>();
       liste.add(nbPapier);
       liste.add(nbPlastic);
       liste.add(nbVerre);
       if (Collections.max(liste)==nbVerre) {
    	  near = verre; 
       }
       if (Collections.max(liste)==nbPapier) {
    	  near = papier; 
       }
       if (Collections.max(liste)==nbPlastic) {
    	  near = plastic; 
       }
       System.out.println(near.toString());
	return near; 
	
       }

        
    
    public double distance(int x1, int x2, int y1, int y2){   
        double d;
        d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); 
        return d;
    }
}
