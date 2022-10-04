package engime;

import Qlearning.Ecoro;
import business.Block;
import config.Constente;

public class Agent extends Element {
	private Ecoro ecoro;
	
	public Agent(Block position) {
		super(position);
		ecoro = Constente.ECORO;
	}

	public Ecoro getEcoro() {
		return ecoro;
	}

	public void setEcoro(Ecoro ecoro) {
		this.ecoro = ecoro;
	}
}


