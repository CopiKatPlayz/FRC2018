package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX climber, hook;
	public String alliance ="Blue";
	public Climber(String al)
	{
		alliance=al;
		climber=new TalonSRX(RobotMap.climber);
		hook=new TalonSRX(RobotMap.hook);
	}
	
	public void HookUp()
	{
		hook.set(ControlMode.PercentOutput, -1);
	}
	public void HookDown()
	{
		hook.set(ControlMode.PercentOutput, 1);
	}
	
	public void HookStop()
	{
		hook.set(ControlMode.PercentOutput, 0);
	}
	
	public void ClimbUp(double sped)
	{
		climber.set(ControlMode.PercentOutput,-sped);
	}
	
	public void ClimbStop()
	{
		climber.set(ControlMode.PercentOutput,0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

