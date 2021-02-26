// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Agitator extends SubsystemBase {
  private final PWMSparkMax ag = new PWMSparkMax(Constants.AGITATOR_MOTOR_PORT);
  /** Creates a new Agitator. */
  public Agitator() {}

  public void Ro(double speed){
    ag.setSpeed(speed);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
