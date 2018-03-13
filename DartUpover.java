package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DartUpover extends Command {


	int var;
    public DartUpover(int x) 
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

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	return false;
    			
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
