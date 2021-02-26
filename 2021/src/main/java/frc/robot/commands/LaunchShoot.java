// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Launcher;

public class LaunchShoot extends CommandBase {
  private final Timer Time = new Timer();
  Launcher m_launcher;
  /** Creates a new shoot. */
  public LaunchShoot(Launcher input_launcher) {
    m_launcher = input_launcher;
    addRequirements(m_launcher);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Time.reset();
    Time.start();
    m_launcher.ChangeRampTime(Constants.LAUNCHER_RAMP_TIME_DEFAULT);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_launcher.Shoot(-0.2, -0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcher.ChangeRampTime(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Time.get()>=Constants.LAUNCHER_RAMP_TIME_DEFAULT){
      return true;

    } else {
      return false;

    }
  }
}
