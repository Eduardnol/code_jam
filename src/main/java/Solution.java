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

    private static List<Integer> costs = new ArrayList<>();
    private static List<Integer> integerList = new ArrayList<>();


    public static void main(String[] args) {
        //Input reader
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNumber = input.nextInt();

        for (int i = 0; i < testNumber; i++) {
            int elements = input.nextInt();
            for (int j = 0; j < elements; j++) {
                integerList.add(input.nextInt());
            }
            reverse();
        }

        //All info is loaded

        show();


    }


    public static void reverse() {

        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            int j = getMin(integerList, i);
            if (integerList.get(j) < integerList.get(i)) {
                Collections.swap(integerList, j, i);
            }
            sum += (j - i + 1);
        }
        costs.add(sum);
    }


    public static void show() {

        for (int i = 0; i < costs.size(); i++) {
            System.out.println("Case #" + (i + 1) + ':' + costs.get(i));
        }
    }


    private static int getMin(List<Integer> list, int start) {

        int min = list.get(start);
        int minIndex = start;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                minIndex = i;
                min = list.get(i);
            }
        }
        return minIndex;
    }

}
