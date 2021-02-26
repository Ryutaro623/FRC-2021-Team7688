// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leftmotor extends SubsystemBase {
  public TalonSRX motor1 = new TalonSRX(1);
  public TalonSRX motor2 = new TalonSRX(2);
  /** Creates a new Leftmotor. */
  public Leftmotor() {}

  public void Drive(double spd){
    motor1.set(ControlMode.PercentOutput, -spd);
    motor2.set(ControlMode.PercentOutput,-spd);



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
