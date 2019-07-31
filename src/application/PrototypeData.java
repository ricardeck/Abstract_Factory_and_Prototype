package application;

import interfaces.IPrototype;

public class PrototypeData {
	
	public IPrototype prototype;
	public int max;
	public int current;
	public IPrototype[] prototypes;
	
	public PrototypeData(IPrototype prototype, int max) {
		this.prototype = prototype;
		this.max = max;
		this.current = 0;
		this.prototypes = new IPrototype[max];
//		for (int i = 0; i < max; i++)
//			this.prototypes[i] = this.prototype.clone();
	}

}
