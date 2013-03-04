package com.javax0.sheepfarm;

public class Dam extends AbstractFemaleSheep {
	private Udders udders = null;

	protected void growUdders() {
		if (udders == null) {
			udders = new Udders();
		}
	}

	protected Udders getUdders() {
		return udders;
	}

	public class Uterus extends AbstractFemaleSheep.Uterus {
		public void deliver() {
			getHerd().add(new Lamb());
		}
	}

	public class Udders {
		public void feed(Lamb lamb, double amount) {
			lamb.gainWeight(amount);
			looseWeight(amount);
		}

		public void milk(double amount) {
			looseWeight(amount);
		}
	}

}
