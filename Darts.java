package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Darts extends Subsystem  {

    
	public TalonSRX dartL;
	Potentiometer pot;
	AnalogInput ai;
	public Servo lin;
	public String alliance ="Blue";
	public DigitalInput hall;
	public DigitalInput hallEnd;
	
	public Darts(String al)
	{
		alliance=al;
		lin= new Servo(2);
		hall= new DigitalInput(0);
		hallEnd= new DigitalInput(2);
		ai = new AnalogInput(0);
	
		double trueValRange = .946-.51;
		double scale = 100;
		double offset = -.51;
		pot = new AnalogPotentiometer(ai, scale/trueValRange , offset *scale/trueValRange);
		dartL=new TalonSRX(RobotMap.dartLeft);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void dartsUp()
    {
    	dartL.set(ControlMode.PercentOutput, .5);
    }
    
    public void dartsUpSLow()
    {
    	dartL.set(ControlMode.PercentOutput, .3);
    }
    
    public void dartsDownSLow()
    {
    	dartL.set(ControlMode.PercentOutput, -.2);
    }
    
    public void dartsDown()
    {	
    	dartL.set(ControlMode.PercentOutput, -.3);
    
    }
    public void dartsStop()
    {	
    	dartL.set(ControlMode.PercentOutput, 0);
    }
    
    //Jason does this
    public double getPot()
    {
    	return pot.get();
    }
   
}

