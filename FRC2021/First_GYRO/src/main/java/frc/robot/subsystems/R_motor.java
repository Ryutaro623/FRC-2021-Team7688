// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class R_motor extends SubsystemBase {
  private final TalonSRX motor3 = new TalonSRX(3);
  private final TalonSRX motor4 = new TalonSRX(4);
  /** Creates a new R_motor. */
  public R_motor() {}

  public void Drive(double sp){
    motor3.set(ControlMode.PercentOutput, sp);
    motor4.set(ControlMode.PercentOutput, sp);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
