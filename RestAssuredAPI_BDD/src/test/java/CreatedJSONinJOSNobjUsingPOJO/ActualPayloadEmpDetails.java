package CreatedJSONinJOSNobjUsingPOJO;

public class ActualPayloadEmpDetails {
	
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
	
	private String name;
	private int salary;
	private int age;
	private address address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	

}
