// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Distance extends SubsystemBase {
  public AnalogInput ultrasonic = new AnalogInput(0);
  /** Creates a new Distance. */
  public Distance() {

  }
  public double getcm(){
    double rawvalue = ultrasonic.getValue();
    double currentDistance = rawvalue*0.125;
    return currentDistance;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
