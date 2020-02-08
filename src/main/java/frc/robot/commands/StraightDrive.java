/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class StraightDrive extends CommandBase {
  /**
   * Creates a new StraightDrive.
   */
  private double distance=0;
  DriveTrain d;
  public StraightDrive(double setpoint, DriveTrain d) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(d);
    this.d=d;
    distance=setpoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(distance>d.getPosition()){
      d.tankDrive(0.5,0.5);
      //checks the encoder value in Shufffleboard
      SmartDashboard.putNumber("Encoder Value", d.getPosition());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //return distance>d.getPosition();
    return false;
  }
}
