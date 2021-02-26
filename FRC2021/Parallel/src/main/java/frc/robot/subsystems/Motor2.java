// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor2 extends SubsystemBase {
  private final VictorSPX mo = new VictorSPX(5);
  /** Creates a new Motor2. */
  public Motor2() {
  }
  public void Drive(double sp){
    mo.set(ControlMode.PercentOutput, sp);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
