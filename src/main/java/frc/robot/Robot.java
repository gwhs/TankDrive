/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private XboxController m_mController;
 
  public void robotInit() {
    //m_myRobot = new DifferentialDrive(new PX(0), new PWMVictorSPX(1));
    m_mController = new XboxController(0);

   CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
   //CANSparkMax m_midLeft = new CANSparkMax(2, MotorType.kBrushless);
   //CANSparkMax m_rearLeft = new CANSparkMax(3, MotorType.kBrushless);
   //SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_midLeft, m_rearLeft);

   CANSparkMax m_frontRight = new CANSparkMax(4, MotorType.kBrushless);
   //CANSparkMax m_midRight = new CANSparkMax(5, MotorType.kBrushless);
   //CANSparkMax m_rearRight = new CANSparkMax(6, MotorType.kBrushless);
   //SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_midRight, m_rearRight);

   //m_myRobot = new DifferentialDrive(m_left, m_right);
   m_myRobot = new DifferentialDrive(m_frontLeft, m_frontRight);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_mController.getY(Hand.kLeft), m_mController.getY(Hand.kRight));
  }
}
