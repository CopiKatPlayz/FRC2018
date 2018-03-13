package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DartUp extends Command {


	int var;
    public DartUp(int x) 
    {
    	
    	requires(Robot.dart);
    	var=x;
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.dart.dartsUp();
    	
    
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((Robot.dart.getPot()<=var+15))
    	{
    		Robot.dart.dartsUpSLow();
    	}
    	SmartDashboard.putString("Done?","no!");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	return(!Robot.dart.hallEnd.get() || (Robot.dart.getPot()<=var));
    			
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dart.dartsStop();
    	SmartDashboard.putString("Done?","Yes!");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
