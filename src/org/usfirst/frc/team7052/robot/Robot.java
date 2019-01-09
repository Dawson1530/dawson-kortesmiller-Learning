/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7052.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	int motor =0;
	int motor2 =1;
	int motor3 =2;
	int motor4 =3;
	SpeedControllerGroup motorControllerleft;
	SpeedControllerGroup motorControllerright;
	Joystick controller;
	Spark firstmotor;
	Spark secondmotor;
	Spark thirdmotor;
	Spark fourthmotor;

	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		firstmotor = new Spark(motor);
		secondmotor = new Spark(motor2);
		thirdmotor = new Spark(motor3);
		fourthmotor = new Spark(motor4);
		motorControllerleft = new SpeedControllerGroup(firstmotor, secondmotor);
		motorControllerright = new SpeedControllerGroup(thirdmotor, fourthmotor);
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
		
		}
	

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	
		}
	

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	
	
	double controls=controller.getRawAxis(1);
	if(controls>0.6 && controls<0.8) {
		motorControllerleft.set(0.5);
		motorControllerright.set(0.5);
	}
	if(controls>0.8) {
		motorControllerleft.set(-0.5);
		motorControllerright.set(-0.5);
	}
	if(controls<-0.6 && controls>-0.8) {
		motorControllerleft.set(-0.5);
		motorControllerright.set(-0.5);
	}
	if(controls<-0.8) {
		motorControllerleft.set(0.5);
		motorControllerright.set(0.5);
	}
	
	double controls2=controller.getRawAxis(0);
	if(controls2>0.6 && controls2<0.8) {
		motorControllerleft.set(0.5);
		motorControllerright.set(-0.5);
	}
	if(controls2>0.8) {
		motorControllerleft.set(-0.5);
		motorControllerright.set(0.5);
	}
	if(controls2<-0.6 && controls2>-0.8) {
		motorControllerleft.set(-0.5);
		motorControllerright.set(0.5);
	}
	if(controls2<-0.8) {
		motorControllerleft.set(0.5);
		motorControllerright.set(-0.5);
	}
	
	
	
	
	/**
	 * This function is called periodically during test mode.
	 */
}
	@Override
	public void testPeriodic() {
	}
}
