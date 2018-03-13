package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	double sped, counter;
	Timer time;
	boolean lst,slow;
    public DriveForward(double speed, double timeToGo, boolean last, boolean slowdown) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	sped=speed;
    	time=new Timer();
    	counter = timeToGo;
    	
    	lst=last; /* is it the last command? (used for determining whether to set motors to 
    	0 in the end() fuction of the command */
    	
    	slow=slowdown; // should we slow down towards the end?
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.goForward(sped);
    	time.reset();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(time.get()>=counter*.75&&slow)
    	{
    		if(time.get()>=counter*.90&&slow)
        	{
        		Robot.drivetrain.goForward(sped*.25);
        	}
    		else{
    		Robot.drivetrain.goForward(sped*.5);
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(time.get()>=counter)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(lst)
    	{
    		Robot.drivetrain.tankDrive(0, 0);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
