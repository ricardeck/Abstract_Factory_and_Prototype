package application;

import java.util.HashMap;

import carroBasico.ChassiBasico;
import carroBasico.MotorBasico;
import carroBasico.PneuBasico;
import carroplus.ChassiPlus;
import carroplus.MotorPlus;
import carroplus.PneuPlus;
import interfaces.IChassi;
import interfaces.IMotor;
import interfaces.IPneu;
import interfaces.IPrototype;

public class MyFactory {
	private MyFactory() {
	}

	public void setCarro(boolean tipo) {
		if(tipo) {
			this.pneu = new PneuBasico();
			this.chassi = new ChassiBasico();
			this.motor = new MotorBasico();
		} else {
			this.pneu = new PneuPlus();
			this.chassi = new ChassiPlus();
			this.motor = new MotorPlus();
		}
	}
	
	public static MyFactory getInstance(int p, int c, int m, boolean tipo) {
		if (factory == null)
			factory = new MyFactory();
		factory.setCarro(tipo);
		factory.addPrototype("Pneu", (IPrototype) factory.pneu, p);
		factory.addPrototype("Chassi", (IPrototype) factory.chassi, c);
		factory.addPrototype("Motor", (IPrototype) factory.motor, m);
		return factory;
	}

	public boolean addPrototype(String prototypeName, IPrototype prototype, int max) {
		if (prototypes.containsKey(prototypeName))
			return false;
		prototypes.put(prototypeName, prototype);
		if(prototypeName.equals("Pneu"))
			prototypeDataPneu = new PrototypeData(prototypes.get(prototypeName), max);
		else if(prototypeName.equals("Chassi"))
			prototypeDataChassi = new PrototypeData(prototypes.get(prototypeName), max);
		else
			prototypeDataMotor = new PrototypeData(prototypes.get(prototypeName), max);

		return true;
	}

	public void getPrototypeData(int pos) {
		if(prototypeDataPneu.prototypes.length>pos)
			System.out.println(prototypeDataPneu.prototypes[pos]);
		if(prototypeDataChassi.prototypes.length>pos)
			System.out.println(prototypeDataChassi.prototypes[pos]);
		if(prototypeDataMotor.prototypes.length>pos)
			System.out.println(prototypeDataMotor.prototypes[pos]);
	}

	public IPrototype createMotor() {
		if (!prototypes.containsKey("Motor"))
			return null;
		if (prototypeDataMotor.prototypes[prototypeDataMotor.current % prototypeDataMotor.max] == null)
			prototypeDataMotor.prototypes[prototypeDataMotor.current % prototypeDataMotor.max] = prototypeDataMotor.prototype.clone();
		return prototypeDataMotor.prototypes[prototypeDataMotor.current++ % prototypeDataMotor.max];
	}

	public IPrototype createChassi() {
		if (!prototypes.containsKey("Chassi"))
			return null;
		if (prototypeDataChassi.prototypes[prototypeDataChassi.current % prototypeDataChassi.max] == null)
			prototypeDataChassi.prototypes[prototypeDataChassi.current % prototypeDataChassi.max] = prototypeDataChassi.prototype.clone();
		return prototypeDataChassi.prototypes[prototypeDataChassi.current++ % prototypeDataChassi.max];
	}

	public IPrototype createPneu() {
		if (!prototypes.containsKey("Pneu"))
			return null;
		if (prototypeDataPneu.prototypes[prototypeDataPneu.current % prototypeDataPneu.max] == null)
			prototypeDataPneu.prototypes[prototypeDataPneu.current % prototypeDataPneu.max] = prototypeDataPneu.prototype.clone();
		return prototypeDataPneu.prototypes[prototypeDataPneu.current++ % prototypeDataPneu.max];
	}

	PrototypeData prototypeDataPneu = null;
	PrototypeData prototypeDataChassi = null;
	PrototypeData prototypeDataMotor = null;
	IPneu pneu;
	IChassi chassi;
	IMotor motor;
	private static MyFactory factory = null;
	private HashMap<String, IPrototype> prototypes = new HashMap<String, IPrototype>();
}
