package engime;

import business.Block;

public class Dechet extends Element {
	
	private Block position;
	private double dist;
	private boolean nearest;
	
	public Dechet(Block position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Dechet [position=" + position + "]";
	}
	
	public void setDist(double d) {
		this.dist = d;
	}
	public double getDist() {
		return dist;
	}

	public void setNearest(boolean nearest) {
		this.nearest = nearest;
	}
	public boolean getNearest() {
		return nearest;
	}
}
