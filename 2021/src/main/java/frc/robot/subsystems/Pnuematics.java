// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pnuematics extends SubsystemBase {
  /** Creates a new Pnumatics. */
  private final DoubleSolenoid doubleSolenoid = new DoubleSolenoid(Constants.PENUMATIC_SOLENOIDS_RIGHT_PORT,Constants.PENUMATIC_SOLENOIDS_LEFT_PORT);

  public Pnuematics() {}

  public void Push(){
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void Back(){
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
