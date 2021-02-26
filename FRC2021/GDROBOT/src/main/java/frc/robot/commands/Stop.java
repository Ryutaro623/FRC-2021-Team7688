// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Leftmotor;
import frc.robot.subsystems.Rightmotor;

public class Stop extends CommandBase {
  private Leftmotor lff;
  private Rightmotor rmm;
  /** Creates a new Stop. */
  public Stop(Leftmotor lll, Rightmotor rrr) {
    lff = lll;
    rmm = rrr;
    addRequirements(lll);
    addRequirements(rrr);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lff.Drive(0);
    rmm.Drive(0);
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
