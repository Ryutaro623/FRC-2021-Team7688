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
    //Limelight servo port
public final static int BOTTOM_SERVO = 0;
public final static int TOP_SERVO = 0;
//Launcher and Feeder　打ち上げるやつと運ぶやつ
public final static int TOP_MOTOR_PORT = 11;
public final static int BOTTOM_MOTOR_PORT = 12;
public final static int FEEDER_MOTOR_PORT = 13;

//Talon
public final static int AGITATOR_MOTOR_PORT = 2;

//Drive train LEFT MOTOR　左のモーター
//Victor
public final static int LEFT_FRONT_TOP_MOTOR_PORT= 7;
public final static int LEFT_FRONT_BOTTOM_MOTOR_PORT= 8;
public final static int LEFT_BACK_TOP_MOTOR_PORT= 9;
//Talon
public final static int LEFT_BACK_BOTTOM_MOTOR_PORT= 10;

//Drive train RIGHT MOTOR　右のモーター
public final static int RIGHT_FRONT_TOP_MOTOR_PORT= 4;
public final static int RIGHT_FRONT_BOTTOM_MOTOR_PORT= 5;
public final static int RIGHT_BACK_TOP_MOTOR_PORT= 6;
//talon
public final static int RIGHT_BACK_BOTTOM_MOTOR_PORT= 3;

//LED
public final static int LED_PORT = 2;
public final static int LED_LENGTH = 59;
public final static int HSV_VALUE = 128;
public final static int HSV_SATURATION = 255;

//Rump up time
public final static double RAMP_UP_TIME = 4;
public final static double DRAMP_UP_TIME= 1;
public final static double ARAMP_UP_TIME = 0.2;

//time
public final static double WAIT_TIME = 10;
public final static double AGITATO_TIME = 0.9;


//feeder and launcher Motor value
public final static double DEF_TOP_MOTOR_VALUE = 0.6;
public final static double DEF_BOTTOM_MOTOR_VALUE = 0.6;
public final static double DEF_FEEDER_VALUE =0.4;
public final static double DEF_AGITATOR_MOTOR_VALUE = 0.3;

}
