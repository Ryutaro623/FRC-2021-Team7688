// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LEDwhite;
import frc.robot.subsystems.Drivetrain;

import frc.robot.commands.LimelightPitch;
import frc.robot.commands.LimelightRotate;
import frc.robot.commands.ShootwithLED;
import frc.robot.subsystems.Agitator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.LimelightActuator;
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

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Joystick and buttons
  private final Joystick m_joystick = new Joystick(0);
  private final JoystickButton j_A = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_A);
  private final JoystickButton j_B = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_B);
  private final JoystickButton j_X = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_X);
  private final JoystickButton j_Y = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_Y);
  private final JoystickButton j_LShoulder = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_LEFTSHOULDER);
  private final JoystickButton j_RShoulder = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_RIGHTSHOULDER);
  private final JoystickButton j_Back = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_BACK);
  private final JoystickButton j_Start = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_START);
  private final JoystickButton j_LStick = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_LEFTSTICK);
  private final JoystickButton j_RStick = new JoystickButton(m_joystick, Constants.CONTROLLER_BUTTON_RIGHTSTICK);
  //LED
  public final static LED m_led = new LED();

  //Drivetrain
  private final Drivetrain drivetrain = new Drivetrain();
  private final Drive drivetrainDrive = new Drive(drivetrain,m_led);
  
  //Feeder
  public final static Feeder m_feeder = new Feeder();

  //Launcher
  public final static Launcher m_launcher = new Launcher();
  //Agitator
  public final static Agitator m_agitator = new Agitator();
  //Shoot
  public static final ShootwithLED Shoot = new ShootwithLED();

  

  //Limelight Actuator
  private final LimelightActuator limelightActuator = new LimelightActuator();
  private final LimelightRotate limelightRotate = new LimelightRotate(limelightActuator);
  private final LimelightPitch limelightPitch = new LimelightPitch(limelightActuator);
  
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
    j_RShoulder.whileHeld(drivetrainDrive);

    j_A.whenPressed(limelightPitch);
    j_B.whenPressed(limelightRotate);

    j_Y.whenPressed(Shoot.andThen(new LEDwhite(m_led)));
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
