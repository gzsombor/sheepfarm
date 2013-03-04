package com.javax0.sheepfarm;

import com.javax0.sheepfarm.exceptions.DoNotMixDifferentlyColoredWoolException;
import com.javax0.sheepfarm.exceptions.PackIsFullException;

public class WoolPack {
	private static final double MAX_PACK_SIZE = 100;
	private double woolAmount = 0;

	public void addWool(WoolPack otherPack) throws PackIsFullException {
		final double maxAmount = otherPack.woolAmount;
		final double amount;
		try {
			addWool(maxAmount);
		} catch (PackIsFullException pifu) {
			amount = pifu.getCapacity();
			addWool(amount);
			otherPack.woolAmount -= amount;
		}
	}

	public void addWool(double amountToBeAdded) throws PackIsFullException {
		if (woolAmount > MAX_PACK_SIZE - amountToBeAdded) {
			throw new PackIsFullException(MAX_PACK_SIZE - woolAmount);
		}
		woolAmount += amountToBeAdded;
	}

	private int color;

	private boolean empty = true;

	public void setColor(int color)
			throws DoNotMixDifferentlyColoredWoolException {
		if (!empty && color != this.color) {
			throw new DoNotMixDifferentlyColoredWoolException();

		}
		this.color = color;
	}

	public double getPackSize() {
		return MAX_PACK_SIZE;
	}
}
