// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase {
  private final VictorSPX top_motor = new VictorSPX(Constants.TOP_MOTOR_PORT);
  private final VictorSPX bottom_motor = new VictorSPX(Constants.BOTTOM_MOTOR_PORT);
  /** Creates a new Launcher. */
  public Launcher() {
  }
  public void Drive(double speed,double k){
    top_motor.set(ControlMode.PercentOutput, speed);
    bottom_motor.set(ControlMode.PercentOutput, k);


  }
  public void Set_time(double t){
    top_motor.configOpenloopRamp(t);
    bottom_motor.configOpenloopRamp(t);
  }
  public void Stoop(){
    top_motor.set(ControlMode.PercentOutput, 0);
    bottom_motor.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
