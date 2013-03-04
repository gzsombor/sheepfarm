package com.javax0.sheepfarm;

public class Lamb extends Sheep {
	public class Mouth extends Sheep.Mouth {
		void feed(double amount, Dam dam) {
			dam.getUdders().feed(Lamb.this, amount);
		}
	}
}
