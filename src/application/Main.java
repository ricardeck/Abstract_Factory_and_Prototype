package application;

import interfaces.IChassi;
import interfaces.IMotor;
import interfaces.IPneu;

public class Main {
	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		MyFactory f = MyFactory.getInstance(4, 3, 2, false);
		
		f.setCarro(false);

		
		IPneu p1 = (IPneu) f.createPneu();
		IChassi c1 = (IChassi) f.createChassi();
		IMotor m1 = (IMotor) f.createMotor();
		IPneu p2 = (IPneu) f.createPneu();
		IChassi c2 = (IChassi) f.createChassi();
		IMotor m2 = (IMotor) f.createMotor();
		IPneu p3 = (IPneu) f.createPneu();
		IChassi c3 = (IChassi) f.createChassi();
		IMotor m3 = (IMotor) f.createMotor();
		
		System.out.println(p1);
		System.out.println(c1);
		System.out.println(m1);

		System.out.println(p2);
		System.out.println(c2);
		System.out.println(m2);
		
		System.out.println(p3);
		System.out.println(c3);
		System.out.println(m3);
		
		for (int i = 0; i < 5; i++) 
			System.out.println(f.createPneu());
		System.out.println("----------------------");
		for (int i = 0; i < 5; i++) 
			System.out.println(f.createChassi());
		System.out.println("----------------------");
		for (int i = 0; i < 5; i++) 
			System.out.println(f.createMotor());
		System.out.println("----------------------");
		
		for (int i = 0; i < 5; i++) 
			f.getPrototypeData(i);
		
	}
}
