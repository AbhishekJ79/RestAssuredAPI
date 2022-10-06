package CreatedJSONinJOSNobjUsingPOJO;

public class address {
	
	//inner json object
/*	{
		  "name" : "Abhishek",
		  "salary" : 12322,
		  "age" : 27,
		   "address" : {
		    	"gateNo" : 144,
		    	 "buldingName" : "shree shraddha"
		  }
		}
		*/
	private int gateNo;
	private String buldingName;
	
	
	public int getGateNo() {
		return gateNo;
	}
	public void setGateNo(int gateNo) {
		this.gateNo = gateNo;
	}
	public String getBuldingName() {
		return buldingName;
	}
	public void setBuldingName(String buldingName) {
		this.buldingName = buldingName;
	}
	
	

}
