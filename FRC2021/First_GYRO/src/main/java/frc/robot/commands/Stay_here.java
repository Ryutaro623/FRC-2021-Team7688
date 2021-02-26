// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.L_Motor;
import frc.robot.subsystems.R_motor;

public class Stay_here extends CommandBase {
  double errorsum = 0;
  double lasaterror = 0;

  private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  private L_Motor lm;
  private R_motor rm;
  /** Creates a new Stay_here. */
  public Stay_here(L_Motor lmm, R_motor rmm) {

    lm = lmm;
    rm = rmm;
    addRequirements(lmm);
    addRequirements(rmm);
    // Use addRequirements() here to declare subsystem dependencies.
  }







  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    errorsum = 0;
    lastTimestamp = Timer.getFPGATimestamp();

  }
  double lastTimestamp = 0;

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = Constants.POINT - gyro.getAngle();
    
    double dt = Timer.getFPGATimestamp()-lastTimestamp;
    errorsum += error*dt;
    double errorRate = (error-lasaterror)/dt;
    

    double outputspeed = error*Constants.KP+errorsum*Constants.KI+errorRate*Constants.KD;
    SmartDashboard.putNumber("Output", outputspeed);
    SmartDashboard.putNumber("GYRO", gyro.getAngle());
    if(outputspeed>0.5){
      outputspeed = 0.4;

    }

    lm.Drive(outputspeed);
    rm.Drive(-outputspeed);
    lastTimestamp = Timer.getFPGATimestamp();
    lasaterror = error;
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
