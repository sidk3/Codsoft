import java.util.*;

class t2
{
 public static void main(String[] args)
 {
 Scanner s=new Scanner(System.in);

 //Assuming there are 3 subjects
 int marks[]=new int[3];
 System.out.println("Enter marks obtained in each of the 3 subjects one by one: "); 
 for(int i=0;i<3;i++)
 {
  marks[i]=s.nextInt();
  s.nextLine();
 }
 
 int sum=0;
 double avg;
 char grade='F';
 
 for(int i=0;i<3;i++)
 {
  sum+=marks[i];
 }

 avg=(double)(sum/3);
 
 if(avg>=90)
  grade='A';

 else if(avg>=80)
  grade='B';

 else if(avg>=70)
  grade='C';

 else if(avg>=60)
  grade='D';

 else if(avg>=50)
  grade='E';

 
  System.out.println("Total marks: "+sum);
  System.out.println("Average percentage: "+avg);
  System.out.println("Grade: "+grade);
 }
}