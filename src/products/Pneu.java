package products;

import interfaces.IPrototype;

public class Pneu implements IPrototype
{
    public Pneu(){
    }
    public IPrototype clone()
    {
        return new Pneu();
    }
}
