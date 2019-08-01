package carroplus;

import interfaces.IChassi;
import interfaces.IPrototype;

public class ChassiPlus implements IPrototype, IChassi
{
    public ChassiPlus(){
    }
    public IPrototype clone()
    {
        return new ChassiPlus();
    }
}