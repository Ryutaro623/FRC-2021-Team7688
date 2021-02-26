// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  private final VictorSPX feeder = new VictorSPX(Constants.feeder_motor_port);
  /** Creates a new Feeder. */
  public Feeder() {
  }
  public void Drive(){
    feeder.set(ControlMode.PercentOutput, SmartDashboard.getNumber(Constants.FEEDER_MOTOR, Constants.DEF_FEEDER_VALUE)*-1);
  }
  public void Settime(double ramptime){
    feeder.configOpenloopRamp(ramptime);

  }
  public void Stopf() {
    feeder.set(ControlMode.PercentOutput, 0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}