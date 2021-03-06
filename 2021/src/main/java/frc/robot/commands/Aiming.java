// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightActuator;
import frc.robot.subsystems.LimelightTarget;

public class Aiming extends CommandBase {
  /** Creates a new Aiming. */
  private final PIDController pid = new PIDController(Constants.LIMELIGHT_ROTATION_KP, Constants.LIMELIGHT_ROTATION_KI, Constants.LIMELIGHT_ROTATION_KD);
  private final Drivetrain D;
  private final LimelightTarget LT;
  private final LimelightActuator LA;
  private final Timer time = new Timer();
  private double integlar = 0;
  private double dt;
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
    pid.setIntegratorRange(-Constants.ROTATION_I_LIMITE, Constants.ROTATION_I_LIMITE);
  }
  public double PID(double now_value, double set_point,double I_limit,double kp,double ki, double kd){
    new WaitCommand(0.05);
    double error = set_point - now_value;
    double P = error*kp;
    System.out.println(lasttime);
    System.out.println(dt);
    
    dt = time.get()-lasttime;
    if(Math.abs(error)<I_limit){
      integlar = integlar+(error*0.05);
    }
    System.out.println(dt);
    
    double I = integlar*ki;
    if(Math.abs(I)>I_limit){
      I =0.4;

    }
    double D = (error-previous_error/0.05)*kd;
    
    lasttime = time.get();
    double output = -(P+I+D);
    previous_error = error;
    
    return output;
    

    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LA.setAngle();
    if(LT.Area()==0){
      System.out.println("SEEKING THE TARGET");
      D.drive(0, 0.4);

    } else {
      double output = MathUtil.clamp(pid.calculate(LT.Target(), 0),0.4 , -0.4);
      
      
      System.out.println("GOING TO THE TARGET"+output);
      D.drive(0.4, output);
      
      

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    D.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(LT.Area()<1){
      return true;
    } else {
      return false;
    }
    
      
    
  }
}
