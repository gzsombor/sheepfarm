package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.AbstractFarmException;
import com.javax0.sheepfarm.exceptions.TotalFailureException;

public class Wether extends Ram {
	private final Penis penis = new Penis();

	public MaleGenitalia getPenis() {
		return penis;
	}

	public class Testicle extends Ram.Testicle {
		public void neutrize() throws AbstractFarmException {
			throw new TotalFailureException();
		}
	}

	public class Penis extends Ram.Penis {
		public void pee(double amount) {
			looseWeight(amount);
		}

		public void copulate(AbstractFemaleSheep ewe)
				throws AbstractFarmException {
			throw new TotalFailureException();
		}
	}
}
