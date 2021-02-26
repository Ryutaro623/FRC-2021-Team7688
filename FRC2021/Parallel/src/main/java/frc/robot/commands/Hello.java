// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motor;

public class Hello extends CommandBase {
  private Motor m;
  private final Timer time = new Timer();
  /** Creates a new Hello. */
  public Hello(Motor mn) {
    m = mn;
    addRequirements(mn);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m.Drive(0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m.Drive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (time.get()>2){
      return true;
    } else {
      return false;

    }
    
  }
}
