package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightRightScale extends CommandGroup {

    public RightRightScale() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//addSequential( new AutonDrive(.5,13) );
    	///addSequential() DRIVENTURN
    	//addSequential(new ) SHOOTER
    	//addSequential(new DriveTurn(-90,.5,false));
    	addSequential(new DriveTurn(15,.5,false));
    	addParallel(new Shoot(1,1,0));
    	addSequential(new DriveForward(-.5,3.4,false,false));
    	addSequential(new DriveTurn(-75,.5,false));
    	addSequential(new DriveForward(-.5,.05,true,true));
    	addSequential(new DriveForward(0,1,true,true));//testing
    	addSequential(new Shoot(.75,.75,.75));

    	//addSequential(new SideShot(0,0,0,0,0,0));
    	//addSequential(new ShootSwitch());
    }
}
