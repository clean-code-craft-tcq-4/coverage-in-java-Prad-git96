package typewisealert.battery;

import typewisealert.enums.CoolingType;

public class BatteryCharacter {
  public CoolingType coolingType;
  public String brand;
  
  public BatteryCharacter(CoolingType coolingType){
	  this.coolingType= coolingType;
  }
}
