package frc.robot.generated;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants.SteerFeedbackType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;

import edu.wpi.first.math.util.Units;
import frc.robot.CommandSwerveDrivetrain;

public class TunerConstants {
    // Both sets of gains need to be tuned to your individual robot
    // The steer motor uses MotionMagicVoltage control
    private static final Slot0Configs steerGains = new Slot0Configs()
        .withKP(100).withKI(0).withKD(0.05)
        .withKS(0).withKV(1.5).withKA(0);
    // When using closed-loop control, the drive motor uses:
    // - VelocityVoltage, if DrivetrainConstants.SupportsPro is false (default)
    // - VelocityTorqueCurrentFOC, if DrivetrainConstants.SupportsPro is true
    private static final Slot0Configs driveGains = new Slot0Configs()
        .withKP(3).withKI(0).withKD(0)
        .withKS(0).withKV(0).withKA(0);

    // The stator current at which the wheels start to slip;
    // This needs to be tuned to your individual robot
    private static final double kSlipCurrentA = 300.0;

    // Theoretical free speed (m/s) at 12v applied output;
    // This needs to be tuned to your individual robot
    public static final double kSpeedAt12VoltsMps = 6.0;

    // Every 1 rotation of the azimuth results in kCoupleRatio drive motor turns;
    // This may need to be tuned to your individual robot
    private static final double kCoupleRatio = 3.5714285714285716;

    private static final double kDriveGearRatio = 6.746031746031747;
    private static final double kSteerGearRatio = 12.8;
    private static final double kWheelRadiusInches = 2;

    private static final boolean kSteerMotorReversed = false;
    private static final boolean kInvertLeftSide = false;
    private static final boolean kInvertRightSide = true;

    private static final String kCANbusName = "";
    private static final int kPigeonId = 13;


    // These are only used for simulation
    private static final double kSteerInertia = 0.00001;
    private static final double kDriveInertia = 0.001;

    private static final SwerveDrivetrainConstants DrivetrainConstants = new SwerveDrivetrainConstants()
            .withPigeon2Id(kPigeonId)
            .withCANbusName(kCANbusName);

    private static final SwerveModuleConstantsFactory ConstantCreator = new SwerveModuleConstantsFactory()
            .withDriveMotorGearRatio(kDriveGearRatio)
            .withSteerMotorGearRatio(kSteerGearRatio)
            .withWheelRadius(kWheelRadiusInches)
            .withSlipCurrent(kSlipCurrentA)
            .withSteerMotorGains(steerGains)
            .withDriveMotorGains(driveGains)
            .withSpeedAt12VoltsMps(kSpeedAt12VoltsMps)
            .withSteerInertia(kSteerInertia)
            .withDriveInertia(kDriveInertia)
            .withFeedbackSource(SteerFeedbackType.FusedCANcoder)
            .withCouplingGearRatio(kCoupleRatio)
            .withSteerMotorInverted(kSteerMotorReversed);


    // Front Left
    private static final int kFrontLeftDriveMotorId = 4;
    private static final int kFrontLeftSteerMotorId = 3;
    private static final int kFrontLeftEncoderId = 10;
    private static final double kFrontLeftEncoderOffset = -0.35791015625;

    private static final double kFrontLeftXPosInches = 9.125;
    private static final double kFrontLeftYPosInches = 9.125;

    // Front Right
    private static final int kFrontRightDriveMotorId = 2;
    private static final int kFrontRightSteerMotorId = 1;
    private static final int kFrontRightEncoderId = 9;
    private static final double kFrontRightEncoderOffset = -0.036376953125;

    private static final double kFrontRightXPosInches = 9.125;
    private static final double kFrontRightYPosInches = -9.125;

    // Back Left
    private static final int kBackLeftDriveMotorId = 6;
    private static final int kBackLeftSteerMotorId = 5;
    private static final int kBackLeftEncoderId = 11;
    private static final double kBackLeftEncoderOffset = -0.147705078125;

    private static final double kBackLeftXPosInches = -9.125;
    private static final double kBackLeftYPosInches = 9.125;

    // Back Right
    private static final int kBackRightDriveMotorId = 8;
    private static final int kBackRightSteerMotorId = 7;
    private static final int kBackRightEncoderId = 12;
    private static final double kBackRightEncoderOffset = -0.2646484375;

    private static final double kBackRightXPosInches = -9.125;
    private static final double kBackRightYPosInches = -9.125;


    private static final SwerveModuleConstants FrontLeft = ConstantCreator.createModuleConstants(
            kFrontLeftSteerMotorId, kFrontLeftDriveMotorId, kFrontLeftEncoderId, kFrontLeftEncoderOffset, Units.inchesToMeters(kFrontLeftXPosInches), Units.inchesToMeters(kFrontLeftYPosInches), kInvertLeftSide);
    private static final SwerveModuleConstants FrontRight = ConstantCreator.createModuleConstants(
            kFrontRightSteerMotorId, kFrontRightDriveMotorId, kFrontRightEncoderId, kFrontRightEncoderOffset, Units.inchesToMeters(kFrontRightXPosInches), Units.inchesToMeters(kFrontRightYPosInches), kInvertRightSide);
    private static final SwerveModuleConstants BackLeft = ConstantCreator.createModuleConstants(
            kBackLeftSteerMotorId, kBackLeftDriveMotorId, kBackLeftEncoderId, kBackLeftEncoderOffset, Units.inchesToMeters(kBackLeftXPosInches), Units.inchesToMeters(kBackLeftYPosInches), kInvertLeftSide);
    private static final SwerveModuleConstants BackRight = ConstantCreator.createModuleConstants(
            kBackRightSteerMotorId, kBackRightDriveMotorId, kBackRightEncoderId, kBackRightEncoderOffset, Units.inchesToMeters(kBackRightXPosInches), Units.inchesToMeters(kBackRightYPosInches), kInvertRightSide);

    public static final CommandSwerveDrivetrain DriveTrain = new CommandSwerveDrivetrain(DrivetrainConstants, FrontLeft,
            FrontRight, BackLeft, BackRight);
}
