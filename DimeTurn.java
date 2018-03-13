package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DimeTurn extends Command {

	double maxTime;
	double myAngle;
	double percent;
	double speedDiffIn;
	Timer time;
    public DimeTurn(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	myAngle= angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time= new Timer();
    	time.start();
    	percent = Math.abs(myAngle/360);
		speedDiffIn = 135;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
			if (myAngle>0)
			{
				Robot.drivetrain.tankDrive(.5,-.5);
			}
			else
			{
				Robot.drivetrain.tankDrive(-.5,.5);
			}
			
		

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(time.get() < ((213.0*percent)/speedDiffIn))
    	{
        return false;
    	}
    	else
    	{
    	return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
