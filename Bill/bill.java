package Bill;
import java.util.*;
import java.lang.*;
class bill
{
	int a;
	static StringBuffer board=new StringBuffer("");
	final String country="INDIA";
	Scanner in=new Scanner(System.in);
	static String[] connection=new String[]{"DM","NDM","SLS","AG","SIS","MIS","LIS","BSML"};
	static
	{
		board.insert(0,"AVVNL");	
	}
	static void change_board()
	{
		board.replace(0,5,"JVVNL");
	}
	public void  billing()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("enter connection type");
		
		String connection_type=in.nextLine();
		
		System.out.println("enter units");
		
		int units= in.nextInt();
		
		for(int i=0;i<connection.length;i++)
		{
			if(connection_type.equals(connection[i]))
				a=i+1;
		}
		conn_type(a,units);
	}	
	public void billing(int units,String connection_type)
	{
		for(int i=0;i<connection.length;i++)
		{
			if(connection_type.equals(connection[i]))
				a=i+1;
		}
		conn_type(a,units);
	}
	public void conn_type(int a,int units)
	{
		switch(a)
		{
			case 1:
			{
				Domestic(units);
				break;
			}
			case 2:
			{
				Non_Domestic(units);
				break;
			}
			case 3:
			{
				Street_Lighting_Service(units);
				break;
			}
			case 4:
			{
				Agriculture_Service(units);
				break;
			}
			case 5:
			{
				Small_Industrial_Service(units);
				break;
			}
			case 6:
			{
				Medium_Industrial_Service(units);
				break;
			}
			case 7:
			{
				Large_Industrial_Service(units);
				break;
			}
			case 8:
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
	public double calculate(int units,double [] energy_charge)
	{
		double ut=units,tem=0;
		double amount=0;
		while(ut>0)
		{
			if(ut>500)
			{
				tem=ut-500;
				amount+=tem*energy_charge[0];
				ut=ut-tem;
			}
			if(ut>300)
			{
				tem=ut-300;
				amount+=tem*energy_charge[1];
				ut=ut-tem;
			}
			if(ut>150)
			{
				tem=ut-150;
				amount+=tem*energy_charge[2];
				ut=ut-tem;
			}
			if(ut>50)
			{
				tem=ut-50;
				amount+=tem*energy_charge[3];
				ut=ut-tem;
			}
			else
			{
				tem=ut;
				amount+=tem*energy_charge[4];
				ut=ut-tem;
			}
		}
		return amount;
	}
	public double calculate(int units,int [] fixed_charges)
	{
		double amount=0;
		if(units>500)
		{
			amount=amount+fixed_charges[0];
		}
		else if(units>300)
		{
			amount=amount+fixed_charges[1];
		}
		else if(units>150)
		{
			amount=amount+fixed_charges[2];
		}
		else if(units>50)
		{
			amount=amount+fixed_charges[3];
		}
		else
		{
			amount=amount+fixed_charges[4];
		}
		return amount;
	}
	public void display(int units,double amount)
	{
		System.out.println("-----billing details------");
		System.out.println("Country: "+country);
		System.out.println("Board: "+board);
		System.out.println("Units: "+units);
		System.out.println("Amount to be paid: "+amount);
		for(int i=0;i<10;i++)
		{
			System.out.println("\n");
		}
		System.out.println("--------------------------");
	}
	public void Domestic(int units)
	{	
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	
	public void Non_Domestic(int units)
	{	
		int ut=units;
                System.out.println("enter kw sanctioned load");
                int kw= in.nextInt();
		int[] fixed_charges={330,275,230,230};
		double[] energy_charge={8.80,8.35,8.00,7.55};
		double amount;
                if(kw<=5)
                {
                    amount=calculate(ut,energy_charge);
                    amount=amount+calculate(ut,fixed_charges);
                }
                else
                {
                    amount=calculate(ut,energy_charge);
                    if(ut>500)
                    {
                        amount=amount+kw*105;
                    }
                    else
                    {
                        amount=amount+kw*95;
                    }
                }
		display(units,amount);
	} 
	public void Street_Lighting_Service(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	public void Agriculture_Service(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	public void Small_Industrial_Service(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	public void Medium_Industrial_Service(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	public void Large_Industrial_Service(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	}
	public void Bulk_Supply_for_Mixed_load(int units)
	{
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount);
	} 
}
