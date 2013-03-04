package com.javax0.sheepfarm.exceptions;

public class PackIsFullException extends AbstractFarmException {

	public PackIsFullException() {
		super();
	}

	private double capacity = 0;

	public double getCapacity() {
		return capacity;
	}

	public PackIsFullException(double maxAmount) {
		super();
		capacity = maxAmount;
	}

}
