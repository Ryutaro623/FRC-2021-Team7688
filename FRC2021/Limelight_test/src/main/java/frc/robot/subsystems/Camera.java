// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase {
  private NetworkTable table; 
  private NetworkTableEntry tx,ty,ta;
  /** Creates a new Camera. */
  public Camera() {
     table = NetworkTableInstance.getDefault().getTable("limelight");
     tx = table.getEntry("tx");
     ty = table.getEntry("ty");
     ta = table.getEntry("ta");
    

  }
  public double X(){
    double x = tx.getDouble(0.0);
    return x;
  }
  public double Y(){
    double y = ty.getDouble(0.0);
    return y;
  }
  public double Area(){
    double a = ta.getDouble(0.0);
    return a;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
