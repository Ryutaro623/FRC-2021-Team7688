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
    //port
    public final static int TOP_MOTOR_PORT = 6;
    public final static int BOTTOM_MOTOR_PORT = 3;
    public final static int feeder_motor_port = 2;
    public final static int sender_motor_port = 5;
    //time
    public final static double RAMP_UP_TIME = 5;
    public final static double PRAMP_UP_TIME = 1;
    //about SmartDashborads Key
    public final static String TOP_MOTOR = "Top_Motor_power";
    public final static String BOTTOM_MOTOR = "Bottom_Motor_power";
    public final static String FEEDER_MOTOR = "Feeder_Motor_Power";
    public final static String WAIT_TIME = "Set_Wait_time";
    public final static String PUSH = "Push_power";
    //Defaul tvalue
    public final static double DEF_TOP_MOTOR_VALUE = 0.1;
    public final static double DEF_BOTTOM_MOTOR_VALUE = 0.1;
    public final static double DEF_FEEDER_VALUE =0.1;
    public final static double DEF_PUSH_MOTOR_VALUE = 0.1;
    public final static double DEF_WAIT_TIME_VALUE=3;
}
