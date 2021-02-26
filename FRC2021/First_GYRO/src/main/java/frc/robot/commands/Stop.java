// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.L_Motor;
import frc.robot.subsystems.R_motor;

public class Stop extends CommandBase {
  /** Creates a new Stop. */
  private L_Motor l;
  private R_motor r;
  public Stop(L_Motor ll,R_motor rr) {
    l = ll;
    r = rr;
    addRequirements(ll);
    addRequirements(rr);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    l.Drive(0);
    r.Drive(0);
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
