package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import typewisealert.TypewiseAlert;
import typewisealert.enums.BreachType;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==
        BreachType.TOO_LOW);
    }
}
