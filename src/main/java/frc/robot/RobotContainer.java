package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.generated.TunerConstants;

public class RobotContainer {
  private double MaxSpeed = 6; // 6 meters per second desired top speed
  private double MaxAngularRate = 1.5 * Math.PI; // 3/4 of a rotation per second max angular velocity

  /* Setting up bindings for necessary control of the swerve drive platform */
  private final Joystick joystick = new Joystick(0); // My joystick
  private final JoystickButton trigger = new JoystickButton(joystick, 1);
  private final JoystickButton zeroGyro = new JoystickButton(joystick, 9);
  public final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain; // My drivetrain

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // I want field-centric
                                                               // driving in open loop
  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();

  /* Path follower */
  private Command runAuto = drivetrain.getAutoPath("Tests");

  private final Telemetry logger = new Telemetry(MaxSpeed);

  private void configureBindings() {
    drivetrain.setDefaultCommand( // Drivetrain will execute this command periodically
        drivetrain.applyRequest(() -> drive
          .withVelocityX(MathUtil.applyDeadband(-joystick.getY(), 0.2) * MaxSpeed) // Drive forward with negative Y (forward)
          .withVelocityY(MathUtil.applyDeadband(-joystick.getX(), 0.2) * MaxSpeed) // Drive left with negative X (left)
          .withRotationalRate(MathUtil.applyDeadband(-joystick.getZ(), 0.2) * MaxAngularRate) // Drive counterclockwise with negative X (left)
        ).ignoringDisable(true));

    trigger.whileTrue(drivetrain.applyRequest(() -> brake));

    // reset the field-centric heading on left bumper press
    zeroGyro.onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    // if (Utils.isSimulation()) {
    //   drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    // }
    drivetrain.registerTelemetry(logger::telemeterize);
  }

  public RobotContainer() {
    configureBindings();
  }

  public Command getAutonomousCommand() {
    /* First put the drivetrain into auto run mode, then run the auto */
    return runAuto;
  }
}
