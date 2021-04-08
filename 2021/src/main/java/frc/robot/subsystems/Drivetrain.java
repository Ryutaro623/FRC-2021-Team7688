// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final WPI_VictorSPX lFT;
  private final WPI_VictorSPX lFB;
  private final WPI_VictorSPX lBT;
  private final WPI_TalonSRX lBB;

  private final WPI_VictorSPX rFT;
  private final WPI_VictorSPX rFB;
  private final WPI_VictorSPX rBT;
  private final WPI_TalonSRX rBB;

  private final SpeedControllerGroup left;
  private final SpeedControllerGroup right;
  
  private final DifferentialDrive diffDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    lFT = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_TOP_CHANNEL);
    lFB = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_BOTTOM_CHANNEL);
    lBT = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_BACK_TOP_CHANNEL);
    lBB = new WPI_TalonSRX(Constants.DRIVETRAIN_LEFT_BACK_BOTTOM_CHANNEL);

    rFT = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_TOP_CHANNEL);
    rFB = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_BOTTOM_CHANNEL);
    rBT = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_TOP_CHANNEL);
    rBB = new WPI_TalonSRX(Constants.DRIVETRAIN_RIGHT_BACK_BOTTOM_CHANNEL);

    left = new SpeedControllerGroup(lFT, lFB, lBT, lBB);
    right = new SpeedControllerGroup(rFT, rFB, rBT, rBB);

    diffDrive = new DifferentialDrive(left, right);
  
    lFT.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    lFB.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    lBT.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    lBB.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);

    rFT.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    rFB.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    rBT.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
    rBB.configOpenloopRamp(Constants.DRIVETRAIN_RAMP);
  }

  public void drive(double speed, double rotation) {
    diffDrive.arcadeDrive(speed * Constants.DRIVETRAIN_DRIVE_DIRECTION, rotation + Constants.DRIVETRAIN_ROTATION_BIAS);
  }

  public void stop() {
    diffDrive.arcadeDrive(0, 0);
  }

  //Autonomous

  public void autoDrive(double speed, double rotation){
    diffDrive.arcadeDrive(speed * Constants.DRIVETRAIN_DRIVE_DIRECTION, rotation + Constants.DRIVETRAIN_ROTATION_BIAS);
  }

  public void autoStop(){
    diffDrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
