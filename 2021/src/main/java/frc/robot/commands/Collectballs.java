// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Collector;

public class Collectballs extends CommandBase {
  /** Creates a new Collectballs. */
  private final Collector c;
  public Collectballs(Collector cc) {
    c = cc;
    addRequirements(c);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    c.set_ramp_up_time(Constants.COLLECTOR_RAMP_UP);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    c.collect_ball(Constants.COLLECTOR_MOTOR_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
