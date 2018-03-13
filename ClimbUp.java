package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbUp extends Command {
	Timer time;
    public ClimbUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	time=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lights.Sineparty();
    	Robot.climber.ClimbUp(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lights.Sineparty();
//    	if (time.get()>=.25)
//    	{
//    		Robot.climber.ClimbUp(.5);
//    		if (time.get()>=.5)
//        	{
//    			Robot.climber.ClimbUp(.7);
//    			if (time.get()>=.75)
//    	    	{
//    				Robot.climber.ClimbUp(1);
//    	    	}
//        	}
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.ClimbStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
