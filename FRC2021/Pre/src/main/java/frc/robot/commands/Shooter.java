// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motord;
import frc.robot.subsystems.Motorsh1;
import frc.robot.subsystems.Motorsh2;
import edu.wpi.first.wpilibj.Joystick;

public class Shooter extends CommandBase {
  private Joystick j1;
  private Motorsh1 sh1;
  private Motorsh2 sh2;
  private Motord md;
  /** Creates a new Shooter. */
  public Shooter(Motorsh1 shh, Motorsh2 shh2, Motord mdd) {
    sh1 = shh;
    sh2 = shh2;
    md = mdd;
    addRequirements(shh);
    addRequirements(shh2);
    addRequirements(mdd);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sh1.Drive(j1.getY());
    sh2.Drive(j1.getY());
    md.Drive(0.5);
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
