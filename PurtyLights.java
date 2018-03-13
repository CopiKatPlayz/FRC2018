package org.usfirst.frc.team219.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PurtyLights extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark blinkyBoi;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	blinkyBoi= new Spark(3);
    }
    public void Smarty(double value)
    {
    	blinkyBoi.set(value);
    }
    
    public void Confetti()
    {
    	blinkyBoi.set(-.87);
    }
    public void BlueViolet()
    {
    	blinkyBoi.set(.89);
    }
    public void RainForest()
    {
    	blinkyBoi.set(-.91);
    }
    public void Fire()
    {
    	blinkyBoi.set(-.57);
    }
    public void BlueChase()
    {
    	blinkyBoi.set(-.29);
    }
    public void Rainbow()
    {
    	blinkyBoi.set(-.99);
    }
    public void LavaWave()
    {
    	blinkyBoi.set(-.39);
    }
    public void OceanWave()
    {
    	blinkyBoi.set(-.41);
    }
    public void DarkBlue()
    {
    	blinkyBoi.set(.85);
    }
    public void BlueStrobe() 
    {
    	blinkyBoi.set(-.09);
    }
    public void RedStrobe()
    {
    	blinkyBoi.set(-.11);
    }
    public void OceanTwinkle()
    {
    	blinkyBoi.set(-.51);
    }
    public void RainGlitter()
    {
    	blinkyBoi.set(-.89);
    }
    public void BPMOcean()
    {
    	blinkyBoi.set(-.65);
    }
    public void BPMLava()
    {
    	blinkyBoi.set(-.63);
    }
    public void BreathFast()
    {
    	blinkyBoi.set(.31);
    }
    public void Sparkle()
    {
    	blinkyBoi.set(.37);
    }
    public void HotPink()
    {
    	blinkyBoi.set(.57);
    }
    public void Aqua()
    {
    	blinkyBoi.set(.81);
    }
    public void Sineparty()
    {
    	blinkyBoi.set(-.77);
    }
    public void GoldStrobe()
    {
    	blinkyBoi.set(-.07);
    }
}

