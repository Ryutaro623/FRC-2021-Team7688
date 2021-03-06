// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Agitator;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Launcher;

public class LFSTOP extends CommandBase {
  private Launcher lll;
  private Feeder fff;
  private Agitator aggg;
  /** Creates a new LFSTOP. */
  public LFSTOP(Launcher l, Feeder f,Agitator agg) {
    
    lll = l;
    fff = f;
    aggg = agg;
    addRequirements(l);
    addRequirements(f);
    addRequirements(agg);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    fff.Stoooop();
    lll.Stoop();
    aggg.Ro(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
