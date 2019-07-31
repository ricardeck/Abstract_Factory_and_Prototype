package application;

import java.util.HashMap;

import interfaces.IPrototype;
import products.Pneu;

public class MyFactory {
	private MyFactory() {
	}

	public static MyFactory getInstance() {
		if (factory == null)
			factory = new MyFactory();
		return factory;
	}

	public boolean addPrototype(String prototypeName, int max) {
		if (prototypes.containsKey(prototypeName))
			return false;
		prototypes.put(prototypeName, new Pneu());
		prototypeData = new PrototypeData(prototypes.get(prototypeName), max);
		return true;
	}

	public void getPrototypeData(int pos) {
		System.out.println(prototypeData.prototypes[pos]);
	}

	public IPrototype create(String prototypeName) {
		if (!prototypes.containsKey(prototypeName))
			return null;
		if (prototypeData.prototypes[prototypeData.current % prototypeData.max] == null)
			prototypeData.prototypes[prototypeData.current % prototypeData.max] = prototypeData.prototype.clone();
		return prototypeData.prototypes[prototypeData.current++ % prototypeData.max];
	}

	PrototypeData prototypeData = null;
	private static MyFactory factory = null;
	private HashMap<String, IPrototype> prototypes = new HashMap<String, IPrototype>();
}
