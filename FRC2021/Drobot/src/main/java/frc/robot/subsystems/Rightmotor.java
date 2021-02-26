// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Rightmotor extends SubsystemBase {
  private final VictorSPX FRTmotor = new VictorSPX(Constants.RIGHT_FRONT_TOP_MOTOR_PORT);
  private final VictorSPX FRBmotor = new VictorSPX(Constants.RIGHT_FRONT_BOTTOM_MOTOR_PORT);
  private final VictorSPX BRTmotor = new VictorSPX(Constants.RIGHT_BACK_TOP_MOTOR_PORT);

  private final TalonSRX BRBmotor = new TalonSRX(Constants.RIGHT_BACK_BOTTOM_MOTOR_PORT);
  /** Creates a new Rightmotor. */
  public Rightmotor() {}

  public void Drive(double speed){
    BRBmotor.set(ControlMode.PercentOutput, speed);
    FRBmotor.follow(BRBmotor);
    BRTmotor.follow(BRBmotor);
    FRTmotor.follow(BRBmotor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
