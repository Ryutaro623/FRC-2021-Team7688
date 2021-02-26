package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {

  VictorSPX m_shoot1 = new VictorSPX(Constants.LAUNCHER_TOP_MOTOR_PORT);
  VictorSPX m_shoot2 = new VictorSPX(Constants.LAUNCHER_BOTTOM_MOTOR_PORT);
  
  /** Creates a new Launcher. */
  public Launcher() {
    this.ChangeRampTime(Constants.LAUNCHER_RAMP_TIME_DEFAULT);
  }

  public void Shoot(double speed2, double speed3){
    m_shoot1.set(ControlMode.PercentOutput, speed2);
    m_shoot2.set(ControlMode.PercentOutput, speed3);
  }

  public void ChangeRampTime (double time){
    m_shoot1.configClosedloopRamp(time);
    m_shoot2.configClosedloopRamp(time);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
