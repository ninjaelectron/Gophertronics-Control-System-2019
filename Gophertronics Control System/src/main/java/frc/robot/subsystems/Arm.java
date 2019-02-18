/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * Add your docs here.
 */

public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_VictorSPX ArmSPX = null;
  DigitalInput ArmLowerLimit = null;
  DigitalInput ArmUpperLimit = null;

  public Arm() {
    this.ArmSPX = new WPI_VictorSPX(RobotMap.ARM_MAIN_ID); // Device ID 40.
    this.ArmLowerLimit = new DigitalInput(RobotMap.DIO_ARM_LOWLIMIT_CHANNEL);
    this.ArmUpperLimit = new DigitalInput(RobotMap.DIO_ARM_HIGHLIMIT_CHANNEL);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Armavate());
  }

  public void move(double moveSpeed) {
    if (this.ArmLowerLimit.get()) {
      moveSpeed = Math.max(moveSpeed, 0); // Only output positive (up movement).
    } else if (this.ArmUpperLimit.get()) {
      moveSpeed = Math.min(moveSpeed, 0); // Only output negative (down movement).
    }
    
    this.ArmSPX.set(ControlMode.PercentOutput, moveSpeed);
  }
}
