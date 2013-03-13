package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.CanNotClipABaldSheepException;
import com.javax0.sheepfarm.exceptions.DoNotMixDifferentlyColoredWoolException;
import com.javax0.sheepfarm.exceptions.PackIsFullException;

public class Sheep implements DomesticatedAnimal {
	private double weight;
	private Herd<Sheep> herd;
	private Wool wool = new Wool();
	private Mouth mouth = new Mouth();
	private SheepBehaviour behaviour = new Lamb(this);

	private Gender gender;
	
	public static enum Gender { 
		MALE, FEMALE;
	}
	
	public Sheep(Gender g) {
		this.gender = g; 
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public Mouth getMouth() {
		return mouth;
	}

	public Herd<Sheep> getHerd() {
		return herd;
	}

	public void setHerd(Herd<Sheep> herd) {
		this.herd = herd;
	}

	protected void gainWeight(double amount) {
		weight += amount;
	}

	protected void looseWeight(double amount) {
		weight -= amount;
	}

	protected void cloneTo(Sheep other) {
		other.gender = this.gender;
		other.weight = this.weight;
		other.wool.color = this.wool.color;
		other.wool.length = this.wool.length;
	}

	public class Mouth {
		void feed(double amount) {
			gainWeight(amount);
		}
	}

	public class Wool {
		private static final double WEIGHT_SCALING = 0.022;
		private static final double MINIMAL_WOOL_LENGTH = 0.75;
		private int color;
		private double length;

		public WoolPack clip(WoolPack woolPack)
				throws CanNotClipABaldSheepException, PackIsFullException,
				DoNotMixDifferentlyColoredWoolException {
			if (length < MINIMAL_WOOL_LENGTH) {
				throw new CanNotClipABaldSheepException();
			}
			woolPack.setColor(color);
			double amountToCut = length * weight * WEIGHT_SCALING;
			if (amountToCut > woolPack.getPackSize()) {
				amountToCut = woolPack.getPackSize();
			}
			woolPack.addWool(amountToCut);
			length -= amountToCut / weight / WEIGHT_SCALING;
			return woolPack;
		}
	}

	void changeBehaviour(SheepBehaviour newBehaviour) {
		this.behaviour = newBehaviour;
	}
	
	public SheepBehaviour getBehaviour() {
		return behaviour;
	}
	
}
