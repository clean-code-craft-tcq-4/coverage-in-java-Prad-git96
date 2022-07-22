package TypewiseAlert;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import typewisealert.TypewiseAlert;
import typewisealert.battery.BatteryCharacter;
import typewisealert.enums.AlertTarget;
import typewisealert.enums.BreachType;
import typewisealert.enums.CoolingType;

public class TypewiseAlertTest 
{
	
	private final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(actualOutputStream));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
    @Test
    public void checkAlertForLowTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),-1);
        assertEquals("feed : too low\n", actualOutputStream.toString());
    }
    
    @Test
    public void checkAlertForNormalTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),15);
        assertEquals("", actualOutputStream.toString());
    }
    
    @Test
    public void checkAlertForHighTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),40);
        assertEquals("feed : too high\n", actualOutputStream.toString());
    }
    
    @Test
    public void checkAlertForLowTempHighActiveCooling()
    {
    	String expectedResponse ="To: a.b@c.com\n"
				+ "Hi, the temperature is too low";
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),-20);
    	assertEquals(expectedResponse, actualOutputStream.toString().trim());

    }
    
    @Test
    public void checkAlertForNormalTempHighActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),44);
        assertEquals("", actualOutputStream.toString());
    }
    
    @Test
    public void checkAlertForHighTempHighActiveCooling()
    {

    	String expectedResponse ="To: a.b@c.com\n"
				+ "Hi, the temperature is too high";
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),46);
    	assertEquals(expectedResponse, actualOutputStream.toString().trim());
    }
    
    @Test
    public void checkAlertForLowTempMediumActiveCooling()
    {
    	String expectedResponse ="To: a.b@c.com\n"
				+ "Hi, the temperature is too low";
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),-7);
    	assertEquals(expectedResponse, actualOutputStream.toString().trim());

    }
    
    @Test
    public void checkAlertForNormalTempMediumActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),0);
        assertEquals("", actualOutputStream.toString());
    }
    
    @Test
    public void checkAlertForHighTempMediumActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),45);
        assertEquals("feed : too high\n", actualOutputStream.toString());

    }
}
