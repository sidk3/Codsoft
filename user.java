import java.util.*;

class atm
{
 //Initial balance is assumed to be 5000.
 static int bal=5000;
 static void withdraw(int amt)
 {
  if(amt>bal)
   System.out.println("Failure in transaction,Amount entered is greater than balance!");
  else
  {
  bal-=amt;
  System.out.println("Withdrawal successfull!");
  }
 }

 static void deposit(int amt)
 {
  bal+=amt;
  System.out.println("Deposit successfull!");
 }

 static int checkBalance()
 {
  return bal;
 }

}

public class user 
{
 public static void main(String[] args)
 {
  atm a=new atm();
  int choice=0;
  String ch="n";
  Scanner s=new Scanner(System.in); 
 do
  {
  System.out.println("Press 1 for withdrawal,2 for deposit,3 for checking balance");

 choice=s.nextInt();
  s.nextLine();

 switch(choice)
 { 
  case 1:
 	 int amtt=0;
         System.out.println("Enter amount to withdraw: ");
         amtt=s.nextInt();
	 s.nextLine();
 	 a.withdraw(amtt);
	 break;

  case 2:
	 int amt1=0;
	 System.out.println("Enter amount to deposit: ");
	 amt1=s.nextInt();
	 s.nextLine();
	 a.deposit(amt1);
	 break;

  case 3:
	 int balance=a.checkBalance();
 	 System.out.println("Balance: "+balance);
	 break;

  default:
	System.out.println("Invalid choice entered,please try again!");
	break;
 }
  System.out.println("Press y for continuing and others for exit: ");
  ch=s.nextLine();
 }while(ch.equals("y"));
 s.close();
 System.out.println("Thank you for using our ATM Interface!");
 }
}