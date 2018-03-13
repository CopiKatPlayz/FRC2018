package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleOpDrive extends Command {
	boolean inverted;
    public TeleOpDrive() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.z_oi.Dpad()== 0 ||  Robot.z_oi.Dpad() == 45|| Robot.z_oi.Dpad()== 315)
		{
			inverted = true;

		}
		if(Robot.z_oi.Dpad() == 180 ||  Robot.z_oi.Dpad() == 225|| Robot.z_oi.Dpad() == 135)
		{
			inverted = false;

		}
		if(inverted)
		{
			
			if(Robot.z_oi.driver.getRawAxis(2)>=.9)
	    	{
	    		Robot.drivetrain.tankDrive(Robot.z_oi.rightDrive()*.33,Robot.z_oi.leftDrive()*.33);
	    	}
	    	else
	    	{
	    	Robot.drivetrain.tankDrive(Robot.z_oi.rightDrive(),Robot.z_oi.leftDrive());
	    	}
			
		}
		else
		{
			if(Robot.z_oi.driver.getRawAxis(2)>=.9)
	    	{
				Robot.drivetrain.tankDrive(-Robot.z_oi.leftDrive()*.33,(-Robot.z_oi.rightDrive()*.33));
	    	}
	    	else
	    	{
	    		Robot.drivetrain.tankDrive(-Robot.z_oi.leftDrive(),(-Robot.z_oi.rightDrive()));
	    	}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
 
    	
    }
}
