import java.util.*;
import java.lang.*;
abstract class Cust
{
	abstract void addcust();
	abstract void delete(int j);
	abstract void update(int j);
	abstract void displayCustomer(int j);
}
class Customer extends Cust
{
	static int id[] =new int[100];
	static String name[]=new String[100];
	static String conn_type[]=new String[100];
	static int units[]=new int[100];
	Scanner in=new Scanner(System.in);
	public void addcust()
	{
		for(int i=0;i<100;i++)
		{
			if(id[i]==0)
			{
				id[i]=100+i+1;
				System.out.println("enter name");
				name[i]=in.nextLine();
				System.out.println("enter connection type");
				conn_type[i]=in.nextLine();
				System.out.println("enter units");
				units[i]=in.nextInt();
				
				System.out.println("id="+id[i]+" addeded");
				
				break;
			}
		}
		System.out.println("customer added");
	}
	public void delete(int j)
	{
		for(int i=0;i<100;i++)
		{
			if(id[i]==j)
			{
				id[i]=0;
				name[i]="";
				conn_type[i]="";
				units[i]=0;
				break;
			}
		}
		System.out.println("customer deleted");
	}
	public void update(int j)
	{	
		for(int i=0;i<100;i++)
		{
			if(id[i]==j)
			{
				
				System.out.println("enter new name");
				name[i]=in.nextLine();
				System.out.println("enter connection type");
				conn_type[i]=in.nextLine();
				break;
			}
		}
		System.out.println("customer details updated");
	}
	public void displayCustomer(int j)
	{
		for(int i=0;i<100;i++)
		{
			if(id[i]==j)
			{
				
				System.out.println("name="+name[i]);
		
				System.out.println("\nconnection="+conn_type[i]);
		
				System.out.println("\ntotal units="+units[i]);
			}
		}
	}
}
class Billing extends Customer
{
	int a;
	static StringBuffer board=new StringBuffer("");
	
	final String country="INDIA";
	Scanner in=new Scanner(System.in);
	static String[] connection=new String[]{"DM","NDM","SLS","AG","SIS","MIS","LIS","BSML"};
	static
	{
		board.insert(0,"AVVNL");;	
	}
	static void change_board()
	{
		board.replace(0,5,"JVVNL");
	}

	
	Billing()
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
	Billing(int id)
	{
		String[] connection1=new String[]{"DM","NDM","SLS","AG","SIS","MIS","LIS","BSML"};
		System.out.println("id="+id);
		for(int i=0;i<100;i++)
		{
			if (super.id[i]==id);
			{
				
				for(int j=0;j<connection1.length;j++)
				{
					System.out.println("name="+super.name[i]);
					System.out.println("conn"+super.conn_type[i]);
					System.out.println("conn1"+connection1[j]);
					if(super.conn_type[i].equals(connection1[j]))
					{
					a=j+1;
					break;
					}
				}
				int units=super.units[i];
				conn_type(a,units);
				break;
			}
			
		}
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



final class Main extends Billing
{
	public static void main(String args[])
	{
		if (args[0].equals("run"))
		{
			Cust c1=new Customer();
			Scanner in=new Scanner(System.in);
			int i;
			while(true)
			{
				System.out.println("\n--------------Electricity billing system------------\n");
				System.out.println("\nchoose among the following operation\n");
				System.out.println("\n1. Calculate amount\n2. calculate bill\n3. to customer options\n4. exit");
				i=in.nextInt();
				switch(i)
				{
					case 1:
						int k=0;
						while(k==0)
						{
							System.out.println("\n1 calculate amount\n2 change board\n3 back");
							i= in.nextInt();
							switch(i)
							{
								case 1:
									
									Billing b1=new Billing();
									
									break;
								case 2:
									change_board();
									break;
								case 3:
									k=1;
									break;
							}
						}
						break;
					case 2:
						k=0;
						while(k==0)
						{	
							System.out.println("\n1.for existing \n2. for new\n3. back");
							i=in.nextInt();
							switch(i)
							{
								case 1:
									System.out.println("enter customer id");
									i=in.nextInt();
									Billing b2=new Billing(i);
									break;	
								case 2:
									c1.addcust();
									break;
								case 3:
									k=1;
									break;
							}
						}
						break;
					case 3:
						k=0;
						while(k==0)
						{
							System.out.println("\n1. for new\n2. to display cutomer details\n3. update customer details\n4. delete customer\n5. back");
							i=in.nextInt();
							switch(i)
							{
								case 1:
									
									c1.addcust();
									break;
								case 2:
									
									System.out.println("\nenter customer id\n");
									i=in.nextInt();
									c1.displayCustomer(i);
									break;
								case 3:
									
									System.out.println("\nenter customer id\n");
									i=in.nextInt();
									c1.update(i);
									break;
								case 4:
									
									System.out.println("\nenter customer id\n");
									i=in.nextInt();
									c1.delete(i);
									break;
								case 5:
									k=1;
									break;
						}
						}
						
						break;
					case 4:
						System.out.println("exiting");
						System.exit(0);
								
				}
				
			
			}
		}
		else 
		{
			System.out.println("exiting");
			System.exit(0);
		}
		
	}
}

