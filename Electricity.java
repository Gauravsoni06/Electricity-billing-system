import java.util.*;
class Electricity
{
	public double[] rate={6.35,7.5,9.75,10.80,12.32,15.6,18.5,13.6};
	public int[] fixed_charges={30,105,115,150,250,300,215};
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
		if(units<=100)
		{
			amount=fixed_charges[0]+units*rate[0];
			System.out.println("amount="+amount);
		}
		else
		{
			amt=rate[0]*100;
			amount=fixed_charges[0]+(units-100)*rate[1]+amt;
			System.out.println("amount="+amount);
		}
	}
	public void Non_Domestic(int units)
	{	
		double amount;
		double amt;
		if(units<=200)
		{
			amount=fixed_charges[1]+units*rate[1];
			System.out.println("amount="+amount);
		}
		else
		{
			amt=rate[0]*200;
			amount=fixed_charges[1]+(units-100)*rate[2]+amt;
			System.out.println("amount="+amount);
		}
	}
	public void Street_Lighting_Service(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[3]+units*rate[3];
		System.out.println("amount="+amount);
	}
	public void Agriculture_Service(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[4]+units*rate[4];
		System.out.println("amount="+amount);
	}
	public void Small_Industrial_Service(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[5]+units*rate[5];
		System.out.println("amount="+amount);
	}
	public void Medium_Industrial_Service(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[5]+units*rate[6];
		System.out.println("amount="+amount);
	}
	public void Large_Industrial_Service(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[5]+units*rate[7];
		System.out.println("amount="+amount);
	}
	public void Bulk_Supply_for_Mixed_load(int units)
	{
		double amount;
		double amt;
		amount=fixed_charges[5]+units*rate[7];
		System.out.println("amount="+amount);
	} 

	public static void main(String args[])
	{
		int unit=40;
		String type_conn="DM";
		Electricity e1=new Electricity(unit,type_conn);						
	}
}
