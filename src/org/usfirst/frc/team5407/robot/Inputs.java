package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Inputs {
    public Joystick j_leftStick;
    public Joystick j_rightStick;

    private boolean isCameraButtonPressed;
    private boolean isIntakeButtonPressed;
    private boolean isDualSpeedShifterButtonPressed;
    private boolean isSolenoidFourButtonPressed;
    private boolean isSolenoidTwoButtonPressed;   //x button claw release
    private boolean isSolenoidThreeButtonPressed;
    private boolean isIntakeOutButtonPressed;
    private boolean isScaleLiftButtonPressed;
    private boolean isPortalLiftButtonPressed;
    private boolean isDefaultLiftButtonPressed;
    private boolean isSolenoidFiveButtonPressed;
    private boolean isSuperButtonPressed;
    
    private double throttle;
    private double turn;

    public Inputs(int leftJoystickPort, int rightJoystickPort) {
        j_leftStick = new Joystick(leftJoystickPort);
        j_rightStick = new Joystick(rightJoystickPort);
    }
    
    // Public Booleans
    public boolean getIsCameraButtonPressed() { return isCameraButtonPressed; }
    public boolean getIsDualSpeedShifterButtonPressed() { return isDualSpeedShifterButtonPressed; }
    public boolean getIsSolenoidFourButtonPressed() { return isSolenoidFourButtonPressed; }
    public boolean getIsSolenoidTwoButtonPressed() { return isSolenoidTwoButtonPressed; }  // x button claw release
    public boolean getIsSolenoidThreeButtonPressed() { return isSolenoidThreeButtonPressed; }
    public boolean getIsSolenoidFiveButtonPresses() {return isSolenoidFiveButtonPressed; }
    public boolean getIsIntakeButtonPressed() { return isIntakeButtonPressed;  }
    public boolean getIsIntakeOutButtonPressed() { return isIntakeOutButtonPressed; }
    public boolean getisScaleLiftButtonPressed() { return isScaleLiftButtonPressed;}
    public boolean getisPortalLiftButtonPressed() { return isPortalLiftButtonPressed;}
    public boolean getisDefaultLiftButtonPressed() { return isDefaultLiftButtonPressed;}
    public boolean getIsSuperButtonPressed() {return isSuperButtonPressed;}
    
    // Public doubles
    public double getThrottle() { return throttle;}
    public double getTurn() { return turn;}

    public void ReadValues() {
    	//Driver Controller
		// Private doubles
    	if (j_leftStick.getY() < 0.1 && j_leftStick.getY() > 0.1){
    		throttle = 0.0;
    	}else {
    		throttle = j_leftStick.getY(); // xbox left X, positive is forward
    	}
		
    	if (j_leftStick.getX() < 0.1 && j_leftStick.getX() > 0.1 ){
    		turn = 0.0;
    	}else {
    		turn = j_leftStick.getX(); // xbox right X, positive means turn right
    	}

		// Private booleans
        isCameraButtonPressed = j_leftStick.getRawButton(5);
        isDualSpeedShifterButtonPressed = j_leftStick.getRawButton(6);
        isSolenoidFiveButtonPressed = j_leftStick.getRawButton(1);
  
    //Operation Controller       
        // Private booleans
        isSolenoidFourButtonPressed = j_rightStick.getRawButton(6);
        isIntakeOutButtonPressed = j_rightStick.getRawButton(5);
        isScaleLiftButtonPressed = j_rightStick.getRawButton(4);
        isPortalLiftButtonPressed = j_rightStick.getRawButton(2);
        isDefaultLiftButtonPressed = j_rightStick.getRawButton(1);
        isSuperButtonPressed = j_rightStick.getRawAxis(3)>0.1;
        isSolenoidTwoButtonPressed = j_rightStick.getRawButton(3); //x button claw release
        //  isSolenoidThreeButtonPressed = j_rightStick.getRawButton(6);
        isIntakeButtonPressed = j_rightStick.getRawAxis(2)>0.1; //moved to drive side

        

    }
}
