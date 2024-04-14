package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="manualDrive")
public class teleop extends LinearOpMode {
    // Creating Motors (Might have to change to Motor instead of MotorEx later)
    private MotorEx fL;
    private MotorEx fR;
    private MotorEx bL;
    private MotorEx bR;

    // Creating MecanumDrive and Gamepad
    private MecanumDrive m_drive;
    private GamepadEx m_gamepad;

    @Override
    public void runOpMode() throws InterruptedException {
        // Assigning Objects
        m_gamepad = new GamepadEx(gamepad1);

        // Assigning Motors. Motor RPM might be 312 but it should be good
        fL = new MotorEx(hardwareMap, "fL", Motor.GoBILDA.RPM_312);
        fR = new MotorEx(hardwareMap, "fR", Motor.GoBILDA.RPM_312);
        bL = new MotorEx(hardwareMap, "bL", Motor.GoBILDA.RPM_312);
        bR = new MotorEx(hardwareMap, "bR", Motor.GoBILDA.RPM_312);

        // MecanumDrive motor order must be: Front left, front right, back left, back right
        m_drive = new MecanumDrive(fL, fR, bL, bR);

        // I think some of the wheels on one side were facing the opposite direction, I might've reversed the wrong ones though.
        fL.setInverted(true);
        bL.setInverted(true);

        // Waits to run until the start button has been pressed
        waitForStart();

        while(opModeIsActive()) {
            // This is robot relative drive, so when pushing left stick forward it'll always go in the direction of the front of the robot.

            // Parameters for driveRobotCentric are strafe speed, forward speed, then rotation
            m_drive.driveRobotCentric(m_gamepad.getLeftX(), m_gamepad.getLeftY(), m_gamepad.getRightY());

            // Spin Mode
            if(m_gamepad.getButton(GamepadKeys.Button.A)) {
                fL.set(1);
                fR.set(-1);
                bL.set(1);
                bR.set(-1);
            }
            else if(m_gamepad.getButton(GamepadKeys.Button.B)) {
                fL.stopMotor();
                fR.stopMotor();
                bL.stopMotor();
                bR.stopMotor();
            }



            // Move to Position Command
            if(m_gamepad.getButton(GamepadKeys.Button.X)) {
                // Distance (in ticks)
                fL.setTargetPosition(5000);
                fR.setTargetPosition(5000);
                bL.setTargetPosition(5000);
                bR.setTargetPosition(5000);

                fL.set(0.5);
                fR.set(0.5);
                bL.set(0.5);
                bR.set(0.5);
            }
                fL.stopMotor();
                fR.stopMotor();
                bL.stopMotor();
                bR.stopMotor();


            // Stops Move to Position Command if at position
            if(fL.atTargetPosition() && fL.atTargetPosition() && fL.atTargetPosition() && fL.atTargetPosition()) {
                fL.stopMotor();
                fR.stopMotor();
                bL.stopMotor();
                bR.stopMotor();
            }
            // In MS
            sleep(20);
        }

    }
}
