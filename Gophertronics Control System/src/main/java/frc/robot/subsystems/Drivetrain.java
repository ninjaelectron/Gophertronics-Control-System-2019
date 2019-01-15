/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // Motor Controllers.
  WPI_VictorSPX leftFrontSPX = null;
  WPI_VictorSPX leftBackSPX = null;
  WPI_VictorSPX rightFrontSPX = null;
  WPI_VictorSPX rightBackSPX = null;

  // Groupings for Motors.
  SpeedControllerGroup leftDriveGroup = null;
  SpeedControllerGroup rightDriveGroup = null;

  // The Whole DriveTrain.
  DifferentialDrive drivePlatform = null;

  public Drivetrain() {
    // create motor objects.

    leftFrontSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_ID);
    leftBackSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_ID);
    leftDriveGroup = new SpeedControllerGroup(leftFrontSPX, leftBackSPX);

    rightFrontSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_ID);
    rightBackSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_ID);
    rightDriveGroup = new SpeedControllerGroup(rightFrontSPX, rightBackSPX);
    
    drivePlatform = new DifferentialDrive(rightDriveGroup, leftDriveGroup);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    drivePlatform.arcadeDrive(moveSpeed*0.5,rotateSpeed*0.5);
  }
}
