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
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_VictorSPX elevatorSPX = null;
  DigitalInput ElevatorLowerLimit = null;
  DigitalInput ElevatorUpperLimit = null;

  public Elevator() {

    this.elevatorSPX = new WPI_VictorSPX(RobotMap.ELEVATOR_MAIN_ID);
    this.ElevatorLowerLimit = new DigitalInput(RobotMap.DIO_ELEVATOR_LOWLIMIT_CHANNEL);
    this.ElevatorUpperLimit = new DigitalInput(RobotMap.DIO_ELEVATOR_HIGHLIMIT_CHANNEL);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new Elevate());
  }

  public void move(double moveSpeed) {
    if (this.ElevatorLowerLimit.get()) {
      moveSpeed = Math.max(moveSpeed, 0); // Only output positive (up movement).
    } else if (this.ElevatorUpperLimit.get()) {
      moveSpeed = Math.min(moveSpeed, 0); // Only output negative (down movement).
    }

    this.elevatorSPX.set(ControlMode.PercentOutput, moveSpeed);
  }
}
