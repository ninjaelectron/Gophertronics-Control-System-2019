/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // Drivetrain modifier. Change number to allow for speed-limiting.
  public static final double DRIVETRAIN_SPEED_MODIFIER = 0.5;
  public static final double DRIVETRAIN_SPEEDBOOST_MODIFIER = 1.0;

  // Motor definitions.
  public static int DRIVETRAIN_LEFT_FRONT_ID = 10;
  public static int DRIVETRAIN_LEFT_BACK_ID = 11;
  public static int DRIVETRAIN_RIGHT_FRONT_ID = 20;
  public static int DRIVETRAIN_RIGHT_BACK_ID = 21;

  // Definitions for Driver Station-related stuff.
  public static int OI_DRIVERSTATION_CONTROLLER = 0;
  // Joystick axes.
  public static int OI_MOVE_AXIS = 1;
  public static int OI_ROTATE_AXIS = 0;

  // Elevator definitions.
  public static int ELEVATOR_MAIN_ID = 30;
}
