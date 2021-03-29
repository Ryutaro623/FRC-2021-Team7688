// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightActuator;
import frc.robot.subsystems.LimelightTarget;

public class Aiming extends CommandBase {
  /** Creates a new Aiming. */
  private final PIDController pid = new PIDController(Constants.LIMELIGHT_ROTATION_KP, Constants.LIMELIGHT_ROTATION_KI,Constants.LIMELIGHT_ROTATION_KD);
  private final Drivetrain D;
  private final LimelightTarget LT;
  private final LimelightActuator LA;
  private final Timer time = new Timer();
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
    LT.Turn_on_the_light();
    pid.setIntegratorRange(-Constants.ROTATION_I_LIMITE, Constants.ROTATION_I_LIMITE);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LA.setAngle();
    if(LT.Area()==0){
      System.out.println("SEEKING THE TARGET");
      D.drive(0, 0.35);

    } else {
      double output = MathUtil.clamp(pid.calculate(LT.Target()/27, 0),0.5 , -0.5);

      
      
      System.out.println("GOING TO THE TARGET "+output);
      SmartDashboard.putNumber("P+I+D", output);
      D.drive(0, output);
      
      

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
    return false;
    
      
    
  }
}
