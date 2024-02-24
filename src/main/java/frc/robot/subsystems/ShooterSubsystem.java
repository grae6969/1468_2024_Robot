// Author: UMN Robotics Ri3d
// Last Updated : January 2024

package frc.robot.subsystems;

import static frc.robot.ConstantsMechanisms.ShooterConstants.*;

//import com.ctre.phoenix6.controls.Follower;
//import com.ctre.phoenix6.controls.DutyCycleOut;
//import com.ctre.phoenix6.controls.PositionVoltage;
//import com.ctre.phoenix6.controls.VelocityVoltage;
//import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
//import com.revrobotics.CANSparkLowLevel.MotorType;




import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  
  // Shooter Motor Controllers
  private TalonFX m_leftShooterMotor = new TalonFX(SHOOTER_LEFT_MOTOR_ID,"rio"); // KRAKEN motor
 // private RelativeEncoder shooterEncoder =  m_leftShooterMotor.getEncoder();//
  private TalonFX m_rightShooterMotor = new TalonFX(SHOOTER_RIGHT_MOTOR_ID,"rio"); // KRAKEN motor

    /** Subsystem for controlling the Shooter */
  public ShooterSubsystem() {
    m_leftShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    m_rightShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    m_leftShooterMotor.setInverted(true);            // TA TODO: polarity of these?
    m_rightShooterMotor.setInverted(false);
 //   m_rightShooterMotor.setControl(new Follower(m_leftShooterMotor.getDeviceID(), true));

    
   // shooterEncoder.setPosition(kZeroOffset);     // TA TODO: Determine offset
   // shooterEncoder.setPositionConversionFactor(kEncoderRotation2Inches); // TA TODO: Determine conversion factor
   // m_leftShooterMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, kForwardSoftLimit);
   // m_leftShooterMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, kReverseSoftLimit);

  }

  /* Set power to the Shooter motor */
  public void setShooterSpeeds(double ltSpeed, double rtSpeed) {
    m_leftShooterMotor.set(ltSpeed);
    m_rightShooterMotor.set(rtSpeed);  

  }

  /* Set power to the Shooter motor */
 // public void shootNote() {
 //   m_leftShooterMotor.set(SHOOT_SPEED);
//  }

  /* Set power to the Shooter motor */
  public void ejectNote() {
    m_leftShooterMotor.set(SHOOTER_EJECT_SPEED);
    m_rightShooterMotor.set(SHOOTER_EJECT_SPEED);  
  }

  public void stop() {
    m_leftShooterMotor.set(0);
    m_rightShooterMotor.set(0);
   }

  @Override
  public void periodic() {
    
    // Put the speed on SmartDashboard
    SmartDashboard.putNumber("Shooter LtMtr Speed", m_leftShooterMotor.get());
    SmartDashboard.putNumber("Shooter RtMtr Speed", m_rightShooterMotor.get());
        SmartDashboard.putNumber("Shooter Lt motor temperature", m_leftShooterMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Shooter Rt motor temperature", m_rightShooterMotor.getDeviceTemp().getValueAsDouble());

  }
}