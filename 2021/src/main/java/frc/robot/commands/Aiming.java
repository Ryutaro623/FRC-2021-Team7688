// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightActuator;
import frc.robot.subsystems.LimelightTarget;

public class Aiming extends CommandBase {
  /** Creates a new Aiming. */
  private final Drivetrain dt;
  private final LimelightTarget LT;
  private final LimelightActuator LA;
  public Aiming(Drivetrain dtt,LimelightTarget ll,LimelightActuator la) {
    LT = ll;
    LA = la;
    dt = dtt;
    addRequirements(LT);
    addRequirements(dt);
    addRequirements(LA);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LA.setAngle();
    if(LT.Area()==0){
      System.out.println("SEEKING THE TARGET");
      dt.drive(0, 0.5);

    } else {
      System.out.println("GOING TO THE TARGET");
      double speed = (2-LT.Area())/10*4;
      System.out.println(speed+"Now");
      double rotation = LT.Target()/27*0.8;
      dt.drive(speed, rotation);

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
