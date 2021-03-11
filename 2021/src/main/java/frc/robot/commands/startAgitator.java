// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Agitator;

public class startAgitator extends CommandBase {
  /** Creates a new startAgitator. */
  private Agitator m_agitator;
  private final Timer TIME = new Timer();
  private double lasttime;
  private int change = 1;
  public startAgitator(Agitator m_a) {
    lasttime = 0; 
    TIME.reset();
    TIME.start();
    m_agitator = m_a;
    addRequirements(m_a);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_agitator.Set_Ramp_up_time(Constants.AGITATOR_RAMP_TIME);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(TIME.get()>= lasttime+Constants.AGITATOR_RAMP_TIME){
      lasttime = TIME.get();
      change = change*-1;
      m_agitator.Speed(Constants.AGITATOR_MOTOR_SPEED*change);
    } else {
      m_agitator.Speed(Constants.AGITATOR_MOTOR_SPEED*change);
    }

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
