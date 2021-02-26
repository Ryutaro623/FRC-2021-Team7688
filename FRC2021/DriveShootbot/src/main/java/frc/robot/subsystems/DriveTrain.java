// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private final WPI_VictorSPX FRT;
  private final WPI_VictorSPX FRB;
  private final WPI_VictorSPX BRT;
  private final WPI_TalonSRX BRB;


  private final WPI_VictorSPX FLT;
  private final WPI_VictorSPX FLB;
  private final WPI_VictorSPX BLT;
  private final WPI_TalonSRX BLB;

  private final DifferentialDrive drive;


  public DriveTrain() {
   FRT = new WPI_VictorSPX(Constants.RIGHT_FRONT_TOP_MOTOR_PORT);
   FRB = new WPI_VictorSPX(Constants.RIGHT_FRONT_BOTTOM_MOTOR_PORT);
   BRT = new WPI_VictorSPX(Constants.RIGHT_BACK_TOP_MOTOR_PORT);
   BRB = new WPI_TalonSRX(Constants.RIGHT_BACK_BOTTOM_MOTOR_PORT);

   FLT = new WPI_VictorSPX(Constants.LEFT_FRONT_TOP_MOTOR_PORT);
   FLB = new WPI_VictorSPX(Constants.LEFT_FRONT_BOTTOM_MOTOR_PORT);
   BLT = new WPI_VictorSPX(Constants.LEFT_BACK_TOP_MOTOR_PORT);
   BLB = new WPI_TalonSRX(Constants.LEFT_BACK_BOTTOM_MOTOR_PORT);
   FRT.follow(BRB);
   FRB.follow(BRB);
   BRT.follow(BRB);

   FLT.follow(BLB);
   FLB.follow(BLB);
   BLT.follow(BLB);
   drive = new DifferentialDrive(BLB, BRB);


   

   



   BLB.configOpenloopRamp(Constants.DRAMP_UP_TIME);
   BRB.configOpenloopRamp(Constants.DRAMP_UP_TIME);

  }

  public void Drive(double speed,double rotetion){
    drive.arcadeDrive(speed*-0.7,rotetion*0.7);
  }
  public void Stop(){
    drive.arcadeDrive(0,0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
