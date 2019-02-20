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
import frc.robot.OI;



/**
 * Add your docs here.
 */
public class Harvester extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_VictorSPX HarvesterLeft = null;
  WPI_VictorSPX HarvesterRight = null;

  public Harvester() {
    // Initialize harvesters.
    HarvesterLeft = new WPI_VictorSPX(RobotMap.HARVESTER_LEFT_ID);
    HarvesterRight = new WPI_VictorSPX(RobotMap.HARVESTER_RIGHT_ID);  
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void move(boolean reversed, double speed) {
    if (!reversed) {
      HarvesterLeft.set(ControlMode.PercentOutput, speed); // Magic number for speed limiting. Ideally 1.
      HarvesterRight.set(ControlMode.PercentOutput, speed);
    } else {
      HarvesterLeft.set(ControlMode.PercentOutput, -1 * speed);
      HarvesterRight.set(ControlMode.PercentOutput, -1 * speed);
    }
  }

  public void stopMove() { // Kill motors.
    HarvesterLeft.set(ControlMode.PercentOutput, 0);
    HarvesterRight.set(ControlMode.PercentOutput, 0);
  }
}
