// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Motor;

public class Rampupmotor extends CommandBase {
  private final Timer time = new Timer();
  private final Motor motor1;
  /** Creates a new Rampupmotor. */
  public Rampupmotor(Motor motorrr) {
    motor1 = motorrr;

    addRequirements(motorrr);
    // Use addRequirements() here to declare subsystem dependencies.
  }
// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motor1.Rampup(Constants.RUMP_UP_TIME);
    time.reset();
    time.start();



  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motor1.Drive();
    SmartDashboard.putNumber("Now", time.get());
    SmartDashboard.putNumber("Now Power", motor1.get_Motor_power());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motor1.Rampup(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(time.get()>Constants.RUMP_UP_TIME){
      return true;
    } else {
      return false;
    }
  }
}
