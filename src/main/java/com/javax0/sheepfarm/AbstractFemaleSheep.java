package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.AbstractFarmException;

public abstract class AbstractFemaleSheep extends SheepBehaviour {
	AbstractFemaleSheep(Sheep sheep) {
		super(sheep);
	}
	
	abstract public void fertilize() throws AbstractFarmException;
}
