// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Launch_And_Feed;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final Feeder feed = new Feeder();
  public static final Launcher launch = new Launcher();
  private final Joystick joystick = new Joystick(0);
  private final JoystickButton jb = new JoystickButton(joystick, 1);
  private final Launch_And_Feed run = new Launch_And_Feed();
  
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private static double createDashbord(String key, double defvalue){
    double value = SmartDashboard.getNumber(key, defvalue);
    SmartDashboard.putNumber(key, value);
    return value;

  }
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Motors
    createDashbord(Constants.TOP_MOTOR, Constants.DEF_TOP_MOTOR_VALUE);
    createDashbord(Constants.BOTTOM_MOTOR, Constants.DEF_BOTTOM_MOTOR_VALUE);
    createDashbord(Constants.FEEDER_MOTOR, Constants.DEF_FEEDER_VALUE);
    //Time
    createDashbord(Constants.WAIT_TIME, Constants.DEF_WAIT_TIME_VALUE);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    jb.whenPressed(run);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
