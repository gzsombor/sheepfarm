package com.javax0.sheepfarm;

import java.util.HashSet;
import java.util.Set;

import com.javax0.sheepfarm.exceptions.AbstractFarmException;
import com.javax0.sheepfarm.exceptions.CantReplaceSheepException;

public class Herd<AnimalType extends DomesticatedAnimal> {
	private final Set<AnimalType> individuals = new HashSet<AnimalType>();

	public synchronized void add(AnimalType animal) {
		individuals.add(animal);
	}

	public synchronized void remove(AnimalType animal) {
		individuals.remove(animal);
	}

	public class Replacer {
		private AnimalType animalToReplace;

		Replacer(AnimalType animal) {
			animalToReplace = animal;
		}

		public void to(AnimalType animal) throws AbstractFarmException {
			synchronized (Herd.this) {
				if (!individuals.contains(animalToReplace)
						|| individuals.contains(animal)) {
					throw new CantReplaceSheepException();
				}
				remove(animalToReplace);
				add(animal);
			}
		}
	}

	public Replacer replace(AnimalType animal) {
		return new Replacer(animal);
	}
}
