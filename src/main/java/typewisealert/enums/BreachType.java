package typewisealert.enums;


public enum BreachType {
  NORMAL("normal"),
  TOO_LOW("too low"),
  TOO_HIGH("too high");
  
	String value;
	
	BreachType(String breachType){
		this.value=breachType;
	}
	
	public String  getBreachType() {
		return this.value;
	}
}