// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launch extends SubsystemBase {
  private final VictorSPX Tmotor = new VictorSPX(Constants.Top_motor_port);
  private final VictorSPX Bmotor= new VictorSPX(Constants.bottom_motor_port);
  /** Creates a new Launch. */
  public Launch() {}

  public void Drive(double topspeed, double bottomspeed){
    Tmotor.set(ControlMode.PercentOutput, topspeed);
    Bmotor.set(ControlMode.PercentOutput, bottomspeed);

  }
  public void Settime(double ramptime){
    Tmotor.configOpenloopRamp(ramptime);
    Bmotor.configOpenloopRamp(ramptime);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
