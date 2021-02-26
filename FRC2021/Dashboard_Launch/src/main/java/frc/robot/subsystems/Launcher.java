// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Launcher extends SubsystemBase {
  private final VictorSPX Tmotor = new VictorSPX(Constants.TOP_MOTOR_PORT);
  private final VictorSPX Bmotor= new VictorSPX(Constants.BOTTOM_MOTOR_PORT);

  /** Creates a new Launcher. */
  public Launcher() {
    
  }
  public void Drive(){
      Tmotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber(Constants.TOP_MOTOR, Constants.DEF_TOP_MOTOR_VALUE));
      Bmotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber(Constants.BOTTOM_MOTOR, Constants.DEF_BOTTOM_MOTOR_VALUE));
  
    }
    public void Settime(double ramptime){
      Tmotor.configOpenloopRamp(ramptime);
      Bmotor.configOpenloopRamp(ramptime);
    }
    public void StopM() {
      Tmotor.set(ControlMode.PercentOutput, 0);
      Bmotor.set(ControlMode.PercentOutput, 0);
      
    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
