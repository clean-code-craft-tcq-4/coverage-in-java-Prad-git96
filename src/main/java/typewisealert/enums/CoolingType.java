package typewisealert.enums;

public enum CoolingType {
    PASSIVE_COOLING(0,35),
    HI_ACTIVE_COOLING(0,45),
    MED_ACTIVE_COOLING(0,40);
    
    int lowerLimit = 0;
    int upperLimit = 0;
    
    CoolingType(int lowerLimit,int upperLimit){
    	this.lowerLimit=lowerLimit;
    	this.upperLimit=upperLimit;
    }
    
    public int getLowerLimit() {
		return this.lowerLimit;
	}
    
    public int getUpperLimit() {
  		return this.upperLimit;
  	}
  };