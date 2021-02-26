// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Launcher;

public class Launch extends CommandBase {
  private final Timer timer = new Timer();
  private final Launcher la;
  /** Creates a new Launch. */
  public Launch(Launcher nch) {
    la = nch;
    addRequirements(la);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    la.Set_time(Constants.RAMP_UP_TIME);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    la.Drive(Constants.DEF_TOP_MOTOR_VALUE,Constants.DEF_BOTTOM_MOTOR_VALUE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    la.Set_time(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get()>Constants.RAMP_UP_TIME){
      return true;
    } else {
      return false;
    }
    
  }
}
