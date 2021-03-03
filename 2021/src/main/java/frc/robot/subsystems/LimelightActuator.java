// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimelightActuator extends SubsystemBase {
  private final Servo pitchActuator;
  private final Servo rotationActuator;
  private boolean isRotateMax = false;
  private boolean isPitchMax = false;

  /** Creates a new LimelightRotator. */
  public LimelightActuator() {
    pitchActuator = new Servo(Constants.LIMELIGHT_ACTUATOR_PITCH_CHANNEL);
    rotationActuator = new Servo(Constants.LIMELIGHT_ACTUATOR_ROTATE_CHANNEL);
    pitchActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_PITCH_MIN);
    rotationActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_ROTATE_MIN);
  }

  public void rotate(){
    if(isRotateMax == true){
      rotationActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_ROTATE_MIN);
      isRotateMax = false;
    } else {
      rotationActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_ROTATE_MAX);
      isRotateMax = true;
    }
  }

  public void pitch(){
    if(isPitchMax == true){
      pitchActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_PITCH_MIN);
      isPitchMax = false;
    } else {
      pitchActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_PITCH_MAX);
      isPitchMax = true;
    }
  }
  public void setAngle(){
    if(pitchActuator.getAngle()>160 && rotationActuator.getAngle()>160){
      pitchActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_PITCH_MAX);
      rotationActuator.setAngle(Constants.LIMELIGHT_ACTUATOR_ROTATE_MAX);


    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
