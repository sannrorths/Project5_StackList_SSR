/**
 * CSC6301_Stack_Project5_SopheaSann-Rorth
 * Instructions:
 * Plan and execute a maintenance task to your last project (Project #4) adapting 
 * to be now a Stack and not a LinkedList.
 * 
 * Implement a program that reads a list of Integer numbers from the scan input 
 * and saves them into a Stack sorted from the smallest to the largest:
 * Please make sure this is a maintenance task and you are not re-writing the program from scratch!
 * Use Collections Framework
 * Follow code guidelines and document your code accordingly;
 */

/**
 * Import modules for Stack for stacking, and Scanner to handle inputs.
 * These imports are good examples for reuse codes. They are pre-written.
 *  -java.util.Stack;
 *  -java.util.Scanner;
 * The are reusable; They reduce errors and are efficient.
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Define a class to sort a list of user's input and stack them onto a Stack, print out the input, and 
 * print out the Stack. The main method will continuously take user's input until the user enter "Finish"
 * to break out of the loop. The methods will take inputs, sort, and then will either push or pop the input onto 
 * the Stack according to the values from least to greatest. Invalid input will 
 * loop user back for more inputs or until user type in "Finish" and hit enter to exit the loop: 
 * @author Sophea Sann-Rorth
 * @version 1.0.0
 * @since week  of CSC6301
 */


public class StackList {
    /**
     * Contains the common method for the StackList.
     * Main method implements "while" loop to continuously take user's inputs until user input "Finish".
     * It will loop back to ask for user input if the input is invalid. Organize all inputs according to the value.
     * Inputs will be pushed or popped on the Stack. Print the final sorted Stack.
     * @since week 4 of CSC6301
     */

    public static void main(String[] args) { // For maintenance purpose, this method was a resuse of code from the LinkedList project.
        Scanner sc = new Scanner(System.in);
        // Create a Stack to store integers input
        // Common method as defined by Java Collections Framework
        Stack<Integer> stack = new Stack<>();

        System.out.println("Please enter integers separated by space, when done entering the number, put a space and then type 'Finish', and hit enter:");

        // Continuously takes input, separated by space, from user until user types in "Finish":
        // sc.hasNext checks for more input.
        while (sc.hasNext()) {
            // if there is more input, append it into the stack
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                // Insert the user's input into stack.
                numStack(stack, num); // numStack and stack replaced two items from the previous project.
            } else if (sc.hasNext("Finish")) {
                break; // Type in "Finish" to exit.
            } else {
                System.out.println("Invalid input. Please enter an integer, separated by a space; To exit, put a space after last input, then type in 'Finish', and hit enter.");
                sc.next(); // Process invalid input
            }
        }
        // Print out the Stack from smallest to largest.
        // Print and pop elements when the stack is not empty. 
        // Maintenance: From here is where things are very different from the LinkedList Project. Code changes to accomodate the stacking.
        System.out.println(" The Sorted Stack from smallest to greatest:" + stack);
        while (!stack.isEmpty()) {
            // Print out the top element and remove from the stack
            System.out.println(stack.pop());
        }
        sc.close(); //end user input module
    }
       
    /**
     * The method will pop and push a number(s) into the Stack according to its value.
     * @param temp the integer values to be pushed onto the stack.
     * @param stack is where the temp will be pushed onto.
     * @param numStack is where the top value will be popped.
     */

    private static void numStack(Stack<Integer> stack, int value) {
        // check to see if stack is empty, then add input value onto the stack
        if (stack.isEmpty() || value >= stack.peek()) { // stack.peek() is part of Java Collections Framework
            stack.push(value); // is part of Java Collections Framework
        } else {
            // Pops the value from the top of the stack and assign it temporary variable, then pushes the value of this temp variable onto the stack.
            int temp = stack.pop(); // stack.pop() is part of Java Collections Framework
            numStack(stack, value);
            stack.push(temp); // stack.push() is part of Java Collections Framework
        }
    }
}