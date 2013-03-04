package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.AbstractFarmException;

public class Ram extends Sheep {
	private final Penis penis = new Penis();

	public MaleGenitalia getPenis() {
		return penis;
	}

	public class Testicle {
		public void neutrize() throws AbstractFarmException {
			Wether wether = new Wether();
			synchronized (Ram.this) {
				cloneTo(wether);
				getHerd().replace(Ram.this).to(wether);
			}
		}
	}

	public class Penis implements MaleGenitalia {
		public void pee(double amount) {
			looseWeight(amount);
		}

		public void copulate(AbstractFemaleSheep ewe)
				throws AbstractFarmException {
			// see
			// http://socyberty.com/sexuality/volume-of-semen-ejaculated-at-once-by-various-species-of-animals/
			looseWeight(1e-3);
			Dam dam = new Dam();
			synchronized (ewe) {
				ewe.cloneTo(dam);
				dam.growUdders();
				ewe.getHerd().replace(ewe).to(dam);
			}
		}
	}
}
