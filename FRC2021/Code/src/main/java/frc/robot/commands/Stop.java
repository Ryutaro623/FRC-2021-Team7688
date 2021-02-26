// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motor;
import frc.robot.subsystems.Motor2;

public class Stop extends CommandBase {
  private final Motor motor;
  private final Motor2 motor2;
  /** Creates a new Stop. */
  public Stop(Motor motor111, Motor2 motor222){
    motor = motor111;
    motor2 = motor222;
    addRequirements(motor111);
    addRequirements(motor222);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    motor.Drive(0);
    motor2.Drive2(0);
    

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
