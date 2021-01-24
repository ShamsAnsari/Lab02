/**
 * Lab 2 - Iteration vs Recursion
 * Purpose: demonstrate iteration and recursion
 *
 * @author Shams Ansari
 */
import java.util.Scanner;

public class Lab2Main {
    public static void main(String[] args) {
        final int SORT_MAX_SIZE = 16;


        int length = getUserInput(1, SORT_MAX_SIZE, "Enter array length: ");
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = getUserInput(1, 99, "\tarray[" + i + "] = ");
        }

        System.out.println(isPrimeArrayIter(arr, length) ? "\tPrime Array using iteration" : "\tNot a Prime Array using " +
                "iteration");
        System.out.println(isPrimeArrayRecur(arr, length) ? "\tPrime Array using recursion" : "\tNot a Prime Array using " +
                "recursion");

    }

    /**
     * Iteratively calculates whether every element is a prime number in the array
     * This method uses 6k+1 optimized trial by division method of finding a prime
     *
     * psuedocode:
     * loop arr:
     *      if(arr[i] is not a prime)
     *          return false
     * return true
     *
     * @param arr  array of ints
     * @param size size of array
     * @return true if every element is a prime. False otherwise
     */
    public static boolean isPrimeArrayIter(int[] arr, int size) {
        System.out.println("Entering isPrimeArrayIter");
        for (int n : arr) {
            if (!isPrimeIter(n)) {
                return false;
            }
        }
        System.out.println("Leaving isPrimeArrayIter");
        return true;
    }

    /**
     * Iteratively calculated whether a number is a prime.
     * This method uses 6k+1 optimized trial by division method of finding a prime
     *
     * pseudocode:
     * if( number less than 3)
     *      if number is 0, 1 return false. 2,3 return true
     * if( number is divisible by 2 or 3)
     *      return false
     * check  if  n has a multiple between 5 and  sqrt(n)
     * - increment by 6 to skip repeats ( ex: n%2, n%3, n%5)
     *
     * @param n number
     * @return true if n is a prime,  false otherwise
     */
    public static boolean isPrimeIter(int n) {
        System.out.println("Entering isPrimeIter");
        if (n <= 3) {
            return n > 1;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        //check  if  n has a multiple between 5 and  sqrt(n)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        System.out.println("Leaving isPrimeIter");
        return true;
    }

    /**
     * Recursively calculates whether every element is a prime number in the array
     * This method uses 6k+1 optimized trial by division method of finding a prime
     *
     * @param arr  array of ints
     * @param size size of array
     * @return true if every element is a prime. False otherwise
     */
    public static boolean isPrimeArrayRecur(int[] arr, int size) {
        System.out.println("Entering isPrimeArrayRecur");
        System.out.println("Leaving isPrimeArrayRecur");
        return isPrimeArrayRecurHelper(arr, size, 0);
    }

    /**
     * Wrapper method for isPrimeArrayRecur.
     * Pseudocode:
     * check if loop is done
     * check if number is prime
     * loop
     *
     * @param arr  array of ints
     * @param size size of array
     * @param i    current index
     * @return true if every element is a prime. False otherwise
     */
    public static boolean isPrimeArrayRecurHelper(int[] arr, int size, int i) {

        System.out.println("Entering isPrimeArrayRecurHelper");
        //Check if loop is finished
        if (i >= size) {
            return true;
        }
        //Check if number is prime
        if (!isPrimeRecur(arr[i])) {
            return false;
        }

        System.out.println("Leaving isPrimeArrayRecurHelper");
        return isPrimeArrayRecurHelper(arr, size, ++i);

    }

    /**
     * Calculated whether a number is a prime number
     * This method uses 6k+1 optimized trial by division method of finding a prime
     * <p>
     * if( number less than 3)
     *      if number is 0, 1 return false. 2,3 return true
     * if( number is divisible by 2 or 3)
     *      return false
     * call helper
     *
     * @param n number
     * @return True if n is a prime, false otherwise
     */
    public static boolean isPrimeRecur(int n) {
        System.out.println("Entering isPrimeRecur");

        if (n <= 3) {
            return n > 1;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        System.out.println("Leaving isPrimeRecur");
        return isPrimeRecurHelper(n, 5);
    }

    /**
     * isPrimeRecur helper method. For the division loop
     * <p>
     * pseudocode:
     * check if i > sqrt(n):
     *      return true
     * if( n is a multiple of i or i + 2)
     *      return false
     * i += 6
     * call method again
     *
     * @param n number
     * @param i internal index of tral
     * @return true if n is prime, false otherwise. Note: Not supposed to be called by any
     * othermethods
     */
    public static boolean isPrimeRecurHelper(int n, int i) {
        System.out.println("Entering isPrimeRecurHelper");
        if (i * i > n) {
            return true;
        }
        if (n % i == 0 || n % (i + 2) == 0) {
            return false;
        }
        i += 6;
        System.out.println("Leaving isPrimeRecurHelper");
        return isPrimeRecurHelper(n, i);
    }


    /**
     * Gets user input (int) and validates in loop
     *
     * @param lowerBound
     * @param upperBound
     * @param msg        message before  user enter input
     * @return user input
     */
    public static int getUserInput(int lowerBound, int upperBound, String msg) {

        Scanner scan = new Scanner(System.in);

        int input;
        while (true) {
            System.out.print(msg);
            input = scan.nextInt();
            if (input <= upperBound && input >= lowerBound) {
                break;
            }
            System.out.println("\tBounds of input: [" + lowerBound + ", " + upperBound + "]");
        }
        return input;

    }
}
