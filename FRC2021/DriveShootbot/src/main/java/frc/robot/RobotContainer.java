// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LEDstart;
import frc.robot.commands.STOP;
import frc.robot.commands.ShootwithLED;
import frc.robot.subsystems.Agitator;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.LED;
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
  public static final Launcher LAUNCHER = new Launcher();
  public static final Feeder FEEDER = new Feeder();
  public static final Agitator m_ag = new Agitator();
  public static final LED le = new LED();
  private final DriveTrain DT = new DriveTrain();
  
  private final LEDstart led = new LEDstart(le);
  private final ArcadeDrive AD = new ArcadeDrive(DT,le);
  private final ShootwithLED SLED = new ShootwithLED();
  private final Joystick joystick = new Joystick(0);
  private final JoystickButton JB = new JoystickButton(joystick, 1);
  private final JoystickButton JB2 = new JoystickButton(joystick, 2);
  private final STOP stp = new STOP(DT);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
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
    JB.whenPressed(AD);
    JB2.whenPressed(SLED);
    
    JB.whenReleased(stp.alongWith(led));

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
