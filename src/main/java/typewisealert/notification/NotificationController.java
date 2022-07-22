package typewisealert.notification;

import typewisealert.enums.BreachType;

public class NotificationController implements Notifier {

	@Override
	public void sendNotification(BreachType breachType) {
		      int header = 0xfeed;
		      System.out.printf("%i : %i\n", header, breachType);
	}

}
