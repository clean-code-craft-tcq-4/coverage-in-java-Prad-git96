package typewisealert;

import typewisealert.battery.BatteryCharacter;
import typewisealert.enums.AlertTarget;
import typewisealert.enums.BreachType;
import typewisealert.enums.CoolingType;
import typewisealert.notification.EmailNotificationSender;
import typewisealert.notification.NotificationController;
import typewisealert.notification.Notifier;

public class TypewiseAlert 
{
	private TypewiseAlert() {}
   
	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
	      if(value < lowerLimit) {
	        return BreachType.TOO_LOW;
	      }
	      if(value > upperLimit) {
	        return BreachType.TOO_HIGH;
	      }
	      return BreachType.NORMAL;
	}
   
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
      return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
    
   
    public static void checkAndAlert(
        AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {

    	BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
		Notifier notifier;
		
    	 if(alertTarget.equals(AlertTarget.TO_EMAIL)) {
		 notifier= new EmailNotificationSender();      
    	 } else {
			notifier=  new NotificationController();
    	 }

    	notifier.sendNotification(breachType);
    }
    
    
}
