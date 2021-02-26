// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rightmotor extends SubsystemBase {
  public TalonSRX motor3 = new TalonSRX(3);
  public TalonSRX motor4 = new TalonSRX(4);
  /** Creates a new Rightmotor. */
  public Rightmotor() {}

  public void Drive(double speed){
    motor3.set(ControlMode.PercentOutput, speed);
    motor4.set(ControlMode.PercentOutput,speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
