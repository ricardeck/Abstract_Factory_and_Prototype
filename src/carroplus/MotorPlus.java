package carroplus;

import interfaces.IMotor;
import interfaces.IPrototype;

public class MotorPlus implements IPrototype, IMotor
{
    public MotorPlus(){
    }
    public IPrototype clone()
    {
        return new MotorPlus();
    }
}