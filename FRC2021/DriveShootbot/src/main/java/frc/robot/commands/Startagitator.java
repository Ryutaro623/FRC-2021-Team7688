// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Agitator;

public class Startagitator extends CommandBase {
  /** Creates a new Startagitator. */
  private Agitator m_agitator;
  private final Timer TIME = new Timer();
  private double lasttime = 0;
  
  public Startagitator(Agitator m_a) {
    m_a = m_agitator;
    addRequirements(m_a);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    TIME.reset();
    TIME.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(TIME.get()>=(lasttime+Constants.AGITATO_TIME)){
      lasttime = TIME.get();
      m_agitator.Ro(-Constants.DEF_AGITATOR_MOTOR_VALUE);

    } else {
      m_agitator.Ro(Constants.DEF_AGITATOR_MOTOR_VALUE);
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
