// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Motorsh2 extends SubsystemBase {
  private VictorSPX motorsh2 = new VictorSPX(5);
  /** Creates a new Motorsh2. */
  public Motorsh2() {}
  public void Drive(double spead){
    motorsh2.set(ControlMode.PercentOutput, spead);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
