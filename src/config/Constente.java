package config;

import Qlearning.Ecoro;
import Qlearning.GenererTableau;

public class Constente {
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 600;
	
	public static final int BLOCK_SIZE = 30;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
    public static final double ALPHA = 0.1;
    public static final double GAMMA = 0.9;

    public static final int STATESCOUNT = LINE_COUNT * COLUMN_COUNT;
    public static boolean threadStopped = true;

    public static final int REWARD = 100;
    public static final int PENALTY = -50;
    public static int SPEED = 1;
    public static final char [][] map = GenererTableau.map();
    public static final Ecoro ECORO = new Ecoro(map,'P');

}
