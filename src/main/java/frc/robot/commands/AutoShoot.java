// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase {
  Shooter shooter;
  Timer timer;
  private boolean finish = false;
  /** Creates a new AutoShoot. */
  public AutoShoot(Shooter s) {
    shooter = s;
    addRequirements(shooter);
    timer = new Timer();
  }

  
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < Constants.AUTO_SHOOT_TIME)
    {
      shooter.shootBall(Constants.SHOOTER_SPEED);

    }
    finish = true;
  }

  
  @Override
  public void execute() {}

 
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
  }

  
  @Override
  public boolean isFinished() {
    return finish;
  }
}
