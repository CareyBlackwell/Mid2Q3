package customer.model;

public class Customer {
	private String FirstName;
	private String MiddleInit;
	private String LastName;
	private String gender;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	
	public Customer(String FirstName, String MiddleInit, String LastName, String gender, String Address, String City, String State, String Zip){
		this.FirstName= FirstName;
		this.MiddleInit= MiddleInit;
		this.LastName=LastName;
		this.gender=gender;
		this.Address=Address;
		this.City=City;
		this.State=State;
		this.Zip=Zip;
	}
	public String getFirstName(){
		return this.FirstName;
	}
	public String getMiddleInit(){
		return this.MiddleInit;
	}
	public String getLastName(){
		return this.LastName;
	}
	public String getGender(){
		return this.gender;
	}
	public String getAddress(){
		return this.Address;
	}
	public String getCity(){
		return this.City;
	}
	public String getState(){
		return this.State;
	}
	public String getZip(){
		return this.Zip;
	}
	public void setFirstName(String FirstName){
		this.FirstName=FirstName;
	}
	public void setMiddleInit(String MiddleInit){
		this.MiddleInit=MiddleInit;
	}
	public void setLastName(String LastName){
		this.LastName=LastName;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public void setAddress(String Address){
		this.Address=Address;
	}
	public void setCity(String City){
		this.City=City;
	}
	public void setState(String State){
		this.State=State;
	}
	public void setZip(String Zip){
		this.Zip=Zip;
	}
}
