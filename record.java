/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;
import static newpackage.bill.change_board;
/**     
 *
 * @author lenovo
 */
public class record extends bill  implements electricity
{
	Scanner in=new Scanner(System.in);
	String name,conn_type;
	int units;
	public record()
	{
		int k=0,t;
		while(k==0)
		{
			System.out.println("\n1 calculate amount for particular connection\n2 change board\n3.calculation of all connection  \n4.back");
			t= in.nextInt();
			switch(t)
			{
				case 1:
					bill b1=new bill();
					b1.billing();
					break;
				case 2:
					change_board();
                                        System.out.println("board successfully changed");
					break;
				case 3:
                                        bill b2=new bill();
                                        b2.mubilling();
                                        try
                                        {
                                            Thread.sleep(4000);
                                        }
                                        catch(InterruptedException ex)
                                        {
                                            Thread.currentThread().interrupt();
                                        }
                                        break;
                                case 4:
					k=1;
					break;
			}
		}
	}
	public record(int id)
	{
		System.out.println("enter name");
		name=in.nextLine();
		System.out.println("enter connection type");
		conn_type=in.nextLine();
		System.out.println("id= "+id+" added");
	}
	public void calculate(int id)
	{
		System.out.println("\nenter units");
		units=in.nextInt();
		System.out.println("id :"+id+"\nname:"+name+"\nconnection type:"+conn_type);
		bill temp=new bill();
		temp.billing(units,conn_type);
	}
}