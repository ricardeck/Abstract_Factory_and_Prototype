package carroBasico;

import interfaces.IPneu;
import interfaces.IPrototype;

public class PneuBasico implements IPrototype, IPneu
{
    public PneuBasico(){
    }
    public IPrototype clone()
    {
        return new PneuBasico();
    }
}
