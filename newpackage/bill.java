/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.lang.*;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */

public class bill implements Runnable
{
	int a,units;
	final static StringBuffer board=new StringBuffer("");
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
        public void  mubilling()
	{
		Scanner in=new Scanner(System.in);
	
		Thread obj=new Thread(new bill());
                obj.start();	
	}	
        public void run()   
        {
            System.out.println("enter units");
            units= in.nextInt();
            Domestic(units);
            Non_Domestic(units);
            Street_Lighting_Service(units);
            Agriculture_Service(units);
            Small_Industrial_Service(units);
            Medium_Industrial_Service(units);
            Large_Industrial_Service(units);
            Bulk_Supply_for_Mixed_load(units);
        }
	public void  billing()
	{
		Scanner in=new Scanner(System.in);
		
		
		System.out.println("enter units");
                int units= in.nextInt();
                
		System.out.println("enter connection type");
		
		String connection_type=in.nextLine();
		
		
		
                    try
                    {
                        for(int i=0;i<connection.length;i++)
                        {
                            if(connection_type.equals(connection[i]))
                            	a=i+1;
                            else
                                throw new Myexception();
                        }
                    }
                    catch(Myexception e)
                    {
                        System.out.println("The entered connection does not exists");
                    }
		
		conn_type(a,units);
	}	
	public void billing(int units,String connection_type)
	{
		try
                    {
                        for(int i=0;i<connection.length;i++)
                        {
                            if(connection_type.equals(connection[i]))
                            	a=i+1;
                            else
                                throw new Myexception();
                        }
                    }
                    catch(Myexception e)
                    {
                        System.out.println("The entered connection does not exists");
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
			if(ut>150)
			{
				tem=ut-150;
				amount+=tem*energy_charge[1];
				ut=ut-tem;
			}
			if(ut>50)
			{
				tem=ut-50;
				amount+=tem*energy_charge[2];
				ut=ut-tem;
			}
			else
			{
				tem=ut;
				amount+=tem*energy_charge[3];
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
		else if(units>150)
		{
			amount=amount+fixed_charges[1];
		}
		else if(units>50)
		{
			amount=amount+fixed_charges[2];
		}
		else
		{
			amount=amount+fixed_charges[3];
		}
		return amount;
	}
	public void display(int units,double amount,String ch)
	{
		System.out.println("-----billing details------");
		System.out.println("Country: "+country);
		System.out.println("Board: "+board);
		System.out.println("Units: "+units);
                System.out.println("Connection type: "+ch);
		System.out.println("Amount to be paid: "+amount);
		for(int i=0;i<3;i++)
		{
			System.out.println("\n");
		}
		System.out.println("--------------------------");
	}
	public void Domestic(int units)
	{	
                String ch="Domestic";
		int ut=units;
		int[] fixed_charges={285,265,220,200,100};
		double[] energy_charge={7.15,6.70,6.40,6.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge);
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	
	public void Non_Domestic(int units)
	{	
		int ut=units;
                int kw=6;
                String ch="Non_Domestic";
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
		display(units,amount,ch);
	} 
	public void Street_Lighting_Service(int units)
	{
		int ut=units;
                String ch="Street_lighting_service";
		int[] fixed_charges={385,365,320,300,200};
		double[] energy_charge={8.15,7.70,7.40,7.10,3.85};
		double amount;
		amount=calculate(ut,energy_charge)*2;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	public void Agriculture_Service(int units)
	{
		int ut=units;
                String ch="Agriculture_service";
		int[] fixed_charges={390,385,340,310,210};
		double[] energy_charge={8.20,7.80,7.50,7.20,3.95};
		double amount;
		amount=calculate(ut,energy_charge)*2.5;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	public void Small_Industrial_Service(int units)
	{
		int ut=units;
                String ch="Small_Industrial_Service";
		int[] fixed_charges={400,395,350,320,220};
		double[] energy_charge={8.30,7.90,7.60,7.30,4.05};
		double amount;
		amount=calculate(ut,energy_charge)*3;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	public void Medium_Industrial_Service(int units)
	{
		int ut=units;
                String ch="Medium_Industrial_Service";
		int[] fixed_charges={410,405,360,330,230};
		double[] energy_charge={8.40,8.0,7.70,7.40,4.15};
		double amount;
		amount=calculate(ut,energy_charge)*3.5;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	public void Large_Industrial_Service(int units)
	{
		int ut=units;
		String ch="Large_Industrial_Service";
		int[] fixed_charges={420,415,370,340,240};
		double[] energy_charge={8.50,8.10,7.80,7.50,4.25};
		double amount;
		amount=calculate(ut,energy_charge)*4;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	}
	public void Bulk_Supply_for_Mixed_load(int units)
	{
		int ut=units;
		String ch="Large_Industrial_Service";
		int[] fixed_charges={430,425,380,350,250};
		double[] energy_charge={8.60,8.20,7.90,7.60,4.35};
		double amount;
		amount=calculate(ut,energy_charge)*4.5;
		amount=amount+calculate(ut,fixed_charges);
		display(units,amount,ch);
	} 
}
