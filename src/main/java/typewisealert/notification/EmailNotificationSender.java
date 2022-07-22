package typewisealert.notification;

import typewisealert.enums.BreachType;

public class EmailNotificationSender implements Notifier{

	@Override
	public void sendNotification(BreachType breachType) {
		 String recepient = "a.b@c.com";
     	sendEmail(recepient, breachType.getBreachType());
	}
	
	public void sendEmail(String recepient,String breachType) {
        System.out.printf("To: %s\n", recepient);
        System.out.println("Hi, the temperature is "+breachType+ "\n");
	}

}
