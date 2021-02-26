// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Air extends SubsystemBase {
  /** Creates a new Air. */
  private final DoubleSolenoid doubleSolenoid = new DoubleSolenoid(Constants.DOUBLESOLENOID_PUSH_PORT,Constants.DOUBLESOLENOID_BACK_PORT);
  private final Compressor compressor = new Compressor(Constants.COMPRESSOR_PORT);
  public Air() {}

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
