// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Motord extends SubsystemBase {
  private VictorSPX motor1 = new VictorSPX(6);
  /** Creates a new Motord. */
  public Motord() {}
  public void Drive(double spead){
    motor1.set(ControlMode.PercentOutput, spead);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
