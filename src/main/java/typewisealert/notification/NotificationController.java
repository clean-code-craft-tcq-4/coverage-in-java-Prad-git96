package typewisealert.notification;

import typewisealert.enums.BreachType;

public class NotificationController implements Notifier {

	@Override
	public void sendNotification(BreachType breachType) {
		if(!breachType.equals(BreachType.NORMAL)) {
		      int header = 0xfeed;
		      System.out.printf("%s : %s\n", Integer.toHexString(header), breachType.getBreachType());
		}
	}
}
