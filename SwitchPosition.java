package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchPosition extends Command {

	boolean up =false;
	boolean down =false;
	double value;
    public SwitchPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dart);
    	value =65;
    }
    
    public SwitchPosition(double val) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dart);
    	value =val;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.dart.getPot()>=value+5)
    	{
    		up=true;
    		Robot.dart.dartsUp();
    	}
    	else if(Robot.dart.getPot()<value-5)
    	{
    		down=true;
    		Robot.dart.dartsDown();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//38	
    	if(up)
    	{
    		return(!Robot.dart.hallEnd.get()||Robot.dart.getPot()<=value-2);
    	}
    	else if(down)
    	{
    		return(!Robot.dart.hall.get()||Robot.dart.getPot()>=value+2);
    	}
    	else{
    		return true;
    	}
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
