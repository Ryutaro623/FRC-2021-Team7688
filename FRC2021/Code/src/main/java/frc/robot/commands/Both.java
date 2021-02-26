// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motor;
import frc.robot.subsystems.Motor2;
import edu.wpi.first.wpilibj.Joystick;

public class Both extends CommandBase {
  private final Joystick m_joystick = new Joystick(0);
  private final Motor motor;
  private final Motor2 motorr;
  /** Creates a new Both. */
  public Both(Motor motor11, Motor2 motor22){
    motor = motor11;
    motorr = motor22;
    addRequirements(motor11);
    addRequirements(motor22);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motor.Drive(m_joystick.getY());
    motorr.Drive2(m_joystick.getY());
    
    
    
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
