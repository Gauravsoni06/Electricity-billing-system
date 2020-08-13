import java.util.*;
class Electricity
{
	double[] rate={6.35,7.5,9.75,10.80};
	int[] fixed_charges={30,105};
	String supp;
	int a;
	String[] connection={"DM","NDM","SLS","AG","SIS","MIS","LIS","BSML"};
	Electricity(int u,String typ)
	{
		int units=u;
		String connection_type=typ;
		for(int i=0;i<connection.length;i++)
		{
			if(connection_type==connection[i])
				a=i;
		}
		switch(a)
		{
			case 0:
			{
				Domestic(units);
				break;
			}
			case 1:
			{
				Non_Domestic(units);
				break;
			}
			case 2:
			{
				Street_Lighting_Service(units);
				break;
			}
			case 3:
			{
				Agriculture_Service(units);
				break;
			}
			case 4:
			{
				Small_Industrial_Service(units);
				break;
			}
			case 5:
			{
				Medium_Industrial_Service(units);
				break;
			}
			case 6:
			{
				Large_Industrial_Service(units);
				break;
			}
			case 7:
			{
				Bulk_Supply_for_Mixed_load(units);
				break;
			}
			default:
			{
				System.out.println("invalid connection type");
			}
		}
	}
	Scanner in=new Scanner(System.in);
	public void Domestic(int units)
	{	
		double amount;
		double amt;
		if(units<=50)
		{
			amount=fixed_charges[0]+units*rate[0];
			System.out.println("amount="+amount);
		}
		else if(units>50&&units<100)
		{
			amt=rate[0]*50;
			amount=fixed_charges[0]+(units-50)*rate[1]+amt;
			System.out.println("amount="+amount);
		}
		else if(units>100&&units<200)
		{
			
		}
	}
	public void Non_Domestic(int units)
	{	
	
	}
	public void Street_Lighting_Service(int units)
	{
		
	}
	public void Agriculture_Service(int units)
	{
		
	}
	public void Small_Industrial_Service(int units)
	{
	
	}
	public void Medium_Industrial_Service(int units)
	{
	
	}
	public void Large_Industrial_Service(int units)
	{
	
	}
	public void Bulk_Supply_for_Mixed_load(int units)
	{
	
	} 

	public static void main(String args[])
	{
		int unit=40;
		String type_conn="DM";
		Electricity e1=new Electricity(unit,type_conn);						
	}
}
