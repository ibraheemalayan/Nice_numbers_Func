import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        System.out.println(" enter left > ");

        int left = scanner.nextInt();

        System.out.println(" enter right > ");

        int right = scanner.nextInt();

        System.out.println(" enter digit to exclude  > ");

        int m = scanner.nextInt();

        niceNumbers(left, right, m);    

        
    }

    public static void niceNumbers(int left, int right, int m){
        
        int numbers_count = left - right;

        // Loop through numbers
        for(int num = left ; num < right + 1 ; num ++){

            boolean is_nice = true;

        int count = 0;
        int tmp_num = num;

        // count the num digits eg: num > 8745 count will be 4
        while(tmp_num != 0)
        {
            // num = num/10
            tmp_num /= 10;
            ++count;
        }

        tmp_num = num;

        // array of (num) digits (reversed order) eg: num > 3456 array will be {0,0,0,0}
        int[] digits_arr = new int[count];

        // fill digits_arr eg: num > 3367 array will be {7,6,3,3} (also checks each digit if it matches m (the excluded value) )
        for( int i = 0 ; i < digits_arr.length ; i ++){

            digits_arr[i] = tmp_num % 10;

            if (digits_arr[i]==m){
                is_nice=false;
                break;
            }
            
            tmp_num /= 10;
        }

        // the actual code that checks if a nice number
        if (is_nice) {

            int sum_rights = digits_arr[0];

            for(int k = 1 ; k < digits_arr.length ; k ++ ){
                if( digits_arr[k] <= sum_rights ){
                    is_nice = false;
                    break;
                }
                sum_rights += digits_arr[k];
            }
        }
            // print num if matches cons
            if(is_nice){
                System.out.println( num  + ", ");
            }

        }
        
    }
}