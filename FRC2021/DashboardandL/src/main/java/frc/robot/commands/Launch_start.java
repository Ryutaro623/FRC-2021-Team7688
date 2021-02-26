package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.subsystems.Launcher;

public class Launch_start extends CommandBase {
  private final Timer time = new Timer();
  private final Launcher launch;
  /** Creates a new Launchstart. */
  public Launch_start(Launcher launch1) {
    launch = launch1;
    addRequirements(launch);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launch.Settime(Constants.RAMP_UP_TIME);

    time.reset();
    time.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launch.Drive();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launch.Settime(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(time.get()>Constants.RAMP_UP_TIME){
      return true;
      
    } else {
      return false;
    }
  }
}

