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
  public static final double DRIVETRAIN_SPEED_MODIFIER = 0.75;
  public static final double DRIVETRAIN_SPEEDBOOST_MODIFIER = 0.5;

  // Motor definitions.
  public static int DRIVETRAIN_LEFT_FRONT_ID = 10;
  public static int DRIVETRAIN_LEFT_BACK_ID = 11;
  public static int DRIVETRAIN_RIGHT_FRONT_ID = 20;
  public static int DRIVETRAIN_RIGHT_BACK_ID = 21;

  // Definitions for Driver Station-related stuff.
  public static int OI_DRIVERSTATION_CONTROLLER = 0;
  // Joystick axes.
  public static int OI_MOVE_AXIS = 1; // LS
  public static int OI_ROTATE_AXIS = 0; // LS

  public static int OI_ELEVATORUP_AXIS = 3; // RT
  public static int OI_ELEVATORDOWN_AXIS = 2; // LT

  public static int OI_ARM_AXIS = 5; // RS

  public static int OI_SPEEDBOOST_BUTTON = 5; // RB

  public static int OI_HARVESTER_POS_BUTTON = 1; // A
  public static int OI_HARVESTER_NEG_BUTTON = 2; // B
  public static int OI_HARVESTER_HATCH_POS_BUTTON = 3; // X
  public static int OI_HARVESTER_HATCH_NEG_BUTTON = 4; // Y

  // Elevator definitions.
  public static int ELEVATOR_MAIN_ID = 30;

  // Arm definitions.
  public static int ARM_MAIN_ID = 40;

  // Harvester definitions.
  public static int HARVESTER_LEFT_ID = 43;
  public static int HARVESTER_RIGHT_ID = 44;


  // Limit switch definitions.
  public static int DIO_ARM_LOWLIMIT_CHANNEL = 0;
  public static int DIO_ARM_HIGHLIMIT_CHANNEL = 1;
  
  public static int DIO_ELEVATOR_LOWLIMIT_CHANNEL = 2;
  public static int DIO_ELEVATOR_HIGHLIMIT_CHANNEL = 3;

  // Global speed modifier.
  public static double SUBSYSTEMS_GLOBAL_SPEED_MODIFIER = 0.75;
}
