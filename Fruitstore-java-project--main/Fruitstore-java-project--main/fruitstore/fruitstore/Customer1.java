package fruitstore;

public class Customer1 {
	 private int  customerID;
	private String customerName;
	private  String password;

	
	public Customer1(int customerID, String customerName,String password) {
	
		this.customerID = customerID;
		this.customerName = customerName;
        this.password=password;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void viewCustomerDetails() {
		 System.out.println("customer id: "+getCustomerID());
		 System.out.println("customer name: "+getCustomerName());
		 
	}
	
	
	
	
	
	
}
