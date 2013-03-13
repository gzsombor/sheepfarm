package com.javax0.sheepfarm;

public class SheepBehaviour {
	
	
	/**
	 * 
	 */
	protected final Sheep sheep;
	protected int age;

	/**
	 * @param sheep
	 */
	SheepBehaviour(Sheep sheep) {
		this.sheep = sheep;
	}

	protected void changeBehaviour(SheepBehaviour newBehaviour) {
		this.sheep.changeBehaviour(newBehaviour);
	}
	
	
	public Sheep getSheep() {
		return sheep;
	}
	
	public Herd<Sheep> getHerd() {
		return getSheep().getHerd();
	}
	
	public void pee(double amount) {
		getSheep().looseWeight(amount);
	}

	
	public void timePass(int month) {
		this.age += month;
	}
	
}