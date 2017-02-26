/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Saad Akhtar
*/

import java.util.Stack;

public class Saakhta {
 
  //***** fill in your code here *****
  //feel free to add additional methods as necessary
  public static Stack<Integer> s = new Stack<Integer>();
  public static int count = 0;

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

    /*Create empty stack and set current position to 0
      Repeat {
         loop from current position to the last position until a valid position is found //current row
         if there is a valid position {
            push the position to stack, set current position to 0 // move to next row
         }
         if there is no valid position {
            if stack is empty, break // stop search
            else pop from stack, set current position to next position // backtracking to previous row
         }
         if stack has size N { // a solution is found
            pop from stack, set current position to next position // backtracking to find next solution
         }
      }
    */

  public static int solve(int n) {

    //***** fill in your code here *****
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
              //printSolution(s);
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
    //update the following statement to return the number of solutions found
    
  }//solve()
  
  //this method prints out a solution from the current stack
  //(you should not need to modify this method)
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }//for
      System.out.println();
    }//for
    System.out.println();  
  }//printSolution()
  
  // ----- the main method -----
  // (you shouldn't need to change this method)
  public static void main(String[] args) {
  
  int n = 14;
  
  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }//if   
  }//if
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }//main()
  
}