// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  private final VictorSPX motor = new VictorSPX(6);
  /** Creates a new Motor. */
  public Motor() {}

  public void Drive(double sp){
    motor.set(ControlMode.PercentOutput, sp);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
