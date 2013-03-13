package com.javax0.sheepfarm;

import com.javax0.sheepfarm.Sheep.Gender;
import com.javax0.sheepfarm.exceptions.AbstractFarmException;
import com.javax0.sheepfarm.exceptions.SheepAlreadyFertilized;

public class Dam extends AbstractFemaleSheep {
	Dam(Sheep sheep) {
		super(sheep);

	}

	public class Udders {
		public void feed(Lamb lamb, double amount) {
			lamb.getSheep().gainWeight(amount);
			getSheep().looseWeight(amount);
		}

		public void milk(double amount) {
			getSheep().looseWeight(amount);
		}
	}

	private Sheep baby = null;
	private Udders udders = null;

	protected void growUdders() {
		if (udders == null) {
			udders = new Udders();
		}
	}

	protected Udders getUdders() {
		return udders;
	}

	@Override
	public void fertilize() throws AbstractFarmException {
		if (baby == null) {
			baby = new Sheep(Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE);
		} else {
			throw new SheepAlreadyFertilized();
		}
	}

	public void deliver() {
		if (baby != null) {
			getHerd().add(baby);
			baby = null;
		}
	}

}
