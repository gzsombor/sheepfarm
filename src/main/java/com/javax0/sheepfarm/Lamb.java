package com.javax0.sheepfarm;

public class Lamb extends SheepBehaviour {
	
	Lamb(Sheep sheep) {
		super(sheep);
	}

	public void feed(double amount, Dam dam) {
		dam.getUdders().feed(this, amount);
	}
	
	@Override
	public void timePass(int month) {
		super.timePass(month);
		if (age > 12) {
			switch (sheep.getGender()) {
			case MALE : changeBehaviour(new Ram(sheep));
			case FEMALE : changeBehaviour(new Ewe(sheep));
			}
		}
	}
	
}
