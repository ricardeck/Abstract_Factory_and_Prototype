package carroBasico;

import interfaces.IChassi;
import interfaces.IPrototype;

public class ChassiBasico implements IPrototype, IChassi
{
    public ChassiBasico(){
    }
    public IPrototype clone()
    {
        return new ChassiBasico();
    }
}