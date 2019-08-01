package carroplus;

import interfaces.IPneu;
import interfaces.IPrototype;

public class PneuPlus implements IPrototype, IPneu
{
    public PneuPlus(){
    }
    public IPrototype clone()
    {
        return new PneuPlus();
    }
}
