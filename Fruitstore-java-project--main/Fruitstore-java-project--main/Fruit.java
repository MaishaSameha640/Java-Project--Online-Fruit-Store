package fruitstore;

public class Fruit {
	
	private String fruitName;
	private   double price;
	private int quantity_C;
	private int quantity_O;
	
	//for owner input
	public Fruit(String fruitName, double price, int quantity) {
	
		this.fruitName = fruitName;
		this.price = price;
		this.quantity_O = quantity;
	}
	public Fruit(String fruitName, int quantity, double price)
	{
		this.fruitName = fruitName;
		this.price = price;
		this.quantity_C= quantity;
	}
	

	//for customer input
	public Fruit(String fruitName,int quantity) {
	
		this.fruitName = fruitName;
		this.quantity_C = quantity;
		this.price = getPrice();
		
	}
	
	//to search by name
	public Fruit(String fruitName)
	{
		this.fruitName = fruitName;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity_C() {
		return quantity_C;
	}

	public void setQuantity_C(int quantity_C) {
		this.quantity_C = quantity_C;
	}

	public int getQuantity_O() {
		return quantity_O;
	}

	public void setQuantity_O(int quantity_O) {
		this.quantity_O = quantity_O;
	}
	@Override
	public String toString() {
		return "Fruit [fruitName=" + fruitName + ", price=" + price + ", quantity =" + quantity_C + "]";
	}
	public String viewownerritems()
	{
		return "Fruit [fruitName=" + fruitName + ", price=" + price + ", quantity =" + quantity_O + "]";
	}

	
	

	
}
