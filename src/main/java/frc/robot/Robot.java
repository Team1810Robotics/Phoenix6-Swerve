package frc.robot;

//import org.photonvision.PhotonCamera;
//import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

 // private PhotonCamera camera = new PhotonCamera("Arducam_OV9281_USB_Camera");

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    m_robotContainer.drivetrain.getDaqThread().setThreadPriority(99);
  }
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
    
    //var result = camera.getLatestResult();
   // if (!result.hasTargets()) return;

    //PhotonTrackedTarget target = result.getBestTarget();

   // SmartDashboard.putNumber("yaw", target.getYaw());
   // SmartDashboard.putNumber("pitch", target.getPitch());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}
