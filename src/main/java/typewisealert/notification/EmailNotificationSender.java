package typewisealert.notification;

import typewisealert.enums.BreachType;

public class EmailNotificationSender implements Notifier{

	@Override
	public void sendNotification(BreachType breachType) {
		 String recepient = "a.b@c.com";
	      switch(breachType) {
	        case TOO_LOW:
	          System.out.printf("To: %s\n", recepient);
	          System.out.println("Hi, the temperature is too low\n");
	          break;
	        case TOO_HIGH:
	          System.out.printf("To: %s\n", recepient);
	          System.out.println("Hi, the temperature is too high\n");
	          break;
	        case NORMAL:
	          break;
	      }		
	}

}
