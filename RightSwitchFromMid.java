package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchFromMid extends CommandGroup {

    public RightSwitchFromMid() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
    	
    	
    	
    	
    	
    	
    	//      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	//addSequential(new AutonDrive(.3,80,1));
    	addSequential(new DriveTurn(100,.5,false));
    	addSequential(new DriveForward(-.5,.25,false,false));
    	addSequential(new DriveTurn(-100,.5,true));
    	addSequential(new DriveForward(-.25,1,true,false));
    	addSequential(new DriveForward(0,1,true,true)); //added .05 time
    	addSequential(new ShootSwitch());
    	
    	
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
