// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Leftmotor extends SubsystemBase {
  private final VictorSPX FLTmotor = new VictorSPX(Constants.LEFT_FRONT_TOP_MOTOR_PORT);
  private final VictorSPX FLBmotor = new VictorSPX(Constants.LEFT_FRONT_BOTTOM_MOTOR_PORT);
  private final VictorSPX BLTmotor = new VictorSPX(Constants.LEFT_BACK_TOP_MOTOR_PORT);
  
  private final TalonSRX BLBmotor = new TalonSRX(Constants.LEFT_BACK_BOTTOM_MOTOR_PORT);
  /** Creates a new Leftmotor. */
  public Leftmotor() {}

  public void Drive(double sp){
    BLBmotor.set(ControlMode.PercentOutput, -sp);
    FLBmotor.follow(BLBmotor);
    BLTmotor.follow(BLBmotor);
    FLTmotor.follow(BLBmotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
