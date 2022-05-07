/*
** Bubble Sort sample w/ random array
*/
import java.util.Arrays;

public class BurbujaSimple {

    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {                                       
                if (arr[i] > arr[i + 1]) {                          
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }                
        }
    }

    public static void main (String[] args) {
        // declares an array of integers
        int[] anArray;

        // allocates memory for 10 integers
        anArray = new int[10];
            
        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 6223;
        anArray[6] = 703;
        anArray[7] = 8440;
        anArray[8] = 2300;
        anArray[9] = 1000;



        bubbleSort(anArray);
        for (int i = 0; i < anArray.length; i++) {
            System.out.println(anArray[i]);
        }
    }
}