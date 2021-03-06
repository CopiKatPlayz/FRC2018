package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DartDown extends Command {

	//Hint: there's almost nothing in this class
	
    public DartDown() {
    	requires(Robot.dart);
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dart.dartsDown();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return((Robot.dart.getPot()>=98));
    
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dart.dartsStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
