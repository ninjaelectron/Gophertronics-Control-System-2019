/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Elevate extends Command {
  public Elevate() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.m_elevator);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Grab the two axes for triggers, and combine them.
    double elevationSpeed = (Robot.m_oi.driverController.getRawAxis(RobotMap.OI_ELEVATORUP_AXIS) - Robot.m_oi.driverController.getRawAxis(RobotMap.OI_ELEVATORDOWN_AXIS)) * RobotMap.SUBSYSTEMS_GLOBAL_SPEED_MODIFIER;
    Robot.m_elevator.move(elevationSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_elevator.move(0); // Stop moving.
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
