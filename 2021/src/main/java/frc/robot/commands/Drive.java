// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LED;

public class Drive extends CommandBase {
  private final Drivetrain drivetrain;
  private LED led;
  private final Joystick joystick = new Joystick(0);

  /** Creates a new Drive. */
  public Drive(Drivetrain dt,LED le) {
    led = le;
    drivetrain = dt;
    addRequirements(drivetrain);
    addRequirements(led);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive(joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_SPEED), joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_ROTATION));
    led.Speed(joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_SPEED));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
