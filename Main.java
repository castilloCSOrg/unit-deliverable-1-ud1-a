/********************************************
*	AUTHORS:	Akshay Varadarajan
* COLLABORATORS: none
*	LAST MODIFIED:	10/13/2024
********************************************/

/********************************************
*	Financial Planner for Hispanic Immigrants
*********************************************
*	PROGRAM DESCRIPTION:
* Managing finances is one of the most crucial responsibilities an immigrant will assume.
  Poor fininacial decisions can negatively impact the children of immigrants already have many challenges.  
  This financial planner will convert Pesos to Dollars and then create a monthly plan. 
  This will give immigrants a tool to save money once they arrive in the US.
  Article: "DACA Recipients Look To Supreme Court For Hope"
*********************************************
*	ALGORITHM:
*	Ask user for budget
  Convert to Dollars
  Create a plan based on the budget
*********************************************
*	STATIC METHODS:
* peso_to_dollar
  printplan
  abolute_value
*********************************************/

import java.util.Scanner;
import java.lang.Math;

public class Main 
{
  /***** CONSTANT SECTION *****/
  public static final String decor_line = "**********************************************";

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/

    // Creates scanner object for obtaining user input
    Scanner scanner = new Scanner(System.in);
    
    double rent;
    double grocery;
    double bills;
    double savings;
    /***** INITIALIZATION SECTION *****/

    /***** INTRO SECTION *****/

    // Query for user information
    System.out.println("What is your monthly budget: ");
    System.out.print("Cuál es tu presupuesto mensual: ");
    double budget = scanner.nextDouble();

    System.out.println("What is your rent: ");
    System.out.print("Cuál es su alquiler: ");
    rent = scanner.nextInt();

    System.out.println("What is your monthly bills: ");
    System.out.print("Cuáles son sus facturas mensuales: ");
    bills = scanner.nextInt();

    /***** PROCESSING SECTION *****/
    budget = peso_to_dollar(budget);

    //Calculations for budget
    grocery = (budget - rent - bills) * 0.6; 
    grocery = (Math.abs(grocery) + grocery) / 2;
    savings =  budget - rent - bills - grocery;
    savings =  (Math.abs(savings) + savings) / 2;

    /***** OUTPUT SECTION *****/
    printplan(decor_line, budget, rent, bills, grocery, savings);

    //close scanner object
    scanner.close();
  }
  /***** STATIC METHODS *****/

  //Converts the user's budget from Pesos to Dollars
  public static double peso_to_dollar(double budget)
  {
      budget = budget * 0.052;
      return budget;
  }

  //Prints out the Budget using string formatting tools.
  public static void printplan(String line, double budget, double rent, double bills, double grocery, double savings)
  {
    System.out.println(line);
    System.out.printf("(Budget)  Presupuesto en pesos: %12.2f \n", budget/0.052);
    System.out.printf("(Budget)  Presupuesto en dólares: %10.2f \n", budget);
    System.out.printf("(Rent)    Alquilarr en dólares:   %10.2f \n", rent);
    System.out.printf("(Bills)   Facturas en dólares: %13.2f\n", bills);
    System.out.printf("(Grocery) Comestibles en dólares: %10.2f\n", grocery);
    System.out.printf("(Savings) Ahorros en dólares: %14.2f\n", savings);
    System.out.println(line);
  }
}
