// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveToDistance extends CommandBase {
  DriveTrain driveTrain;
  private boolean finish = false;
  
  public DriveToDistance(DriveTrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
    
  }

  
  @Override
  public void initialize() {
    finish = driveTrain.driveToDistance(Constants.SETPOINT_FOWARD, Constants.AUTONOMOUS_SPEED);
  }

  
  @Override
  public void execute() {}

  
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  
  @Override
  public boolean isFinished() {
    return finish;
  }
}
