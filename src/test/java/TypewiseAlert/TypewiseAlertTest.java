package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import typewisealert.TypewiseAlert;
import typewisealert.battery.BatteryCharacter;
import typewisealert.enums.AlertTarget;
import typewisealert.enums.BreachType;
import typewisealert.enums.CoolingType;

public class TypewiseAlertTest 
{
	
    @Test
    public void checkAlertForLowTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),-1);   	
    }
    
    @Test
    public void checkAlertForNormalTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),15);
    }
    
    @Test
    public void checkAlertForHighTempPassiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.PASSIVE_COOLING),40);
    }
    
    @Test
    public void checkAlertForLowTempHighActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),-20);
    }
    
    @Test
    public void checkAlertForNormalTempHighActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),44);
    }
    
    @Test
    public void checkAlertForHighTempHighActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING),46);
    }
    
    @Test
    public void checkAlertForLowTempMediumActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),-7);
    }
    
    @Test
    public void checkAlertForNormalTempMediumActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),0);
    }
    
    @Test
    public void checkAlertForHighTempMediumActiveCooling()
    {
    	TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,new BatteryCharacter(CoolingType.MED_ACTIVE_COOLING),45);
    }
}
