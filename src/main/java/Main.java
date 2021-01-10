import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //creates and initializes the expenses array
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        //prints out starting message
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        //calls the operational method
        optionsSelection(expenses);

    }
    //allows the user to go through and choose any action that is wanted
    private static void optionsSelection(ArrayList<Integer> expenses) {
        //creates an array holding the options available to the user
        String[] theOptions = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditures",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        //creates a scanner
        Scanner sc = new Scanner(System.in);
        int  options;
        do {//gets the user input and handles it accordingly
            //prints all possible actions
            for(String option:theOptions){
                System.out.println(option);
                    // display the all the Strings mentioned in the String array
            }
            //gets user input
            System.out.println("\nEnter your choice:\t");
            options =  sc.nextInt();

            switch (options){//handles user input
                case 1://show all expenses
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses+"\n");
                    break;
                case 2://enters a new expense to the arraylist
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    break;
                case 3://deletes all expenses
                    //double checks with the user
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if(con_choice==options){//either deletes or keeps all files based on second input
                        expenses.clear();
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    break;
                case 4://sorts the arraylist
                    sortExpenses(expenses);
                    break;
                case 5://searches the arraylist for a given value
                    Integer searchVal;
                    //gets the value of the expenditure from the user
                    System.out.println("Enter the expense to need to search:\t");
                    searchVal=sc.nextInt();
                    //searches
                    searchExpenses(expenses,searchVal);
                    break;
                case 6://closes the program
                    System.out.println("Closing your application... \nThank you!");
                    break;
                default://handles any inputs out of the scope
                    System.out.println("You have made an invalid choice!");
                    break;
            }
        }while(options!=6);//when 6 is entered, the loop ends, ending the program

    }
    //iteratates through all expenses to see if the given value is in the arraylist
    private static void searchExpenses(ArrayList<Integer> arrayList, Integer value) {
        boolean foundResult=false;
        int index=0;
        //searches for the given value
        for(int expense: arrayList) {

            if (expense == value) {
                foundResult = true;
                index=arrayList.indexOf(expense);
            }
        }//prints out the appropriate response based on the previous search
        if(foundResult){
            System.out.println("The expense "  + value + " has been found " +
                    "at index: "+ index);
        }else{
            System.out.println("The expense " + value +" cannot be found" );
        }
    }
    //sorts the array using the collections method
    private static void sortExpenses(ArrayList<Integer> arrayList) {

        Collections.sort(arrayList);
        System.out.println("Expenses In Order");
        System.out.println((arrayList+"\n"));

    }
}
