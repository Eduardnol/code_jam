import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eduardo Nolla
 * @version 1.0
 * @since 27/03/2021
 */

public class Solution {

    private static final List<Integer> costs = new ArrayList<>();


    public static void main(String[] args) {
        //Input reader
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNumber = input.nextInt(); //Reads the first int with the total tests

        for (int i = 0; i < testNumber; i++) {
            List<Integer> integerList = new ArrayList<>();
            int elements = input.nextInt();
            //This for adds into the list all the values to be processed
            for (int j = 0; j < elements; j++) {
                integerList.add(input.nextInt());
            }
            reverse(integerList);
        }

        //All info is loaded

        show();


    }


    /**
     * Reverses the list given two values, i (incremental) and j (index of minimum list value)
     *
     * @param integerList list to be applied
     */
    public static void reverse(List<Integer> integerList) {

        int sum = 0;
        for (int i = 0; i < (integerList.size() - 1); i++) { //We want to perform size - 1 operation
            int j = getMin(integerList, i);
            if (integerList.get(j) < integerList.get(i)) {
                Collections.reverse(integerList.subList(i, j + 1));
            }
            sum += (j - i + 1);
        }
        costs.add(sum);
    }


    /**
     * Shows the result of the cost into the screen
     */
    public static void show() {

        for (int i = 0; i < costs.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + costs.get(i));
        }
    }


    /**
     * Finds inside a list the minimum value
     *
     * @param list  list to be searched
     * @param start where is the start point of looking
     * @return index of the lowest value
     */
    private static int getMin(List<Integer> list, int start) {

        int min = list.get(start);
        int index = start;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                index = i;
                min = list.get(i);
            }
        }
        return index;
    }

}
