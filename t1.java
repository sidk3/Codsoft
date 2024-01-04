import java.util.*;

class t1
{
 public static void main(String args[])
 {
  Scanner s=new Scanner(System.in);

  int z;
  String agg="";
  int maxr=100,minr=1;
  int att=0,matt=3;
  boolean g=false;
  boolean ag=true;
  while(ag)
  {
   System.
  while(att<matt)
  {
  if(z==x)
  {
   System.out.println("Correct number");
   g=true;
   att++;
   break;
  }
  else if(z>x)
   {
   System.out.println("Number too high");
   att++;
   }
  else if(z<x)
   {
   System.out.println("Number too low");
   att++;
   }
   }
  if(!g)
   System.out.println("Your chances are completed");

 System.out.println("Correct number was "+z);
 System.out.println("Play again?(y/n)");
 s.nextLine();
 agg=s.nextLine();
 ag=agg.equals("y");
   }
  }
  System.out.println("Thanks for playing!");
  
 }
}