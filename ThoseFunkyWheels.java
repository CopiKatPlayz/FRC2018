package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ThoseFunkyWheels extends Subsystem {

	public TalonSRX shootFR,shootFL, shootBR, shootBL, shootML, climb, shootMR;
	public DigitalInput limit;
	public String alliance ="Blue";
	
	
	 
	double batteryVol;
	public ThoseFunkyWheels(double bat, String al)
	{
		alliance=al;
		batteryVol = bat;
		limit=new DigitalInput(4);
		climb=new TalonSRX(RobotMap.climber);
		shootFR=new TalonSRX(RobotMap.shooterFrontRight);
		shootFL=new TalonSRX(RobotMap.shooterFrontLeft);
		shootBR=new TalonSRX(RobotMap.shooterBackRight);
		shootBL=new TalonSRX(RobotMap.shooterBackLeft);
		shootML=new TalonSRX(RobotMap.shooterMidLeft);
		shootMR=new TalonSRX(RobotMap.shooterMidRight);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	
	public double getVelocity() //TODO: unknown units atm
	{
		return (shootFR.getSensorCollection().getQuadraturePosition()/4096.0);
	}
	public void resetEncoders()
	{
		//getSensorCollection().setQuadraturePosition(0, 10);
	}

	public void harvestPerp()
	{
		shootFR.set(ControlMode.PercentOutput, -.85);
		shootMR.set(ControlMode.PercentOutput, -.2);
		shootFL.set(ControlMode.PercentOutput, -.45);
		shootML.set(ControlMode.PercentOutput, -.2);
	}
	
	public void harvestRetract()
	{
		shootBR.set(ControlMode.PercentOutput, -.2);
		shootMR.set(ControlMode.PercentOutput, -.5);
		shootBL.set(ControlMode.PercentOutput, .2);
		shootML.set(ControlMode.PercentOutput, -.5);
	}
	
	
	public void varSpeed(double frontSpeed, double midSpeed, double backSpeed)
	{
		shootFL.set(ControlMode.PercentOutput, frontSpeed);
		shootFR.set(ControlMode.PercentOutput, frontSpeed);
		
		shootML.set(ControlMode.PercentOutput, midSpeed);
		shootMR.set(ControlMode.PercentOutput, midSpeed);
		
		shootBL.set(ControlMode.PercentOutput, -backSpeed);
		shootBR.set(ControlMode.PercentOutput, backSpeed);
	}
	

	
	
}

