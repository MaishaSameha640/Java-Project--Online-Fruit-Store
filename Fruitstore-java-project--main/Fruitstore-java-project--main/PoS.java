package fruitstore;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PoS {

	static double c = 0.0;

	public static void customerSystem()// Accessing user cart by this method
	{
		CustomerCart cart = new CustomerCart(null, 0.0, 0);

		Scanner scan = new Scanner(System.in);

		// customer cart management
		while (true)// 1st while loop in this method
		{
			try {
				String[] customer_Options = { "Add fruits to cart", "Remove fruits from cart", "Apply Discount",
						"View Cart Details", "Exit" };

				int choice = JOptionPane.showOptionDialog(null, "Customer", "Fruit store -customer '-' ", 0,
						JOptionPane.QUESTION_MESSAGE, null, customer_Options, customer_Options[0]);

				// for customer menu

				// 1st try block
				try {

					if (choice == 0)// adding fruits in customers fruit list
					{
						String type = JOptionPane.showInputDialog("Enter how many types of fruit you want to ADD : ");

						int type_ = Integer.parseInt(type);

						for (int j = 0; j < type_; j++) {
							String name = JOptionPane.showInputDialog("Enter fruit name:");

							String quantity = JOptionPane.showInputDialog("Enter quantity");

							int quantity_ = Integer.parseInt(quantity);

							Fruit fruit = new Fruit(name, quantity_);

							cart.addItem(fruit);
						}

					} else if (choice == 1)// removing fruits from customer fruit list
					{
						String[] customer_remove_Options = { "Clear the full cart  ", "Remove a single fruit" };

						int number = JOptionPane.showOptionDialog(null, "Customer", "Fruit store -Customer", 0,
								JOptionPane.QUESTION_MESSAGE, null, customer_remove_Options,
								customer_remove_Options[0]);

						// clear cart
						if (number == 0) {
							cart.clearCart();

							JOptionPane.showMessageDialog(null, "All fruits are removed successfully");
						} else if (number == 1)// removing one fruit item
						{
							String name = JOptionPane.showInputDialog("Enter fruit name:");

							String quantity = JOptionPane.showInputDialog("Enter fruit quantity to remove from cart:");

							int quantity_ = Integer.parseInt(quantity);

							cart.removeItem(name, quantity_);
						}
					} else if (choice == 2)// discount on total price
					{
						JOptionPane.showMessageDialog(null, "Total Price : " + cart.getTotalPrice());

						c = cart.applyDiscount();
					} else if (choice == 3)// view cart items
					{
						JOptionPane.showMessageDialog(null, "Cart Items: ");

						cart.viewCartDetails();
						if (c == 0.0) {
							JOptionPane.showMessageDialog(null, "Total Price: " + cart.getTotalPrice());
						} else {
							JOptionPane.showMessageDialog(null, "Total Price: " + cart.applyDiscount());

						}
					} else if (choice == 4) {
						cart.clearCart();
						break;
					}
				} // end of 1st try block

				catch (InputMismatchException e) {
					JOptionPane.showMessageDialog(null, "Exception Message: " + e + "\nPlease enter a valid input.");

					scan.nextLine();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An error occured: " + e.getMessage());
			}

		} // end of 1st while loop in this method

	}// end of customerSystem

	// main method starts
	public static void main(String[] args) {

		OwnerCart cart1 = new OwnerCart(null, 0.0, 0);
		CustomerCart cart = new CustomerCart(null, 0.0, 0);
		Scanner scanner = new Scanner(System.in);

		// 1st while loop starts in main
		while (true) {
			try {
				String[] options = { "Owner", "Customer", "Exit" };

				int option = JOptionPane.showOptionDialog(null, "Select User Type:", "Fruit store :)", 0, 1, null,
						options, options[0]);

				// 1st try block in main
				try {

					// owner store management
					if (option == 0) // 1st if block starts
					{

						String pass = JOptionPane.showInputDialog("Enter Owner password:");

						OwnerInfo owner = new OwnerInfo();

						if (owner.can_access(pass))// 2nd if block
						{
							while (true)// 2nd while loop starts
							{
								String[] Owner_Options = { "Add fruits to store ", "Remove fruits from store",
										"View store Details", "Exit" };

								int choice = JOptionPane.showOptionDialog(null, "Owner", "Fruit store -Owner", 0,
										JOptionPane.QUESTION_MESSAGE, null, Owner_Options, Owner_Options[0]);

								// 2nd try block in main
								try {

									if (choice == 0)// add fruits in owner cart
									{
										String type = JOptionPane
												.showInputDialog("Enter how many types of fruit you want to ADD : ");
										int type_ = Integer.parseInt(type);

										for (int j = 0; j < type_; j++) {
											String name = JOptionPane.showInputDialog("Enter fruit name:");

											String price = JOptionPane.showInputDialog("Enter fruit price:");

											double price_ = Double.parseDouble(price);

											String quantity = JOptionPane.showInputDialog("Enter quantity");

											int quantity_ = Integer.parseInt(quantity);

											Fruit fruit = new Fruit(name, price_, quantity_);

											cart1.addstoreItem(fruit);
										}

									} else if (choice == 1)// removing fruits from owner cart
									{

										String[] Owner_remove_Options = { "Clear the full cart  ",
												"Remove a single fruit" };

										int number = JOptionPane.showOptionDialog(null, "Owner", "Fruit store -Owner",
												0, JOptionPane.QUESTION_MESSAGE, null, Owner_remove_Options,
												Owner_remove_Options[0]);

										if (number == 0) // clearing full cart
										{

											cart1.clearstoreCart();

											JOptionPane.showMessageDialog(null, "All fruits are removed successfully.");
										} else if (number == 1)// removing one fruit from store
										{
											String name = JOptionPane.showInputDialog("Enter fruit name:");

											String quantity = JOptionPane.showInputDialog("Enter fruit quantity:");

											int quantity_ = Integer.parseInt(quantity);

											int removed = 0;

											int c = 0;
											cart1.removestoreItem(name, quantity_);
										}
									} else if (choice == 2)// view owner cart items
									{
										cart.viewOwnerCartItems();// customer fruit list
									} else if (choice == 3) {

										break;
									} else {
										JOptionPane.showMessageDialog(null,
												"\\nInvalid choice. Please enter a valid option.");

									}
								} // end of 2nd try block
								catch (InputMismatchException e) {
									JOptionPane.showMessageDialog(null,
											"Exception Message: " + e + "\nPlease enter a valid input.\n");
								}
							} // end of 2nd while loop
						} // end of 2nd if block
						else {
							JOptionPane.showMessageDialog(null, "Invalid password.Access denied!");
						}

					}
					// end of 1st if block

					// user account access starts
					else if (option == 1) {
						// Customer management system

						String id = JOptionPane.showInputDialog("Enter Customer Id");

						int id_ = Integer.parseInt(id);

						String password = JOptionPane.showInputDialog("Enter Password");

						int s = cart.registerCustomer(id_, password);

						if (s == 1) {
							JOptionPane.showMessageDialog(null, "customer is already registered!");

							customerSystem();

						} else if (s == 2) {
							JOptionPane.showMessageDialog(null, "invalid password!");

						} else if (s == 3) {
							JOptionPane.showMessageDialog(null, "customer has not been registered yet");

							String name = JOptionPane.showInputDialog("Enter Customer name");

							Customer1 customer = new Customer1(id_, name, password);

							cart.CustomerList.add(customer);

							JOptionPane.showMessageDialog(null, "Customer has been registered!");

							customerSystem();

						}

					}

					// to exit the whole program
					else if (option == 2) {
						JOptionPane.showMessageDialog(null,
								"Thank you for visiting our online fruit store.Hope you enjoyed!!\\n");

						break;
					}
				} // end of try block 2

				catch (InputMismatchException e) {
					JOptionPane.showMessageDialog(null, "Exception Message: " + e + "\nPlease enter a valid input.\n");

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An error occured: " + e.getMessage());
			}

		} // end of 1st while loop in main method

	}// end of main method

}
// end of poS class