// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
public class LimelightTarget extends SubsystemBase {
  /** Creates a new LimelightTarget. */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  double x;
  double a;
  public LimelightTarget() {
    table.getEntry("ledMode").setNumber(3);
    
    
  }

  public double Target(){
    x = tx.getDouble(0.0);
    return x;
  }
  public double Area(){
    a = ta.getDouble(0.0);
    return a;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
