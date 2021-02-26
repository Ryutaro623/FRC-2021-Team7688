// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Stm extends SubsystemBase {
  private final VictorSPX motor = new VictorSPX(Constants.sender_motor_port);
  /** Creates a new Stm. */
  public Stm() {}

  public void Drive(double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }
  public void ramp(double time){
    motor.configOpenloopRamp(time);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
