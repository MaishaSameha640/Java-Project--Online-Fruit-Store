package fruitstore;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OwnerCart extends Fruit {

	public OwnerCart(String fruitName, double price, int quantity) 
	{
		super(fruitName, price, quantity);
	}

	public static ArrayList<Fruit> storeitems = new ArrayList<>();

	public void addstoreItem(Fruit fruit)
	{
		int n = 0;
		for (int i = 0; i < storeitems.size(); i++)
		{
			if (storeitems.get(i).getFruitName().equalsIgnoreCase(fruit.getFruitName())) 
			{
				int s = storeitems.get(i).getQuantity_O();
				
				s = s + fruit.getQuantity_O();
				
				storeitems.get(i).setQuantity_O(s);
				
				n = 1;
				break;
			}
		}
		if (n == 0) 
		{
			storeitems.add(fruit);

		}

	}

	public void remove_Oneitem(String name)// remove one item
	{
		for (int i = 0; i < storeitems.size(); i++) 
		{
			if (storeitems.get(i).getFruitName().equalsIgnoreCase(name)) 
			{
				storeitems.remove(i);
				
				break;
			}

		}

	}

	public void removestoreItem(String name, int quantity)// remove specific items
	{
		int n = 0;
		for (int i = 0; i < storeitems.size(); i++)
       {
			if (storeitems.get(i).getFruitName().equalsIgnoreCase(name))
			{
				if (storeitems.get(i).getQuantity_O() > quantity) 
				{
					int s = storeitems.get(i).getQuantity_O();
					
					s = s - quantity;
					
					storeitems.get(i).setQuantity_O(s);
					
					JOptionPane.showMessageDialog(null, quantity+name +"s  have been removed from ownercart");

					n = 1;
				} 
				else if (storeitems.get(i).getQuantity_O() == quantity) 
				{
					storeitems.remove(i);
					JOptionPane.showMessageDialog(null, name + " have been removed from ownercart");
					n = 1;
				}
				else if(storeitems.get(i).getQuantity_O() < quantity)
				{
					JOptionPane.showMessageDialog(null,"Only " + storeitems.get(i).getQuantity_O()+ " " + storeitems.get(i).getFruitName() + " are available in owner cart");
				    n=1;
				}
			}
		}
		if (n == 0)
		{
			JOptionPane.showMessageDialog(null, name + " is unavailable in ownercart");

		}

	}

	public void clearstoreCart() 
	{
		storeitems.clear();
		JOptionPane.showMessageDialog(null,"All the fruits from the owner's cart have been removed.");
	}

	public void viewOwnerCartItems() 
	{
		if (storeitems.size() != 0)
		{
			for (Fruit fru : storeitems) 
			{
				JOptionPane.showMessageDialog(null,fru.getFruitName() + " - price : " + fru.getPrice() + " quantity = " + fru.getQuantity_O());

			}
		} 
		else {
			JOptionPane.showMessageDialog(null, "Owner cart is empty.");
		}
	}

}
