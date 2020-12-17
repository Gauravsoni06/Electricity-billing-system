import java.util.*;
import java.lang.*;
import newpackage.*;


class ele extends record
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		record r[]=new record[100];
                
            
		int i,id=0,k;
                while(true)
                {
                        System.out.println("\n--------------Electricity billing system------------\n");
                        System.out.println("\nchoose among the following operation\n");
                        System.out.println("\n1.Calculate amount\n2.calculate bill\n4. exit");
                        i=in.nextInt();

                        switch(i)
                        {
                                case 1:
                                        record re1=new record();
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
                                                                try{
                                                                r[i].calculate(i);
                                                                }
                                                                catch(NullPointerException e){
                                                                        System.out.println("The entered number does not exists");
                                                                }
                                                                break;	
                                                        case 2:
                                                                r[id]=new record(id);
                                                                id=id+1;
                                                                 
                                                                   
                                                                break;
                                                        case 3:
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
}

