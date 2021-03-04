// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightActuator;
import frc.robot.subsystems.LimelightTarget;

public class Aiming extends CommandBase {
  /** Creates a new Aiming. */
  private final Drivetrain D;
  private final LimelightTarget LT;
  private final LimelightActuator LA;
  private final Timer time = new Timer();
  private double integlar = 0;
  private double dt = 0;
  private double previous_error = 0;
  private double lasttime = 0;
  public Aiming(Drivetrain dtt,LimelightTarget ll,LimelightActuator la) {
    LT = ll;
    LA = la;
    D = dtt;
    addRequirements(LT);
    addRequirements(D);
    addRequirements(LA);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
  }
  public double PID(double now_value, double set_point,double kp,double ki, double kd){
    double error = set_point - now_value;
    double P = error*kp;
    dt = time.get()-lasttime;
    integlar = integlar+(error*dt);
    double I = integlar*ki;
    double D = (error-previous_error/dt)*kd;
    lasttime = time.get();
    double output = P+I+D;
    previous_error = error;
    return output;
    

    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LA.setAngle();
    if(LT.Area()==0){
      System.out.println("SEEKING THE TARGET");
      D.drive(0, 0.5);

    } else {
      
      
      System.out.println("GOING TO THE TARGET"+PID(LT.Target(), Constants.LIMELIGHT_ROTATTON_SETPOINT, Constants.LIMELIGHT_ROTATION_KP, Constants.LIMELIGHT_ROTATION_KI, Constants.LIMELIGHT_ROTATION_KD));
      D.drive(0, PID(LT.Target(), Constants.LIMELIGHT_ROTATTON_SETPOINT, Constants.LIMELIGHT_ROTATION_KP, Constants.LIMELIGHT_ROTATION_KI, Constants.LIMELIGHT_ROTATION_KD));
      
      

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
      return false;
    
  }
}
