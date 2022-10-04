package engime;

import business.Block;

public class Element {
	
	private Block position;
	private double dist;
	private boolean nearest;

	public Element(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}
	public void setPosition(Block position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Element [position=" + position + "]";
	}
	
}
