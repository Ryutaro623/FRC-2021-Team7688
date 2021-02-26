// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LED;

public class ArcadeDrive extends CommandBase {
  private final DriveTrain DT;
  private LED led;
  private final Joystick joystick = new Joystick(0);
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(DriveTrain DTD,LED lll) {
    led = lll;
    DT = DTD;
    addRequirements(DTD);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DT.Drive(joystick.getY(), joystick.getX());
    double color = joystick.getY()*255;
    int kk = (int) color;
    led.Speed(kk);


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
