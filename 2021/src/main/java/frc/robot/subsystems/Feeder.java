// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {

  private final VictorSPX feeder = new VictorSPX(Constants.FEEDER_CHANNEL);

  /** Creates a new Feeder. */
  public Feeder() {
    feeder.configOpenloopRamp(Constants.FEEDER_RAMP);
  }

  public void Feed(){
    feeder.set(ControlMode.PercentOutput, Constants.FEEDER_SPEED);
  }

  public void Stop(){
    feeder.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
