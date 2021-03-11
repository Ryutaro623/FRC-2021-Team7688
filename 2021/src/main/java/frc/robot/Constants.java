// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /*
    AGITATOR
    */
    public final static int AGITATOR_MOTOR_PORT = 2;
    public final static double AGITATOR_RAMP_TIME = 1.1;
    public final static double AGITATOR_MOTOR_SPEED = 0.5;
    public final static double AGITATOR_WAIT_TIME = 6;

    /*
    LED
    */
    public final static int LED_LENGTH = 59;
    public final static int LED_PORT = 9;
    public final static int HSV_SATURATION = 255;
    public final static int HSV_VALUE = 128;
    /*
    Pnumatic
    */
    public final static int COMPRESSOR_PORT = 0;
    public final static int PENUMATIC_SOLENOIDS_RIGHT_PORT = 0;
    public final static int PENUMATIC_SOLENOIDS_LEFT_PORT = 1;
  
    /*
    LAUNCHER
    */
    public static final double LAUNCHER_RAMP = 1.5;
    public static final double LAUNCHER_UPPER_SPEED = 0.48;
    public static final double LAUNCHER_LOWER_SPEED = 0.48;
    public static final int LAUNCHER_UPPER_MULTIPLIER = 1;
    public static final int LAUNCHER_LOWER_MULTIPLIER = 1;
    public static final int LAUNCHER_UPPER_CHANNEL = 11;
    public static final int LAUNCHER_LOWER_CHANNEL = 12;

    /* 
    FEEDER
    */
    public static final double FEEDER_RAMP = 1.5;
    public static final double FEEDER_SPEED = 0.4;
    public static final int FEEDER_MULTIPLIER = -1;
    public static final int FEEDER_CHANNEL = 13;  
    public static final double FEEDER_DELAY = 3; //Delay before the feeder starts in the FeedLaunch Sequential Command Group
    
    public static final double LAUNCHER_FEEDER_RUNTIME = 1.5; //Delay before the feeder starts in the FeedLaunch Sequential Command Group
    public static final int LAUNCHER_FEEDER_TRIGGER = 3;

    /*
    LIMELIGHT ROTATOR
    */
    public static final double LIMELIGHT_ACTUATOR_ROTATE_MAX = 180;
    public static final double LIMELIGHT_ACTUATOR_ROTATE_MIN = 0;
    public static final double LIMELIGHT_ACTUATOR_PITCH_MAX = 0;
    public static final double LIMELIGHT_ACTUATOR_PITCH_MIN = 180;
    
    public static final int LIMELIGHT_ACTUATOR_PITCH_CHANNEL = 0;
    public static final int LIMELIGHT_ACTUATOR_ROTATE_CHANNEL = 1;

    public static final int LIMELIGHT_ACTUATOR_ROTATE_TRIGGER = 2;
    public static final int LIMELIGHT_ACTUATOR_PITCH_TRIGGER = 1;

    /*
    DRIVETRAIN
    */
    public static final int DRIVETRAIN_DRIVE_DIRECTION = 1; //1 or -1
    public static final double DRIVETRAIN_RAMP = 1;

    public static final int DRIVETRAIN_LEFT_FRONT_TOP_CHANNEL = 7;
    public static final int DRIVETRAIN_LEFT_FRONT_BOTTOM_CHANNEL = 8;
    public static final int DRIVETRAIN_LEFT_BACK_TOP_CHANNEL = 9;

    public static final int DRIVETRAIN_LEFT_BACK_BOTTOM_CHANNEL = 10;
    public static final int DRIVETRAIN_RIGHT_BACK_BOTTOM_CHANNEL = 3;

    public static final int DRIVETRAIN_RIGHT_FRONT_TOP_CHANNEL = 4;
    public static final int DRIVETRAIN_RIGHT_FRONT_BOTTOM_CHANNEL = 5;
    public static final int DRIVETRAIN_RIGHT_BACK_TOP_CHANNEL = 6;

    public static final int DRIVETRAIN_JOYSTICK_AXIS_SPEED = 5;
    public static final int DRIVETRAIN_JOYSTICK_AXIS_ROTATION = 0;
    public static final int DRIVETRAIN_DRIVE_TRIGGER = 6;

    /*
    CONTROLLER
    */
    public static final int CONTROLLER_BUTTON_B = 2;
    public static final int CONTROLLER_BUTTON_A = 1;
    public static final int CONTROLLER_BUTTON_X = 3;
    public static final int CONTROLLER_BUTTON_Y = 4;
    public static final int CONTROLLER_BUTTON_LEFTSHOULDER = 5;
    public static final int CONTROLLER_BUTTON_RIGHTSHOULDER = 6;
    public static final int CONTROLLER_BUTTON_BACK = 7;
    public static final int CONTROLLER_BUTTON_START = 8;
    public static final int CONTROLLER_BUTTON_LEFTSTICK = 9;
    public static final int CONTROLLER_BUTTON_RIGHTSTICK = 10;
}
