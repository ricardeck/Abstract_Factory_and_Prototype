package carroBasico;

import interfaces.IMotor;
import interfaces.IPrototype;

public class MotorBasico implements IPrototype, IMotor
{
    public MotorBasico(){
    }
    public IPrototype clone()
    {
        return new MotorBasico();
    }
}