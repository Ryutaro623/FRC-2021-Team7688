// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Motor extends SubsystemBase {
  private final VictorSPX motor = new VictorSPX(5);
  /** Creates a new Motor. */
  public Motor() {}

  public void Drive(){
    motor.set(ControlMode.PercentOutput,SmartDashboard.getNumber("Motor Power", 0));
  }
  public void Rampup(double x) {
    motor.configOpenloopRamp(x);
    
  }
  public void Stop(){
    motor.set(ControlMode.PercentOutput, 0);
  }
  public void Rstop(){
    motor.configOpenloopRamp(0);
  }
  public double get_Motor_power() {
    return motor.getMotorOutputPercent();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
