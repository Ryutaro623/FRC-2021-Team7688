// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LED extends SubsystemBase {
  private AddressableLED m_led= new AddressableLED(Constants.LED_PORT);
  private AddressableLEDBuffer m_ledBuffer= new AddressableLEDBuffer(Constants.LED_LENGTH);
  private int m_rainbowFirstpixel_hue = 0;
  private int Vs = 0;
  /** Creates a new LED. */
  public LED() {
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();
  }
  public void ShootRainbow(){
    for(var i = 0; i < m_ledBuffer.getLength(); i++){

      final var hue = (m_rainbowFirstpixel_hue+(i*180/m_ledBuffer.getLength()))%180;
    m_ledBuffer.setHSV(i, hue, Constants.HSV_SATURATION, Constants.HSV_VALUE);
    

  }
  
  m_rainbowFirstpixel_hue +=5;
  m_rainbowFirstpixel_hue %=180;
  m_led.setData(m_ledBuffer);
 }
 public void normal(){
  for(var i = 0; i < m_ledBuffer.getLength(); i++){
      int v = (Vs+(i*255/m_ledBuffer.getLength()))%255;


      m_ledBuffer.setRGB(i, v,v,v);
    }
    Vs += 5;
    Vs %= 255;
    m_led.setData(m_ledBuffer);
  }
 
  public void Speed(int length){
    if(length >= 0){
      for(var i = 0; i< Constants.LED_LENGTH; i++){
       m_ledBuffer.setHSV(i, 120,length, 128);
 
 
      }
      m_led.setData(m_ledBuffer);
    } else {
     for(var i = 0; i< Constants.LED_LENGTH; i++){
       m_ledBuffer.setHSV(i, 0,-length, 128);
 
 
      }
      m_led.setData(m_ledBuffer);
    }
  }
      
 


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
