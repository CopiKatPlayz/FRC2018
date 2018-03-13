/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team219.robot;

import org.usfirst.frc.team219.robot.commands.ClimbUp;
import org.usfirst.frc.team219.robot.commands.DartDown;
import org.usfirst.frc.team219.robot.commands.DartDownover;
import org.usfirst.frc.team219.robot.commands.DartUp;
import org.usfirst.frc.team219.robot.commands.DartUpover;
import org.usfirst.frc.team219.robot.commands.DelayedShot;
import org.usfirst.frc.team219.robot.commands.Harvest;
import org.usfirst.frc.team219.robot.commands.HarvestRetract;

import org.usfirst.frc.team219.robot.commands.HookDown;
import org.usfirst.frc.team219.robot.commands.HookUp;
import org.usfirst.frc.team219.robot.commands.LowShot;
import org.usfirst.frc.team219.robot.commands.LowerShot;
import org.usfirst.frc.team219.robot.commands.ShootSwitch;
import org.usfirst.frc.team219.robot.commands.ShootSwitchForBabies;
import org.usfirst.frc.team219.robot.commands.SideShot;
import org.usfirst.frc.team219.robot.commands.SwitchPosition;
import org.usfirst.frc.team219.robot.commands.vaultshot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	public Joystick driver, driver2;
	JoystickButton three, four, x, five, six, one, two, eleven, eight, ten, nine,rightBumper,seven,twelve;
	
	public OI()
	{
	
	 driver = new Joystick(0);
	 driver2 = new Joystick(1);
	 
	 x= new JoystickButton(driver, 3);
	 rightBumper=new JoystickButton(driver,6);
	 
	 one= new JoystickButton(driver2, 1);
	 two= new JoystickButton(driver2, 2);
	 three= new JoystickButton(driver2, 3);
	 four= new JoystickButton(driver2, 4);
	 five= new JoystickButton(driver2, 5);
	 six= new JoystickButton(driver2, 6);
	 seven=new JoystickButton(driver2,7);
	 eight= new JoystickButton(driver2, 8);
	 nine= new JoystickButton(driver2, 9);
	 ten= new JoystickButton(driver2, 10);
	 eleven= new JoystickButton(driver2, 11);
	twelve= new JoystickButton(driver2, 12);
	
	x.whileHeld(new ClimbUp());
	 
	 
	one.whileHeld(new DelayedShot());//high shot
	eight.toggleWhenPressed(new LowShot());//medium
	twelve.toggleWhenPressed(new vaultshot());
	eleven.toggleWhenPressed(new ShootSwitchForBabies());
	seven.toggleWhenPressed(new LowerShot());
	
	three.toggleWhenPressed(new DartUp(28));
	four.toggleWhenPressed(new DartDown());
	five.whileHeld(new DartDownover());
	
	rightBumper.toggleWhenPressed(new Harvest());
	six.toggleWhenPressed(new HarvestRetract(28));
	
	nine.whileHeld(new HookUp());
	two.whileHeld(new HookDown());
	
	ten.whileHeld(new DartUpover(3));//change
	
	
	}

	
	public double rightDrive()
	{
		if(Math.abs(driver.getRawAxis(5)) < .1)
			return 0;
			
		return driver.getRawAxis(5);
		//return .5;
	}
	
	
	public double leftDrive()
	{
		if(Math.abs(driver.getRawAxis(1)) < .1)
			return 0;
		return driver.getRawAxis(1);
		//return .5;
	}//safespot40
	
	public int Dpad()
	{
		return Robot.z_oi.driver.getPOV();
	}

}
