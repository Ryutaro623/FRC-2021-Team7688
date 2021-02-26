// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motor2;

public class Hello2 extends CommandBase {
  private Motor2 moo;
  private final Timer t = new Timer();
  /** Creates a new Hello2. */
  public Hello2(Motor2 mooo) {
    moo = mooo;
    addRequirements(mooo);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    t.reset();
    t.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    moo.Drive(0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    moo.Drive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(t.get()>2){
      return true;

    } else {
      return false;
    }
    
  }
}
