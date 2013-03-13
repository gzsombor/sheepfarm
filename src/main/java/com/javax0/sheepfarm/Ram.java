package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.AbstractFarmException;
import com.javax0.sheepfarm.exceptions.TotalFailureException;

public class Ram extends SheepBehaviour {
	Ram(Sheep sheep) {
		super(sheep);
	}

	public void neutrize() throws AbstractFarmException {
		synchronized (sheep) {
			changeBehaviour(new Wether(sheep));
		}
	}

	public void copulate(Sheep sheep)
			throws AbstractFarmException {

		if (sheep.getBehaviour() instanceof AbstractFemaleSheep) {
			AbstractFemaleSheep f = (AbstractFemaleSheep) sheep.getBehaviour();
			// see
			// http://socyberty.com/sexuality/volume-of-semen-ejaculated-at-once-by-various-species-of-animals/
			getSheep().looseWeight(1e-3);
			synchronized (sheep) {
				f.fertilize();
			}
		} else {
			throw new TotalFailureException();
		}
	}
}
