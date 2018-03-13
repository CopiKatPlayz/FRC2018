/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team219.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
//dart talon 4 - current stuff negate to go up
public class RobotMap {
	public static int driveFrontRightPort= 1;
	public static int driveBackRightPort= 2;
	public static int driveBackLeftPort= 12;
	public static int driveFrontLeftPort= 13;
	
	public static int shooterFrontRight= 3;
	public static int shooterFrontLeft= 11;
	
	public static int shooterMidRight= 4;
	public static int shooterMidLeft= 10;
	
	public static int shooterBackRight= 5;
	public static int shooterBackLeft= 9;
	
	public static int climber = 7;
	public static int hook=14;
	
	public static int dartLeft=8;
	//zach.shutup
	
	//some references
		//40 to 100
		//30 30
		//30 30
		//current spike at 9
}
