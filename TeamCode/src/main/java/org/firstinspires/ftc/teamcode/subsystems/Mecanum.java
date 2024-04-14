package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.qualcomm.robotcore.hardware.HardwareMap;

// All subsystems MUST extend SubsystemBase, NOT Subsystem
public class Mecanum extends SubsystemBase {
    // Subsystems hold hardware objects like motors, servos, sensors, etc...
    private MotorEx m_frontLeft;
    private MotorEx m_frontRight;
    private MotorEx m_backLeft;
    private MotorEx m_backRight;

    /*
    There are many ways to make this constructor! It depends on if you want to allow customization. For example, here we
    hard-code the names of each motor, but perhaps you want to allow the person calling the constructor to specify the motor names themselves,
    in which case you would also have four strings in the constructor.
     */
    public Mecanum(HardwareMap hardwareMap) {
        m_frontLeft = new MotorEx(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312);
        m_frontRight = new MotorEx(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312);
        m_backLeft = new MotorEx(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312);
        m_backRight = new MotorEx(hardwareMap, "backRight", Motor.GoBILDA.RPM_312);

        // Check the FTCLib docs to see why we do this
        m_frontLeft.setRunMode(Motor.RunMode.VelocityControl);
        m_frontRight.setRunMode(Motor.RunMode.VelocityControl);
        m_backLeft.setRunMode(Motor.RunMode.VelocityControl);
        m_backRight.setRunMode(Motor.RunMode.VelocityControl);

        m_frontLeft.setInverted(true);
        m_backLeft.setInverted(true);
    }

    // Alternate constructor to show it's not set in stone how you make yours. It's up to personal preference and project style!
    public Mecanum(HardwareMap hardwareMap, String fLName, String fRName, String bLName, String bRName) {
        m_frontRight = new MotorEx(hardwareMap, fLName, Motor.GoBILDA.RPM_312);
        // ... And so on
    }

    // This function, when complete, will do the same thing as driveRobotCentric
    public void moveRobotRelative(double forwardSpeedMps, double strafeSpeedMps, double rotationSpeedRps) {
        ChassisSpeeds speeds;
        // Create ChassisSpeeds from parameters...
    }

    public void move(ChassisSpeeds speeds) {
        // Convert chassisSpeeds to wheelSpeeds...
    }
}
