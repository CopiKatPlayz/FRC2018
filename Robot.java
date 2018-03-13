/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team219.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team219.robot.commands.LeftLeftScale;
import org.usfirst.frc.team219.robot.commands.LeftLeftSwitch;
import org.usfirst.frc.team219.robot.commands.LeftRightScale;
import org.usfirst.frc.team219.robot.commands.LeftRightSwitch;
import org.usfirst.frc.team219.robot.commands.LeftSwitchFromMid;
import org.usfirst.frc.team219.robot.commands.RightLeftScale;
import org.usfirst.frc.team219.robot.commands.RightLeftSwitch;
import org.usfirst.frc.team219.robot.commands.RightRightScale;
import org.usfirst.frc.team219.robot.commands.RightRightSwitch;
import org.usfirst.frc.team219.robot.commands.RightSwitchFromMid;

import org.usfirst.frc.team219.robot.subsystems.Climber;
import org.usfirst.frc.team219.robot.subsystems.Darts;
import org.usfirst.frc.team219.robot.subsystems.DriveTrain;
import org.usfirst.frc.team219.robot.subsystems.PurtyLights;
import org.usfirst.frc.team219.robot.subsystems.ThoseFunkyWheels;


import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static AHRS imu;
	public static Climber climber;
	public static Darts dart;
	public static DriveTrain drivetrain;
	public static OI z_oi;
	public static PurtyLights lights;
	public static ThoseFunkyWheels squish;
	
	public double volty;
	public String alliance;
	public Command m_autonomousCommand;
	public SendableChooser<Command> m_chooser ;
	public SendableChooser<String> pos_chooser, preference_chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		alliance=DriverStation.getInstance().getAlliance().toString();
		volty=RobotController.getBatteryVoltage();
		climber= new Climber(alliance);
		dart= new Darts(alliance);
		drivetrain = new DriveTrain(volty,alliance);
		lights= new PurtyLights();
		squish= new ThoseFunkyWheels(volty,alliance);
		z_oi = new OI();
		pos_chooser = new SendableChooser<>();
		preference_chooser = new SendableChooser<>();
		
		SmartDashboard.putData("Position", pos_chooser);
		SmartDashboard.putData("Preference", preference_chooser);
		 
		
		SmartDashboard.putNumber("Blink", 0);
		preference_chooser.addDefault("Scale No Matter What", "Yes");
		preference_chooser.addObject("Scale if its on my side, else Switch if it's on my side, else Scale", "Maybe");
		preference_chooser.addObject("Switch No Matter What, except if scale is on my side", "No");
		
		pos_chooser.addDefault("Middle", "Middle");
		pos_chooser.addObject("Left", "Left");
		pos_chooser.addObject("Right", "Right");
		

	
		
		
		CameraServer.getInstance().startAutomaticCapture();
	
		try 
		{
			imu = new AHRS(SerialPort.Port.kMXP,AHRS.SerialDataType.kProcessedData, (byte)50);
			imu.reset();
		} 
		catch (RuntimeException ex ) 
		{
			DriverStation.reportError("`Error instantiating navX MXP:  " + ex.getMessage(), true);
		}

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//if we're in the middle, we do switch no matter what
		if(pos_chooser.getSelected().equals("Middle"))
		{
			if(gameData.charAt(0)== 'R')
			{
				m_autonomousCommand =new RightSwitchFromMid();
				SmartDashboard.putString("Result","RightSwitchfromMid");
			}
			else
			{
				m_autonomousCommand =new LeftSwitchFromMid();
				SmartDashboard.putString("Result","LeftSwitchfromMid");
			}
		}
		else if (pos_chooser.getSelected().equals("Left"))
		{
		
			if(gameData.charAt(1)=='L') //Always do scale if its on your side
			{
				m_autonomousCommand =new LeftLeftScale();
				SmartDashboard.putString("Result","LeftLeftScale");
			}
			// Do scale no matter what is selected
			else if(preference_chooser.getSelected().equalsIgnoreCase("Yes")) 
			{
				m_autonomousCommand =new LeftRightScale();
				SmartDashboard.putString("Result","LeftRightScale");
			}
			//if the switch is on our side and we aren't doing Scale No Matter What, do switch
			else if(gameData.charAt(0)=='L')
			{
				m_autonomousCommand =new LeftLeftSwitch();
				SmartDashboard.putString("Result","LeftLeftSwitch");
			}
			//If the switch is not on our side and we are doing Switch No Matter What, we do switch
			else if(preference_chooser.getSelected().equalsIgnoreCase("No"))
			{
				m_autonomousCommand =new LeftRightSwitch();
				SmartDashboard.putString("Result","LeftRightSwitch"); //Didn't Test
			}
			//This is the maybe case where the switch and scale aren't on our side, default is to do Scale, select Switch 
			//Mo Matter What if you want to do switch in this case
			else
			{
				m_autonomousCommand =new LeftRightScale();
				SmartDashboard.putString("Result","LeftRightScale");
			}
		}
		else
		{
			if(gameData.charAt(1)=='R') //Always do scale if its on your side
			{
				m_autonomousCommand =new RightRightScale();
				SmartDashboard.putString("Result","RightRightScale");
			}
			// Do scale no matter what is selected
			else if(preference_chooser.getSelected().equalsIgnoreCase("Yes")) 
			{
				m_autonomousCommand =new RightLeftScale();
				SmartDashboard.putString("Result","RightLeftScale");
			}
			//if the switch is on our side and we aren't doing Scale No Matter What, do switch
			else if(gameData.charAt(0)=='R')
			{
				m_autonomousCommand =new RightRightSwitch();
				SmartDashboard.putString("Result","RightRightSwitch");
			}
			//If the switch is not on our side and we are doing Switch No Matter What, we do switch
			else if(preference_chooser.getSelected().equalsIgnoreCase("No"))
			{
				m_autonomousCommand =new RightLeftSwitch();
				SmartDashboard.putString("Result","RightLeftSwitch"); //Didn't Test
			}
			//This is the maybe case where the switch and scale aren't on our side, default is to do Scale, select Switch 
			//Mo Matter What if you want to do switch in this case
			else
			{
				m_autonomousCommand =new RightLeftScale();
				SmartDashboard.putString("Result","RightLeftScale");
			}
			
		}
		//m_autonomousCommand = null; // for testing purposes
		if (m_autonomousCommand != null)
		{
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}
		
	/**
	 * This function is called periodically during operator control.
	 */
	//Command tele=new Harvest();
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		lights.Smarty(SmartDashboard.getNumber("Blink",0));
		
		//values so we know what's going on with the linear actuator
		SmartDashboard.putBoolean("Hall",dart.hall.get());
		SmartDashboard.putBoolean("hallEnd", dart.hallEnd.get());
		SmartDashboard.putNumber("pot", dart.getPot());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
