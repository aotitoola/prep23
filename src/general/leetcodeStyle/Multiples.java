package general.leetcodeStyle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Question: Given 4 input in form of (x,y,z,n) return numbers in range [1,n] where n is
// included which are multiple of x or y but not z.
// For example (3,4,5,12) answer would be [3,4,6,8,9,12]
public class Multiples {

    public static void main(String[] args) {

        int[] input = new int[]{3, 4, 5, 12};

        int divisorX = input[0];
        int divisorY = input[1];
        int divisorZ = input[2];
        int end = input[3];

        List<Integer> output = new ArrayList<>();

        for (int i = 1; i <= end; i++) {
            if (multipleOf(i, divisorX) || multipleOf(i, divisorY)) {
                if (!multipleOf(i, divisorZ)) {
                    output.add(i);
                }
            }
        }

        System.out.println(Arrays.toString(output.toArray()));
    }

    public static boolean multipleOf(int num, int divisor) {
        return num % divisor == 0;
    }
}
