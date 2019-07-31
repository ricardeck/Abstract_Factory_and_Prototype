package application;
public class Main
{
    public static void main(String args[]) {
        MyFactory f = MyFactory.getInstance();
	f.addPrototype("Pneu", 2);
	for (int i = 0; i < 4; i++)
       	    System.out.println(f.create("Pneu"));

System.out.println("-----------------------------------");

	for(int i=0;i<2;i++)
		f.getPrototypeData(i);
    }
}
