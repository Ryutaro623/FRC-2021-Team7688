package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Launcher;

public class Launch_and_Feedstart extends CommandBase {
  private final Timer time = new Timer();
  private final Launcher launch;
  private final Feeder Feed;
  /** Creates a new Launchstart. */
  public Launch_and_Feedstart(Launcher launch1,Feeder Feed1) {
    launch = launch1;
    Feed = Feed1;
    addRequirements(launch);
    addRequirements(Feed);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launch.Settime(Constants.RAMP_UP_TIME);
    Feed.Settime(Constants.RAMP_UP_TIME);

    time.reset();
    time.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launch.Drive();
    Feed.Drive();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launch.Settime(0);
    Feed.Settime(0);
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

