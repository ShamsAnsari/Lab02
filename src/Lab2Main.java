public class Lab2Main {
    public static void main(String[] args){

    }

    /**
     * Iteratively calculates whether every element is a prime number in the array
     * @param arr array of ints
     * @param size size of array
     * @return true if every element is a prime. False otherwise
     */
    public static boolean isPrimeArrayIter(int[] arr, int size){
        System.out.println("Entering isPrimeArrayIter");
        for(int n: arr){
            if(n <= 3 ){
                return n > 1;
            }
            if(n % 2 == 0 || n % 3 == 0){
                return false;
            }
            for(int i = 5; i*i <= n; i += 6){
                if(n % i  == 0 ||  n % ( i + 2) == 0){
                    return false;
                }
            }
        }
        System.out.println("Leaving isPrimeArrayIter");
        return true;
    }

    /**
     * Recursively calculates whether every element is a prime number in the array
     * @param arr array of ints
     * @param size size of array
     * @return true if every element is a prime. False otherwise
     */
    public static boolean isPrimeArrayRecur(int[] arr, int size){
        System.out.println("Entering isPrimeArrayRecur");
        System.out.println("Leaving isPrimeArrayRecur");
    }

    public static boolean isPrime(int num){

    }
}
