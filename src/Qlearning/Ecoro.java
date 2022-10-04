package Qlearning;


import java.util.ArrayList;
import java.util.Random;

import config.Constente;

public class Ecoro {
	private  char[][] map;
	private int[][] R; // Reward lookup
	private double[][] Q; // Q learning
	private char fin;
	public Ecoro(char[][] map,char fin){
		this.map = map;
		this.fin = fin;
		init();
		calculateQ();
		//printQ();
		//printPolicy();
	}
	
    
	public void init() {
		R = new int[Constente.STATESCOUNT][Constente.STATESCOUNT];
		Q = new double[Constente.STATESCOUNT][Constente.STATESCOUNT];

		int i = 0;
		int j = 0;
		
		for (int k = 0; k < Constente.STATESCOUNT; k++) {
			
			//Nous allons naviguer avec i et j ï¿½ travers le labyrinthe, nous avons donc besoin
			// traduire k en i et j
			i = k / Constente.COLUMN_COUNT;
			j = k - i * Constente.COLUMN_COUNT;

			for (int s = 0; s < Constente.STATESCOUNT; s++) {
				R[k][s] = -1;
			}
			
			if (map[i][j] != fin) {

				// Try to move left in the maze
				// 
				int goLeft = j - 1;
				if (goLeft >= 0) {
					int target = i * Constente.COLUMN_COUNT + goLeft;
					if (map[i][goLeft] == 'M') {
						R[k][target] = Constente.PENALTY;
					} else if (map[i][goLeft] == fin) {
						R[k][target] = Constente.REWARD;
					} else if(map[i][goLeft] == '.'){
						R[k][target] = 0;
					}else {
						R[k][target] = Constente.PENALTY;
					}

				}
				// Try to move left in the maze
				int goRight = j + 1;
				if (goRight < Constente.COLUMN_COUNT) {
					int target = i * Constente.COLUMN_COUNT + goRight;
					if (map[i][goRight] == 'M') {
						R[k][target] = Constente.PENALTY;
					} else if (map[i][goRight] == fin) { // recevoir un rewerd
						R[k][target] = Constente.REWARD;
					} else if(map[i][goRight] == '.') {
						R[k][target] = 0;
					}else {
						R[k][target] = Constente.PENALTY;
					}
				}

				int goUp = i - 1;
				if (goUp >= 0) {
					int target = goUp * Constente.COLUMN_COUNT + j;
					if (map[goUp][j] == fin) {
						R[k][target] = Constente.REWARD;
					}  else if (map[goUp][j] == 'M'   ) {
						R[k][target] = Constente.PENALTY;
					} else if (map[goUp][j] == '.'){
						R[k][target] = 0;

					}else {
						R[k][target] = Constente.PENALTY;
					}

				}

				int goDown = i + 1;
				if (goDown < Constente.LINE_COUNT) {
					int target = goDown * Constente.COLUMN_COUNT + j;
					if (map[goDown][j] == fin) {
						R[k][target] = Constente.REWARD;
					} else if (map[goDown][j] == 'M') {
						R[k][target] = Constente.PENALTY;
					} else  if(map[goDown][j] == '.'){
						R[k][target] = 0;
					}else {
						R[k][target] = Constente.PENALTY;
					}
				}

		}
		
        initializeQ();}
        // appelle a la fonction pour initialiser la Q table 
		//printR(R);  // affichage 
		
	}
    // initialisation de la Q table 
     void initializeQ(){
        for (int i = 0; i < Constente.STATESCOUNT; i++){
            for(int j = 0; j < Constente.STATESCOUNT; j++){
                Q[i][j] = (double)R[i][j];
            }
        }
    }
    

	void calculateQ() {
		Random rand = new Random();

		for (int i = 0; i < 1000; i++) { // Train cycle
			// Select random initial state
			int crtState = rand.nextInt(Constente.STATESCOUNT);
			
			

			while (!isFinalState(crtState)) {// on n'est pas a la finale
				 // void la fonction
				int[] actionsFromCurrentState = possibleActionsFromState(crtState);
         
				// Pick a random action from the ones possible
				int index = rand.nextInt(actionsFromCurrentState.length);
				
				//voir la fonction  
				
				int nextState = actionsFromCurrentState[index];
				
				//Q(state,action)= Q(state,action) + alpha * (R(state,action) + gamma *
				//Max(next state, all actions) - Q(state,action))
				double q = Q[crtState][nextState];
				//
				double maxQ = maxQ(nextState);
				int r = R[crtState][nextState];

				double value = q + Constente.ALPHA * (r + Constente.GAMMA * maxQ - q);
				Q[crtState][nextState] = value;

				crtState = nextState;
			}
		}
	}

	boolean isFinalState(int state) {
		int i = state / Constente.COLUMN_COUNT;
		int j = state - i * Constente.COLUMN_COUNT;

		return map[i][j] == fin;
	}

	
	int[] possibleActionsFromState(int state) {
		// Creation d'une Liste  pour que on associï¿½ toutes les ï¿½tats possible et  differents de -1 (par exemple -10/50)   
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < Constente.STATESCOUNT; i++) {
			if (R[state][i] != -1) {
				result.add(i);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	double maxQ(int nextState) {
		int[] actionsFromState = possibleActionsFromState(nextState);
		// the learning rate and eagerness will keep the W value above the lowest reward
		double maxValue = Constente.PENALTY;
		for (int nextAction : actionsFromState) {
			double value = Q[nextState][nextAction];

			if (value > maxValue)
				maxValue = value;
		}
		return maxValue;
	}

	void printPolicy() {
		System.out.println("\n Print policy");
		for (int i = 0; i < Constente.STATESCOUNT; i++) {
			System.out.println("From state " + i + " goto state " + getPolicyFromState(i));
		}
	}

	public int getPolicyFromState(int state) {
		int[] actionsFromState = possibleActionsFromState(state);

		double maxValue = Double.MIN_VALUE;
		int policyGotoState = state;

		// Pick to move to the state that has the maximum Q value
		for (int nextState : actionsFromState) {
			double value = Q[state][nextState];

			if (value > maxValue) {
				maxValue = value;
				policyGotoState = nextState;
			}
		}
		return policyGotoState;
	}
	void printQ() {
		System.out.println("Q matrix");
		for (int i = 0; i < Q.length; i++) {
			System.out.print("From state " + i + ":  ");
			for (int j = 0; j < Q[i].length; j++) {
				System.out.printf("   %6.2f   ", (Q[i][j]));
			}
			System.out.println();
		}
	}
}
