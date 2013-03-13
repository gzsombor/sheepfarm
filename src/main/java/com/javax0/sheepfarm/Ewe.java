package com.javax0.sheepfarm;

public class Ewe extends AbstractFemaleSheep {

	Ewe(Sheep sheep) {
		super(sheep);
	}

	
	@Override
	public void fertilize() {
		Dam d = new Dam(sheep);
		changeBehaviour(d);
		d.growUdders();
	}
}
