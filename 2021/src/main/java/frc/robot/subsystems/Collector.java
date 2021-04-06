// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  /** Creates a new Collector. */
  private final CANSparkMax cmotor = new CANSparkMax(Constants.COLLECTOR_MOTOR_PORT,MotorType.kBrushless);
  public Collector() {}
  public void set_ramp_up_time(double rate){
    cmotor.setOpenLoopRampRate(rate);
  }

  public void collect_ball(double speed){
    cmotor.set(speed);
  }

  public void backward(double s){
    cmotor.set(s);
  }
  public void stop(){
    cmotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
