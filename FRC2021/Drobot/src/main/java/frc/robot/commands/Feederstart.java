// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;

public class Feederstart extends CommandBase {
  private Feeder fd;
  private final Timer t = new Timer();
  
  /** Creates a new Feederstart. */
  public Feederstart(Feeder feed1) {
    fd = feed1;
    addRequirements(fd);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    fd.Settime(Constants.RAMP_UP_TIME);
    t.reset();
    t.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    fd.Drive(Constants.DEF_FEEDER_VALUE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    fd.Settime(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(t.get()>Constants.RAMP_UP_TIME){
      return true;

    } else {
      return false;
    }
    
  }
}
