/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

import frc.robot.commands.DriveArcade;

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

  /* Sets whether or not arcadeDrive() utilises DRIVETRAIN_SPEED_MODIFIER 
     or DRIVETRAIN_SPEEDBOOST_MODIFIER for motor speed. */
  private boolean isSpeedboost;

  public Drivetrain() {

    // create motor objects. Each MOtor is grouped into a "Drive Group" that is then placed into a "Drive Platform".    
    this.leftFrontSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_ID);
    this.leftBackSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_ID);
    this.leftDriveGroup = new SpeedControllerGroup(leftFrontSPX, leftBackSPX);

    this.rightFrontSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_ID);
    this.rightBackSPX = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_ID);
    this.rightDriveGroup = new SpeedControllerGroup(rightFrontSPX, rightBackSPX);
    
    this.drivePlatform = new DifferentialDrive(rightDriveGroup, leftDriveGroup);

    this.isSpeedboost = false; // False unless speedboost button is depressed.

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveArcade());
  }

  // Sets speed of motor controllers.
  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    if (this.getSpeedboost() == true) { // Checks if the speedboost trigger is enabled.
      System.out.println("no speed");
      this.drivePlatform.arcadeDrive(moveSpeed*RobotMap.DRIVETRAIN_SPEED_MODIFIER,rotateSpeed*RobotMap.DRIVETRAIN_SPEED_MODIFIER);
    }
    else {
      System.out.println("speed");
      this.drivePlatform.arcadeDrive(moveSpeed*RobotMap.DRIVETRAIN_SPEEDBOOST_MODIFIER,rotateSpeed*RobotMap.DRIVETRAIN_SPEEDBOOST_MODIFIER);
    }
  }

  public void setSpeedboost(boolean set) {
    this.isSpeedboost = set;
  }

  public boolean getSpeedboost() {
    return this.isSpeedboost;
  }
}
