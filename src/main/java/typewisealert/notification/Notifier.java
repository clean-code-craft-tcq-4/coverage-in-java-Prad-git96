package typewisealert.notification;

import typewisealert.enums.BreachType;

public interface Notifier {
	public void sendNotification(BreachType breachType) ;
}
