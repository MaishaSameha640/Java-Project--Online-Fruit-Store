package fruitstore;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class CustomerCart extends OwnerCart implements DiscountProvider, CustomerRegistration {

	Scanner input = new Scanner(System.in);

	public CustomerCart(String fruitName, double price, int quantity)
	{

		super(fruitName, price, quantity);
	}

	ArrayList<Customer1> CustomerList = new ArrayList<>();

	public static ArrayList<Fruit> customeritems = new ArrayList<>();// fruit(name,price)

	public int registerCustomer(int id, String pass)
	{
		int x = 1, y = 2, z = 3;
		for (Customer1 c1 : CustomerList) 
		{
			if (c1.getCustomerID() == id)
			{
				if (c1.getPassword().equalsIgnoreCase(pass))
				{
					c1.viewCustomerDetails();
					
					return x;
				} 
				else 
				{
					return y;
				}
			}
		}
		return z;

	}

	public int addItem(Fruit fruit)
	{
		// searching that fruits and showing its availability
		int c = 0, c1 = 0,n=0;

		for (Fruit fru : storeitems) 
		{
			if (fru.getFruitName().equalsIgnoreCase(fruit.getFruitName())) 
			 {
				if (fruit.getQuantity_C() <= fru.getQuantity_O()) 
				{
					int s = fruit.getQuantity_C();

					s = fru.getQuantity_O() - s;

					fru.setQuantity_O(s);

					if (s == 0)
					{
						remove_Oneitem(fru.getFruitName());// owner cart fruit remove
					} 
					else 
					{
						fru.setQuantity_O(s);// fruits quantity change in owner cart

					}

					Fruit fruit_ = new Fruit(fru.getFruitName(), fruit.getQuantity_C(), fru.getPrice());
					
					customeritems.add(fruit_);
					n=1;
					JOptionPane.showMessageDialog(null,fruit.getQuantity_C() + " " + fru.getFruitName() + " are added to the cart.");

				} 
				else if (fruit.getQuantity_C() > fru.getQuantity_O() && fru.getQuantity_O() != 0) 
				{
					
					fruit.setQuantity_C(fru.getQuantity_O());
					
					Fruit fruit_ = new Fruit(fru.getFruitName(), fruit.getQuantity_C(), fru.getPrice());
					
					customeritems.add(fruit_);
					
					JOptionPane.showMessageDialog(null,"Only " + fru.getQuantity_O() + " " + fru.getFruitName() + " are available");
					
					JOptionPane.showMessageDialog(null,fruit.getQuantity_C() + " " + fru.getFruitName() + " are added to the cart.");
					
					fru.setQuantity_O(0);
					n=1;
					remove_Oneitem(fru.getFruitName());

				} 
                
			} 
		}
		
		if(n==0) {
			  JOptionPane.showMessageDialog(null, fruit.getFruitName() + " are not available.");
		}
		return 0;
	}

	public void removeItem(String name, int quantity)
    {
		int n = 0;

		for (Fruit fruit : customeritems) 
		{
			if (fruit.getFruitName().equalsIgnoreCase(name))
			{
				if (fruit.getQuantity_C() < quantity) 
				{
					JOptionPane.showMessageDialog(null,"Only " + fruit.getQuantity_C()+ " " + fruit.getFruitName() + " are available in customer cart");
					n=1;
					break;
				}
				else if (fruit.getQuantity_C() == quantity)
				{
					customeritems.remove(fruit);
					JOptionPane.showMessageDialog(null, name + " have been removed from customercart");
					n = 1;
					viewCartDetails();
					break;
				} 
				else if (fruit.getQuantity_C() > quantity)
				{
					int s = fruit.getQuantity_C() - quantity;
					
					fruit.setQuantity_C(s);
					
					String stockItems = fruit.toString();
					//System.out.println(fruit.toString());
					
					n = 1;
					JOptionPane.showMessageDialog(null, stockItems);
					
					break;
				}

			}
			
		}
		if(n==0)
		{
			System.out.println(name + " is not available in customer cart");
		}
		else if (n == 1) {
			for (int i = 0; i < storeitems.size(); i++)
			{
				if (storeitems.get(i).getFruitName().equalsIgnoreCase(name))
				{
					int s = storeitems.get(i).getQuantity_O() + quantity;
					
					storeitems.get(i).setQuantity_O(s);
				}
			}
		}

	}

	public void clearCart() 
	{
		customeritems.clear();
	}

	public double getTotalPrice() 
	{
		double totalPrice = 0.0;
		
		for (int i = 0; i < customeritems.size(); i++)
		{
			totalPrice = totalPrice + ((customeritems.get(i).getQuantity_C()) * (customeritems.get(i).getPrice()));
		}
		return totalPrice;

	}

	@Override
	public double applyDiscount() 
	{
		double price = getTotalPrice();
		if (price >= 1000)
		{
			double discountprice = price - ((price * 10) / 100);
			return discountprice;
		}
		return 0;

	}

	public void viewCartDetails() {

		for (int i = 0; i < customeritems.size(); i++) 
		{
			JOptionPane.showMessageDialog(null, customeritems.get(i).getFruitName() + "price : "+ customeritems.get(i).getPrice() + " " + "quantity =" + customeritems.get(i).getQuantity_C());

		}

	}

}
