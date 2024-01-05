import java.util.*;

class t1 {
    public static void main(String args[]) {
 Scanner s = new Scanner(System.in);
 int z, x;
 String agg;
 int maxr = 100, minr = 1;
int att, matt = 3;
boolean g;
boolean ag;
do {
z =(int)(Math.random() * 100)+1;
 att = 0;
g = false;
  ag = true;
  while (att < matt) {
    System.out.print("Enter your guess: ");
    x = s.nextInt();
   s.nextLine(); 
   if (z == x) {
    System.out.println("Correct number");
    g = true;
     break;
    } else if (z > x) {
    System.out.println("Number too low");
    } else {
   System.out.println("Number too high");
   }
   att++;
  }
  if (!g) {
     System.out.println("Your chances are completed");
   System.out.println("Correct number was " + z);
    }
   System.out.print("Play again? (y/n): ");
  agg = s.nextLine();
   ag = agg.equals("y");
} while (ag);
System.out.println("Thanks for playing!");
      }
}
