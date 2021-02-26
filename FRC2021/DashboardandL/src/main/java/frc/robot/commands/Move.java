// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Stm;

public class Move extends CommandBase {
  private final Timer time = new Timer();
  private Stm m;
  /** Creates a new Move. */
  public Move(Stm mm) {
    m = mm;
    addRequirements(mm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    time.reset();
    time.start();
    m.ramp(Constants.PRAMP_UP_TIME);
    m.Drive(Constants.DEF_PUSH_MOTOR_VALUE);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    time.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(time.get()>Constants.PRAMP_UP_TIME){
      return true;
    } else {
      return false;
    }
   

    
  }
}
