package fruitstore;

public class OwnerInfo  {
	public static String ownername="rahim";
	public static final String password = "uap";
	
	
	public boolean can_access(String pass)
	{
		if(password.equalsIgnoreCase(pass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
   
	
}
