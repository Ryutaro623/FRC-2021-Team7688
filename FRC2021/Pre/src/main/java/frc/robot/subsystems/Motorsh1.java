// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Motorsh1 extends SubsystemBase {
  private VictorSPX motorsh1 = new VictorSPX(3);
  /** Creates a new Motorsh1. */
  public Motorsh1() {}
  public void Drive(double spead){
    motorsh1.set(ControlMode.PercentOutput, spead);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
