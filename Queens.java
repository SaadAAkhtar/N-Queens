/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Saad Akhtar
*/

import java.util.Stack;
import java.util.Scanner;

public class Queens {

  public static Stack<Integer> s = new Stack<Integer>();
  public static int count = 0;

  //checks if the placement of a queen is valid
  public static boolean checkValidity(int r, int c) {
    for(int x = 0; x < s.size(); x++) {
      int stackQ = s.get(x);

      if (stackQ == c || (c - stackQ) == (r - x) || (stackQ - c) == (r - x)) {
        return false;
      }
    }
    return true;
  }
 
  //finds and prints out all solutions to the n-queens problem
  public static int solve(int n) {
	  
    int z = 0;

    for (int row = 0; row < n; row++) {
      for (int col = z; col < n; col++) {
          if (checkValidity(row, col)) {
            s.push(col);
            if (z >= 1) {
            	z = 0;
            }
            if (s.size() == n) {
              count += 1;
              printSolution(s);
              z = s.pop() + 1;
              if (z == n) {
              	while (z == n) {
            		if (s.isEmpty()) {
            			break;
            		}
              		z = s.pop() + 1;
              		row -= 1;
              	}
              }
              row -= 1;
            }
            break;
          }

          if (checkValidity(row, col) == false && col == (n - 1)) {
            z = s.pop() + 1;
            if (z == n) {
            	while (z == n) {
            		if (s.isEmpty()) {
            			break;
            		}
            		z = s.pop() + 1;
            		row -= 1;
            	}
            }
            row -= 2;
            break;
          }
       }
    }

    return count;
    
  }

  //this method prints out a solution from the current stack
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();  
  }

  public static void main(String[] args) {
  
  Scanner in = new Scanner(System.in);
  
  System.out.println("Please enter in a number x such that 1 <= x <= 12:");
  
  int n = in.nextInt();
  
  if (n < 1 || n > 12) {
    System.out.println("You did not enter a valid number. The program has exited. Please run the program and try again with a valid number.");
    System.exit(0);
  }
  
  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    } 
  }
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }
}
